package models;

import com.avaje.ebean.Model;
import com.avaje.ebean.common.BeanList;
import com.fasterxml.jackson.annotation.JsonIgnore;
import models.Securite.EntiteSecurise;
import models.Utils.Utils;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Guillaume on 25/01/2016.
 */
@Entity
@Table
@DiscriminatorValue("PROJET")
public class Projet extends EntiteSecurise {
    private static int LIMITE_PROJET_PRESQUE_FINI = 80;

    public String nom;
    public String description;

    @ManyToOne
    @JoinColumn
    public Utilisateur responsableProjet;

    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateDebutTheorique;
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateFinTheorique;
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateDebutReel;

    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateFinReelTot;
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateFinReelTard;

    public Double chargeInitiale;
    public Double chargeConsommee;
    public Double chargeRestante;
    public Byte avancementGlobal;
    public Boolean enCours;
    public Boolean archive;

    @ManyToOne
    @JoinColumn
    public Client client;

    @Constraints.Min(1)
    @Constraints.Max(3)
    public Integer priorite;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Tache")
    @JsonIgnore
    public List<Tache> listTaches;

    public UniteProjetEnum unite;

    final String DATE_PATTERN = "dd/MM/yyyy";
    final String DATE_PATTERN_TRI = "yyyy/MM/dd";
    final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
    final SimpleDateFormat dateFormatTri = new SimpleDateFormat(DATE_PATTERN_TRI);

    public static Model.Finder<Long, Projet> find = new Model.Finder<>(Projet.class);

    public Projet(String nom, String description, Utilisateur responsableProjet, Date dateDebutTheorique, Date dateFinTheorique,
                  Date dateDebutReel, Date dateFinReelTot, Date dateFinReelTard, Double chargeInitiale, UniteProjetEnum unite,
                  Byte avancementGlobal, Boolean enCours, Boolean archive, Client client, Integer priorite, List<Tache> listTaches) {
        this.nom = nom;
        this.description = description;
        this.responsableProjet = responsableProjet;
        this.dateDebutTheorique = dateDebutTheorique;
        this.dateFinTheorique = dateFinTheorique;
        this.dateDebutReel = dateDebutReel;
        this.dateFinReelTot = dateFinReelTot;
        this.dateFinReelTard = dateFinReelTard;
        this.chargeInitiale = chargeInitiale;
        this.unite = unite;
        this.avancementGlobal = avancementGlobal;
        this.enCours = enCours;
        this.archive = archive;
        this.client = client;
        this.priorite = priorite;
        this.listTaches = (listTaches == null)?new BeanList<>():listTaches;
    }

    public Projet() {
        this.listTaches = new BeanList<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        try {
            Projet projet = (Projet) obj;
            return (projet.id.equals(this.id) && projet.nom.equals(this.nom) &&
                    projet.description.equals(this.description) &&
                    projet.dateDebutTheorique.equals(this.dateDebutTheorique) &&
                    projet.dateFinTheorique.equals(this.dateFinTheorique) &&
                    projet.dateDebutReel.equals(this.dateDebutReel) &&
                    projet.dateFinReelTot.equals(this.dateFinReelTot) &&
                    projet.dateFinReelTard.equals(this.dateFinReelTard) &&
                    projet.chargeInitiale.equals(this.chargeInitiale) &&
                    projet.avancementGlobal.equals(this.avancementGlobal) &&
                    projet.enCours.equals(this.enCours) &&
                    projet.archive.equals(this.archive) &&
                    projet.priorite.equals(this.priorite) &&
                    Utils.isEqualList(projet.listTaches,listTaches));
        } catch (ClassCastException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Projet : ").append(id).append("] : ").append(nom).append(", ").append(description);
        sb.append("\nDebutTH : ").append(dateDebutTheorique).append(", FinTH : ").append(dateFinTheorique);
        sb.append(", DebutRE : ").append(dateDebutReel).append(", FinRETôt : ").append(dateFinReelTot).append(", FinRETard : ").append(dateFinReelTard);
        sb.append("\nChargeInitiale : ").append(chargeInitiale).append(", Avancement (%) : ").append(avancementGlobal);
        sb.append(", En cours : ").append(enCours).append(", archive : ").append(archive);
        sb.append(", Priorite :").append(priorite).append("\n");
        if (client != null) {
            sb.append("Client : ").append(client.nom);
        }
        if (listTaches != null) {
            for (Tache tache : listTaches) {
                sb.append("\n").append(tache.nom).append("\n");
            }
        }
        return sb.toString();
    }

