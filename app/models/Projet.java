package models;

import com.avaje.ebean.Model;
import com.avaje.ebean.common.BeanList;
import models.Securite.EntiteSecurise;
import models.Utils.Utils;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.DoubleAccumulator;

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
    public Date dateFinReelTôt;
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
    public List<Tache> listTaches;

    public UniteProjetEnum unite;

    final String DATE_PATTERN = "dd/MM/yyyy";
    final String DATE_PATTERN_TRI = "yyyy/MM/dd";
    final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
    final SimpleDateFormat dateFormatTri = new SimpleDateFormat(DATE_PATTERN_TRI);

    public static Model.Finder<Long, Projet> find = new Model.Finder<>(Projet.class);

    public Projet(String nom, String description, Utilisateur responsableProjet, Date dateDebutTheorique, Date dateFinTheorique,
                  Date dateDebutReel, Date dateFinReelTôt,Date dateFinReelTard, Double chargeInitiale, UniteProjetEnum unite,
                  Byte avancementGlobal, Boolean enCours, Boolean archive, Client client, Integer priorite, List<Tache> listTaches) {
        this.nom = nom;
        this.description = description;
        this.responsableProjet = responsableProjet;
        this.dateDebutTheorique = dateDebutTheorique;
        this.dateFinTheorique = dateFinTheorique;
        this.dateDebutReel = dateDebutReel;
        this.dateFinReelTôt = dateFinReelTôt;
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
                    projet.dateFinReelTôt.equals(this.dateFinReelTôt) &&
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
        sb.append(", DebutRE : ").append(dateDebutReel).append(", FinRETôt : ").append(dateFinReelTôt).append(", FinRETard : ").append(dateFinReelTard);
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

    /**
     * Ajouter la tache en parametre a la liste des taches du projet
     * @param tache
     */
    @Transient
    public void ajouterTache(Tache tache) throws IllegalArgumentException {
        if (listTaches.contains(tache)) {
            throw new IllegalArgumentException("Le projet " + this.nom + ", contient deja la tache " + tache.nom +
                    ", creation impossible");
        }
        tache.projet = this;
        tache.save();
        listTaches.add(tache);
        save();
    }

    /**
     * Inserer tacheAvant avant la tacheApres
     * @param tacheAvant
     * @param tacheApres
     * @throws IllegalArgumentException
     */
    public void insererTacheAvant(Tache tacheAvant, Tache tacheApres) throws IllegalArgumentException{
        if(!listTaches.contains(tacheApres)){
            throw new IllegalArgumentException("Le projet " + this.nom + " ne contient pas la tache "+tacheApres.nom);
        }
        ajouterTache(tacheAvant);
        if(tacheApres.predecesseur!= null) {
            Tache tacheA = tacheApres.predecesseur;
            tacheA.successeurs.remove(tacheApres);
            tacheA.associerSuccesseur(tacheAvant);
            tacheA.save();
        }
        tacheAvant.associerSuccesseur(tacheApres);
        save();
    }

    /**
     * Insérer la tache tacheApres après la tache tacheAvant
     * @param tacheAvant
     * @param tacheApres
     * @throws IllegalArgumentException
     */
    public void insererTacheApres(Tache tacheAvant, Tache tacheApres) throws IllegalArgumentException{
        if(!listTaches.contains(tacheAvant)){
            throw new IllegalArgumentException("Le projet " + this.nom + " ne contient pas la tache "+tacheAvant.nom);
        }
        ajouterTache(tacheApres);
        tacheAvant.associerSuccesseur(tacheApres);
        save();
    }

    /**
     * Insérer la tache tacheApres après la tache tacheAvant
     * @param tacheMere
     * @param tacheFille
     * @throws IllegalArgumentException
     */
    public void insererTacheFille(Tache tacheMere, Tache tacheFille) throws IllegalArgumentException{
        if(!listTaches.contains(tacheMere)){
            throw new IllegalArgumentException("Le projet " + this.nom + " ne contient pas la tache "+tacheMere.nom);
        }
        ajouterTache(tacheFille);
        tacheMere.associerSousTache(tacheFille);
        save();
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
                chargeRestanteGlobal += tache.getchargeRestante();
            }
        }
        this.chargeConsommee = chargeConsommeeGlobal;
        this.chargeRestante = chargeRestanteGlobal;
        Double avancementDouble = chargeConsommeeGlobal/(chargeConsommeeGlobal + chargeRestanteGlobal);
        String result = avancementDouble.toString();
        if(result.length()==3){
            // Par example: "0.1"
            this.avancementGlobal = new Byte(result.substring(2,3)+"0");
        } else {
            // Par example: "0.15"
            this.avancementGlobal = new Byte(result.substring(2,4));
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
                    chargeRestanteGlobal+= tache.getchargeRestante();
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