    /** !!! A NE JAMAIS APPELER DANS LES PAGES HTML !!!
     * Ajouter la tache en parametre a la liste des taches du projet
     * @param tache
     */
    @Transient
    private void ajouterTache(Tache tache) throws IllegalArgumentException {

        // Met a jour le parent
        if(tache.hasParent()){
            if(tache.parent.enfants == null)
                tache.parent.enfants = new BeanList<>();

            if(!tache.parent.enfants.contains(tache)){
                tache.parent.enfants.add(tache);
                tache.parent.save();
            }
        }

        // Met a jour les enfants
        if(tache.enfants != null && !tache.enfants.isEmpty()){
            for(Tache enfant : tache.enfants){
                enfant.parent = tache;
                enfant.save();
            }
        }

        // Met a jour le prédécesseur
        if(tache.hasPredecesseur()){
            if(tache.predecesseur.successeurs == null)
                tache.predecesseur.successeurs = new BeanList<>();

            if(!tache.predecesseur.successeurs.contains(tache)){
                tache.predecesseur.successeurs.add(tache);
                tache.predecesseur.save();
            }
        }
        // Met a jour les successeur
        if(tache.hasSuccesseur()){
            for(Tache successeur : tache.successeurs){
                successeur.predecesseur = tache;
                successeur.save();
            }
        }
        tache.projet = this;
        tache.save();
        listTaches.add(tache);
        // TODO : mettre a jour les charges des taches meres
        // TODO : mettre a jour les charges du projet + avancement + chemin critique
        save();
    }

    /**
     * Méthode uniquement appelée lorsque le projet n'a aucune tâche
     * @param tache
     * @throws IllegalArgumentException
     */
    public void creerTacheInitialisationProjet(Tache tache) throws IllegalArgumentException {
        if (listTaches.contains(tache)) {
            throw new IllegalArgumentException("Le projet " + this.nom + ", contient deja la tache " + tache.nom +
                    ", creation impossible");
        }
        tache.idTache = "1";
        tache.niveau = 0;
        tache.parent = null;
        tache.enfants = new BeanList<>();
        ajouterTache(tache);
    }

    /**
     * A appeler quand on fait Créer une tache au dessus
     * @param tache
     * @param tacheDejaInseree
     * @throws IllegalArgumentException
     */
    public void creerTacheAuDessus(Tache tache, Tache tacheDejaInseree) throws IllegalArgumentException{
        // Vérifications initiales
        if(!listTaches.contains(tacheDejaInseree)){
            throw new IllegalArgumentException("Le projet " + this.nom + " ne contient pas la tache "+tacheDejaInseree.nom);
        }
        if (listTaches.contains(tache)) {
            throw new IllegalArgumentException("Le projet " + this.nom + ", contient deja la tache " + tache.nom +
                    ", creation impossible");
        }

        // Même niveau et parent que la tache en dessous
        tache.niveau = tacheDejaInseree.niveau;
        tache.parent = (tacheDejaInseree.parent == null)?null:tacheDejaInseree.parent;

        // Pas d'enfant
        tache.enfants = new BeanList<>();

        // Id de la tache est l'id de la tache qui va etre en dessous. Modification des id des autres taches ci-dessous
        tache.idTache = tacheDejaInseree.idTache;

        // Modification de l'id des autres taches

        String[] idTacheParse = tache.idTache.split("\\.");
        int idTacheInteger = Integer.parseInt(idTacheParse[tache.niveau]);

        for(Tache tacheDuProjet : listTaches){
            if(!tacheDuProjet.equals(tache) && tacheDuProjet.niveau >= tache.niveau){
                // On parse l'id(=A.B.C.D) pour avoir A, B, C et D
                String[] idTacheDuProjetParse = tacheDuProjet.idTache.split("\\.");
                int idTacheDuProjetInteger = Integer.parseInt(idTacheDuProjetParse[tache.niveau]);

                // Pour faire le changement : le prefixe doit être identique, et a l'indice niveau, ça doit être >=
                // (car il faut modifier aussi tacheDejaInseree qui a le meme id)
                if(samePrefix(idTacheDuProjetParse, idTacheParse, tache.niveau) && idTacheDuProjetInteger >= idTacheInteger){
                    tacheDuProjet.idTache = reconstituerIdTache(idTacheDuProjetParse, idTacheDuProjetInteger+1, tache.niveau);
                    tacheDuProjet.save();
                }
            }
        }

        ajouterTache(tache);
        save();
    }


    /**
     * A appeler quand on fait Créer une tache en dessous
     * @param tache
     * @param tacheDejaInseree
     * @throws IllegalArgumentException
     */
    public void creerTacheEnDessous(Tache tache, Tache tacheDejaInseree) throws IllegalArgumentException{
        // Vérifications initiales
        if(!listTaches.contains(tacheDejaInseree)){
            throw new IllegalArgumentException("Le projet " + this.nom + " ne contient pas la tache "+tacheDejaInseree.nom);
        }
        if (listTaches.contains(tache)) {
            throw new IllegalArgumentException("Le projet " + this.nom + ", contient deja la tache " + tache.nom +
                    ", creation impossible");
        }

        // Même niveau et parent que la tache en dessous
        tache.niveau = tacheDejaInseree.niveau;
        tache.parent = (tacheDejaInseree.parent == null)?null:tacheDejaInseree.parent;

        // Pas d'enfant
        tache.enfants = new BeanList<>();

        // Id de la tache est l'id de la tache qui va etre au dessus +1. Modification des id des autres taches ci-dessous
        tache.idTache = tacheDejaInseree.idTache;
        String[] idTacheParse = tache.idTache.split("\\.");
        int idTacheInteger = Integer.parseInt(idTacheParse[tache.niveau]);
        // Modification de idTache
        idTacheInteger++;
        // Mise a jour de idTacheParse
        idTacheParse[tache.niveau] = "" + idTacheInteger;
        // Reconstitution de idTache - TODO A VERIFIER !
        tache.idTache = reconstituerIdTache(idTacheParse, idTacheInteger, tache.niveau);

        // Modification de l'id des autres taches
        for(Tache tacheDuProjet : listTaches){
            if(!tacheDuProjet.equals(tache) && tacheDuProjet.niveau >= tache.niveau){
                // On parse l'id(=A.B.C.D) pour avoir A, B, C et D
                String[] idTacheDuProjetParse = tacheDuProjet.idTache.split("\\.");
                int idTacheDuProjetInteger = Integer.parseInt(idTacheDuProjetParse[tache.niveau]);

                // Pour faire le changement : le prefixe doit être identique, et a l'indice niveau, ça doit être >
                if(samePrefix(idTacheDuProjetParse, idTacheParse, tache.niveau) && idTacheDuProjetInteger > idTacheInteger){
                    tacheDuProjet.idTache = reconstituerIdTache(idTacheDuProjetParse, idTacheDuProjetInteger+1, tache.niveau);
                    tacheDuProjet.save();
                }
            }
        }
        ajouterTache(tache);
        save();
    }

    /**
     * Créer une sous-tâche à la tache parent
     * @param tache
     * @param parent
     * @throws IllegalArgumentException
     */
    public void creerSousTache(Tache tache, Tache parent) throws IllegalArgumentException{
        // Vérifications initiales
        if(parent.niveau > Tache.NIVEAU_MAX){
            throw new IllegalArgumentException("La tache " + parent.nom +
                    " ne peut pas avoir de sous-tâche car elle est déjà au niveau de profondeur maximum ("+Tache.NIVEAU_MAX + ")");
        }
        if(!listTaches.contains(parent)){
            throw new IllegalArgumentException("Le projet " + this.nom + " ne contient pas la tache "+parent.nom);
        }
        if (listTaches.contains(tache)) {
            throw new IllegalArgumentException("Le projet " + this.nom + ", contient deja la tache " + tache.nom +
                    ", creation impossible");
        }

        // Même niveau et parent que la tache en dessous
        tache.niveau = parent.niveau+1;

        // Parent est le parent de la tache. Mise a jour de la liste des enfants de 'parent' dans la methode 'ajouterTache'
        tache.parent = parent;

        // Pas d'enfant
        tache.enfants = new BeanList<>();

        // Si le parent a l'id 'A.B.C', alors tache a l'id 'A.B.C.1'
        tache.idTache = parent.idTache + ".1";

        ajouterTache(tache);
        save();
    }

    /**
     * Vérifie si deux taches ont le meme prefixe pour leur idTache
     * @param idTacheDuProjetParse
     * @param idTacheParse
     * @param niveau
     * @return
     */
    private boolean samePrefix(String[] idTacheDuProjetParse, String[] idTacheParse, int niveau){
        // Condition pour faire le changement : il faut que ce qui précède l'id à l'indice niveau soit égal
        for(int i=0; i<niveau; i++){
            if(idTacheDuProjetParse[i].equals(idTacheParse[i]))
                return false;
        }
        return true;
    }

    /**
     * Reconstitue idTache d'une tache en modifiant a l'indice niveau par newIdTacheInteger
     * @param idTacheParse
     * @param newIdTache
     * @param niveau
     * @return
     */
    private String reconstituerIdTache(String[] idTacheParse, int newIdTache, int niveau){
        String idTache = "";
        // Même debut entre 0 et niveau-1
        for(int i=0; i<niveau; i++){
            idTache += idTacheParse[i] + ".";
        }
        // Modification a l'indice niveau
        idTache += newIdTache + ".";

        // Meme fin entre niveau+1 et fin
        for(int i=niveau+1; i<=3; i++){
            idTache += idTacheParse[i] + ".";
        }
        return idTache.substring(0, idTache.length()-1);
    }


    /**
     * TODO testme
     * Modifie la tache en parametre
     *
     * @param tache
     * @throws IllegalArgumentException
     */
    @Transient
    public void modifierTache(Tache tache) throws IllegalArgumentException {
        if (!listTaches.contains(tache)) {
            throw new IllegalArgumentException("Le projet " + this.nom + ", ne contient pas la tache " + tache.nom +
                    ", modification impossible");
        }

        //TODO modifier tâche
        tache.update();
    }

    /**
     * Supprimer la tâche du systeme si elle n'a pas ete commencee (chargeConsommee == 0), l'archive sinon
     * @param tache
     * @throws IllegalArgumentException
     */
    @Transient
    public void supprimerTache(Tache tache) throws IllegalArgumentException {
        if (!listTaches.contains(tache)){
            throw new IllegalArgumentException("Le projet " + this.nom + ", ne contient pas la tache " + tache.nom +
                    ", suppression impossible");
        }
        listTaches.remove(tache);

        /* Liaisons */
        if(tache.predecesseur != null && tache.getSuccesseurs().size()!=0){

            Tache tAvant = tache.predecesseur;
            tAvant.successeurs.remove(tache);

            List<Tache> taches = tache.getSuccesseurs();
            taches.forEach(t -> {
                t.predecesseur = null;
                tAvant.associerSuccesseur(t);
                t.save();
            });
            tAvant.save();
        }else if(tache.predecesseur != null){
            Tache tAvant = tache.predecesseur;
            tAvant.successeurs.remove(tache);
            tAvant.save();
        }else if(tache.getSuccesseurs().size()!=0){
            tache.getSuccesseurs().forEach(t -> t.predecesseur = null);
        }

        /* Suppression/archivage */
        if (tache.getChargeConsommee() == 0.0) {
            Tache.find.deleteById(tache.id);
        }else{
            tache.archive = true;
            tache.save();
        }
    }

    /**
     * Affecte l'utilisateur en parametre en tant que responsableProjet du projet
     *
     * @param responsable
     * @throws IllegalStateException
     */
    @Transient
    public void associerResponsable(Utilisateur responsable) throws IllegalStateException {
        if (this.responsableProjet != null) {
            throw new IllegalStateException("Il y a deja un responsableProjet pour ce projet");
        }
        responsable.save();
        this.responsableProjet = responsable;
        this.save();
    }

    /**
     * TODO testme
     * Modifie le responsableProjet de projet par l'utilisateur en parametre
     *
     * @param responsable
     * @throws IllegalArgumentException
     */
    @Transient
    public void modifierResponsable(Utilisateur responsable) throws IllegalArgumentException {
        if (this.responsableProjet == responsable) {
            throw new IllegalArgumentException("Remplacement du responsableProjet de projet par le même responsableProjet");
        }
        this.responsableProjet = responsable;
    }

    /**
     * TODO testme
     * Associe le projet courant au client passé en parametre
     *
     * @param client
     * @throws IllegalStateException
     */
    @Transient
    public void associerClient(Client client) throws IllegalStateException {
        if (this.client != null) {
            throw new IllegalStateException("Il y a deja un client pour ce projet");
        }
        this.client = client;
    }

    public void calculeCheminCritique(){
        // Récupération des tâches qui sont à la toute fin
        List<Tache> listTachesFin = new ArrayList<Tache>();
        for(Tache tache : listTaches){
            tache.critique = false; // on réinitialise tous les champs 'critique'
            if(!tache.hasSuccesseur()){
                listTachesFin.add(tache);
            }
        }

        // Récupération de la tâche ayant le moins de marge
        Tache tacheAvecMoinsMarge = listTachesFin.get(0);
        for(int i=1; i<listTachesFin.size(); i++){
            Tache tmp = listTachesFin.get(i);
            if((tmp.dateFinTard.getTime() - tmp.dateFinTot.getTime()) <
                    (tacheAvecMoinsMarge.dateFinTard.getTime() - tacheAvecMoinsMarge.dateFinTot.getTime())){
                tacheAvecMoinsMarge = tmp;
            }
        }

        // On remonte jusqu'en haut du chemin + on met la valeur 'true' au champ 'critique' d'une tache
        calculeCheminCritiqueRecursive(tacheAvecMoinsMarge);

    }

    private void calculeCheminCritiqueRecursive(Tache t){
        t.critique = true;
        if(t.hasPredecesseur()){
            calculeCheminCritiqueRecursive(t.predecesseur);
            if(t.parent != null)
                calculeCheminCritiqueTacheMere(t.parent);
        }
    }

    private void calculeCheminCritiqueTacheMere(Tache t){
        t.critique = true;
        if(t.parent != null)
            calculeCheminCritiqueTacheMere(t.parent);
    }



    /*
    private List<Tache> getTachesFins(){
        List<Tache> listTachesFin = new ArrayList<Tache>();
        for(Tache tache : listTaches){
            if(!tache.hasPredecesseur()) {
                getTachesFinsRecursive(tache, listTachesFin);
            }
        }
        return listTachesFin;
    }

    private void getTachesFinsRecursive(Tache tache, List<Tache> result){
        if(tache.hasSuccesseur()){
            result.add(tache);
        }
        else{
            for(Tache successeur : tache.successeurs){
                getTachesFinsRecursive(successeur, result);
            }
        }
    }
    */

    /**
     * TODO testme : A CHANGER CAR AJOUT DE DEUX DATES
     * Vérifier la cohérence des 4 dates (dateDebutTheorique <= dateDebutReel <= dateFinReel <= dateFinTheorique)
     */
    /*public boolean verifierCoherenceDesDates() {
        if ((this.dateDebutTheorique.compareTo(this.dateDebutReel) < 1)
                && (this.dateDebutReel.compareTo(this.dateFinReel) < 1)
                && (this.dateFinReel.compareTo(this.dateFinTheorique) < 1))
            return true;
        else return false;
    }*/

    /**
     * TODO testme
     */
    public void updateAvancementGlobal() {
        Double chargeConsommeeGlobal = 0.0;
        Double chargeRestanteGlobal = 0.0;
        for(Tache tache : listTaches){
            if(!tache.hasParent()) {
                chargeConsommeeGlobal += tache.getChargeConsommee();
                chargeRestanteGlobal += tache.getChargeRestante();
            }
        }
        if(listTaches.size() != 0){
            this.chargeConsommee = chargeConsommeeGlobal;
            this.chargeRestante = chargeRestanteGlobal;
            Double avancementDouble = chargeConsommeeGlobal/(chargeConsommeeGlobal + chargeRestanteGlobal);
            BigDecimal bd = new BigDecimal(avancementDouble);
            BigDecimal bd2 = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
            String result = bd2.toString();
            if(result.length()==3){
                // Par example: "0.1"
                this.avancementGlobal = new Byte(result.substring(2,3)+"0");
            } else {
                // Par example: "0.15"
                this.avancementGlobal = new Byte(result.substring(2,4));
            }
        }
    }

    public String formateDate(Date d){
        return dateFormat.format(d);
    }

    public String formateDateTri(Date d){
        return dateFormatTri.format(d);
    }

    /**
     * TODO: TEST ME
     * @return
     */
    public HashMap<String,Double> chargeConsommeEtRestante(){
        Double chargeConsommeeGlobal = 0.0;
        Double chargeRestanteGlobal = 0.0;
        HashMap<String,Double> map = new HashMap<String, Double>();
        if(!listTaches.isEmpty()) {
            for (Tache tache : listTaches) {
                if (!tache.hasParent()) {
                    chargeConsommeeGlobal += tache.getChargeConsommee();
                    chargeRestanteGlobal+= tache.getChargeRestante();
                }
            }
            map.put("restante",chargeRestanteGlobal);
        }else{
            map.put("restante",this.chargeInitiale);
        }
        map.put("consommee", chargeConsommeeGlobal);
        return map;
    }


    public static List<Projet> getAll() {
        return find.all();
    }
    public boolean hasUniteJour(){ return unite == UniteProjetEnum.JOUR; }
    public boolean hasUniteSemaine(){ return unite == UniteProjetEnum.SEMAINE; }

    public boolean estRetarde(){ return dateFinReelTard.after(Calendar.getInstance().getTime());}
    public boolean estPresqueFini(){ return (avancementGlobal >= LIMITE_PROJET_PRESQUE_FINI && avancementGlobal < 100);}
    public boolean estTermine(){ return avancementGlobal == 100; }
}
