package models;

import com.avaje.ebean.Model;
import com.avaje.ebean.common.BeanList;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import models.Securite.EntiteSecurise;
import models.Utils.Utils;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateDebutTheorique;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateFinTheorique;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateDebutReel;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateFinReelTot;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    public List<Utilisateur> utilisateursNotifications;

    final String DATE_PATTERN = "dd/MM/yyyy";
    final String DATE_PATTERN_TRI = "yyyy/MM/dd";
    final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
    final SimpleDateFormat dateFormatTri = new SimpleDateFormat(DATE_PATTERN_TRI);

    public static Model.Finder<Long, Projet> find = new Model.Finder<>(Projet.class);

    public Projet(String nom, String description, Utilisateur responsableProjet, Date dateDebutTheorique, Date dateFinTheorique,
                  Date dateDebutReel, Date dateFinReelTot, Date dateFinReelTard, Double chargeInitiale, UniteProjetEnum unite,
                  Byte avancementGlobal, Boolean enCours, Boolean archive, Client client, Integer priorite, List<Tache> listTaches,
                  List<Utilisateur> utilisateursNotifications) {
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
        if(listTaches == null){
            this.listTaches = new BeanList<>();
            this.chargeConsommee = 0.0;
            this.chargeRestante = chargeInitiale;
        }else{
            this.listTaches = listTaches;
            System.out.println(listTaches);
            updateAvancementGlobal();
        }

        if(utilisateursNotifications == null ||utilisateursNotifications.isEmpty()){
            initUtilisateursNotifications();
        }
        else{
            this.utilisateursNotifications = utilisateursNotifications;
        }

    }

    private void initUtilisateursNotifications(){
        utilisateursNotifications = new BeanList<>();
        utilisateursNotifications.add(responsableProjet);
        for(Tache tache : listTaches){
         if(!utilisateursNotifications.contains(tache.responsableTache))
             utilisateursNotifications.add(tache.responsableTache);
        }
        save();
    }

    private void addUtilisateurNotification(Utilisateur user){
        if(!utilisateursNotifications.contains(user)) {
            utilisateursNotifications.add(user);
            save();
        }
    }

    /**
     * Attention : cette méthode doit être appelé une fois la suppression (tache, responsable de tache) effectuée
     * @param user
     */
    private void removeUtilisateurNotification(Utilisateur user){
        if(responsableProjet.equals(user))
            return;

        for(Tache tache : listTaches){
            // On ne supprime pas l'user des notifs car il a d'autre(s) tache(s) dans ce projet
            if(tache.responsableTache.equals(user))
                return;
        }
        removeDefinitivelyUtilisateurNotification(user);
        save();
    }

    private void removeDefinitivelyUtilisateurNotification(Utilisateur user){
        if(utilisateursNotifications.contains(user)) {
            utilisateursNotifications.remove(user);
            save();
        }
    }

    public Projet(String nom,String description,Utilisateur responsableProjet,Date dateDebutTheorique,Date dateFinTheorique,UniteProjetEnum unite,Client client, Integer priorite){
        this(nom,description,responsableProjet,dateDebutTheorique,dateFinTheorique, null, null, null, 0.0,unite , (byte)0, true, false,client,priorite ,null,null);
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
                    Utils.isEqualList(projet.listTaches,listTaches) &&
                    Utils.isEqualList(projet.utilisateursNotifications,utilisateursNotifications));
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

    /** TODO : getUtilisateursNotifications **/

    /** !!! A NE JAMAIS APPELER DANS LES PAGES HTML !!!
     * Ajouter la tache en parametre a la liste des taches du projet
     * @param tache
     * @param tache
     * @throws Exception
     */
    @Transient
    private void ajouterTache(Tache tache) throws Exception {

        // Met a jour le parent
        if(tache.hasParent()){
            if(tache.parent.equals(tache))
                throw new IllegalArgumentException("Le parent de la tache " + tache.nom + " est lui-même!");

            if(tache.parent.enfants == null)
                tache.parent.enfants = new BeanList<>();

            if(!tache.parent.enfants.contains(tache)){
                tache.parent.enfants.add(tache);
                tache.parent.save();
            }
        }

        // Met a jour les enfants
        if(tache.enfants != null){
            if(tache.enfants.contains(tache))
                throw new IllegalArgumentException("Un des enfants de la tache " + tache.nom + " est lui-même!");

            for(Tache enfant : tache.enfants){
                enfant.parent = tache;
                enfant.save();
            }
        }

        // Met a jour le prédécesseur
        if(tache.hasPredecesseur()){
            if(tache.predecesseur.equals(tache))
                throw new IllegalArgumentException("Le predecesseur de la tache " + tache.nom + " est lui-même!");

            if(tache.predecesseur.successeurs == null)
                tache.predecesseur.successeurs = new BeanList<>();

            if(!tache.predecesseur.successeurs.contains(tache)){
                tache.predecesseur.successeurs.add(tache);
                tache.predecesseur.save();
            }
        }
        // Met a jour les successeur
        if(tache.hasSuccesseur()){
            if(tache.successeurs.contains(tache))
                throw new IllegalArgumentException("Un des successeurs de la tache " + tache.nom + " est lui-même!");

            for(Tache successeur : tache.successeurs){
                successeur.predecesseur = tache;
                successeur.save();
            }
        }
        // Initialisation des personnes a notifié par défaut à la création de la tache
        tache.addUtilisateurNotification(tache.responsableTache);
        tache.initUtilisateursNotificationsEnfants();
        tache.initUtilisateursNotificationsParents();
        this.addUtilisateurNotification(tache.responsableTache);
        tache.projet = this;
        tache.save();
        listTaches.add(tache);
        // TODO : mettre a jour les charges des taches meres -> a checker
        tache.initCharge(0.0, tache.chargeInitiale);
        // TODO : mettre a jour les charges du projet + avancement + chemin critique -> a checker
        updateAvancementGlobal();
        calculeCheminCritique();

        save();
    }

    /**
     * Méthode uniquement appelée lorsque le projet n'a aucune tâche
     * @param tache
     * @throws Exception
     */
    public void creerTacheInitialisationProjet(Tache tache) throws Exception {
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
     * @throws Exception
     */
    public void creerTacheAuDessus(Tache tache, Tache tacheDejaInseree) throws Exception{
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
     * @throws Exception
     */
    public void creerTacheEnDessous(Tache tache, Tache tacheDejaInseree) throws Exception{
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

                // Pour faire le changement : le prefixe doit être identique, et a l'indice niveau, ça doit être >=
                // (car il faut modifier aussi tacheDejaInseree+1 qui a le meme id)
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
     * Créer une sous-tâche à la tache parent
     * @param tache
     * @param parent
     * @throws Exception
     */
    public void creerSousTache(Tache tache, Tache parent) throws Exception{
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
            if(!idTacheDuProjetParse[i].equals(idTacheParse[i]))
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
        for(int i=niveau+1; i<idTacheParse.length; i++){
            idTache += idTacheParse[i] + ".";
        }
        return idTache.substring(0, idTache.length()-1);
    }


    /**
     * TODO testme
     * Modifie la tache en parametre
     *
     * @param tache
     * @throws Exception
     */
    @Transient
    public void modifierTache(Tache tache) throws Exception {
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
     * @throws Exception
     */
    @Transient
    public void supprimerTache(Tache tache) throws Exception {
        if (!listTaches.contains(tache)){
            throw new IllegalArgumentException("Le projet " + this.nom + ", ne contient pas la tache " + tache.nom +
                    ", suppression impossible");
        }
        listTaches.remove(tache);

        // Modifications au niveau des liaisons predecesseur/successeurs
        if(tache.hasPredecesseur() && tache.hasSuccesseur()){
            Tache tAvant = tache.predecesseur;
            tAvant.successeurs.remove(tache);

            List<Tache> taches = tache.getSuccesseurs();
            taches.forEach(t -> {
                t.predecesseur = null;
                tAvant.associerSuccesseur(t);
                t.save();
            });
            tAvant.save();
        }else if(tache.hasPredecesseur()){
            Tache tAvant = tache.predecesseur;
            tAvant.successeurs.remove(tache);
            tAvant.save();
        }else if(tache.hasSuccesseur()){
            tache.getSuccesseurs().forEach(t -> t.predecesseur = null);
        }

        // Modification des idTache
        String[] idTacheParse = tache.idTache.split("\\.");
        int idTacheInteger = Integer.parseInt(idTacheParse[tache.niveau]);

        for(Tache tacheDuProjet : listTaches){
            if(!tacheDuProjet.equals(tache) && tacheDuProjet.niveau >= tache.niveau){
                // On parse l'id(=A.B.C.D) pour avoir A, B, C et D
                String[] idTacheDuProjetParse = tacheDuProjet.idTache.split("\\.");
                int idTacheDuProjetInteger = Integer.parseInt(idTacheDuProjetParse[tache.niveau]);

                // Pour faire le changement : le prefixe doit être identique, et a l'indice niveau, ça doit être >
                if(samePrefix(idTacheDuProjetParse, idTacheParse, tache.niveau) && idTacheDuProjetInteger > idTacheInteger){
                    tacheDuProjet.idTache = reconstituerIdTache(idTacheDuProjetParse, idTacheDuProjetInteger-1, tache.niveau);
                    tacheDuProjet.save();
                }
            }
        }

        // Notifications
        removeUtilisateurNotification(tache.responsableTache);

        /** TODO : est-ce qu'on supprime la tache de la liste des notifs pour l'user et inversement?
        tache.removeUtilisateurNotification(tache.responsableTache);
        tache.removeUtilisateurNotificationEnfants();
        tache.removeUtilisateurNotificationParents();
         */

        // TODO Mettre a jour les charges des taches filles -> a checker
        tache.updateChargesTachesMeresEtProjet();

        // TODO : mettre a jour les charges du projet + avancement + chemin critique -> a checker
        updateAvancementGlobal();
        calculeCheminCritique();

        // Suppression ou archivage
        if (tache.chargeConsommee == 0.0) {
            tache.removeUtilisateurNotification(tache.responsableTache);
            tache.removeUtilisateurNotificationEnfants();
            tache.removeUtilisateurNotificationParents();
            Tache.find.deleteById(tache.id);
        }else{
            tache.archive = true;
            tache.save();
        }
        save();
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
        addUtilisateurNotification(this.responsableProjet);
        this.save();
    }

    /**
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

        Utilisateur ancienResponsableProjet = this.responsableProjet;
        this.responsableProjet = responsable;
        removeUtilisateurNotification(ancienResponsableProjet);
        addUtilisateurNotification(this.responsableProjet);
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

    private void calculeCheminCritique() throws Exception{
        // Récupération des tâches qui sont à la toute fin et qui ont pour dates fin plus tard la date fin plus tard du projet
        List<Tache> listTachesFin = new ArrayList<Tache>();
        for(Tache tache : listTaches){
            tache.critique = false; // on réinitialise tous les champs 'critique'
            if(tache.dateFinTard.equals(dateFinReelTard) && !tache.hasSuccesseur() && !tache.hasEnfant()){
                listTachesFin.add(tache);
            }
        }
        if(listTachesFin.isEmpty())
            throw new Exception("Le projet [" + nom + "] n'a pas de chemin critique car aucune tache ne termine à la date de fin au plus" +
                    " tard du projet (" + formateDate(dateFinReelTard) + ")");

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
                chargeConsommeeGlobal += tache.chargeConsommee;
                chargeRestanteGlobal += tache.chargeRestante;
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
        save();
    }

    public String formateDate(Date d){
        if(d!=null){
        return dateFormat.format(d);}else{
            return "";
        }
    }

    public String formateDateTri(Date d){
        if(d!=null) {
            return dateFormatTri.format(d);
        }else{
            return "";
        }
    }

    public static List<Projet> getAll() {
        return find.all();
    }

    public static List<Projet> getAllNonArchivesNonTermines(){
        return find.where()
                .eq("archive",false)
                .eq("enCours",true)
                .findList();
    }

    public static List<Projet> getAllArchives(Boolean check){
        if(check){
            return find.where().eq("archive",true).eq("enCours",true).findList();
        }else{
            return find.where().eq("archive",true).findList();
        }
    }

    public static List<Projet> getAllTermines(Boolean check){
        if(check){
            return find.where().eq("enCours",false).eq("archive",false).findList();
        }else{
            return find.where().eq("enCours",false).findList();
        }
    }

    public static Projet supprimerProjet(Long idProjet){
         Projet p = find.byId(idProjet);
         p.archive = true;
         p.save();
        System.out.println("P"+p.nom);
         for(int i=0; i<p.client.listeProjets.size();i++){
             System.out.println(p.client.listeProjets.get(i).nom);
             System.out.println(p.client.listeProjets.get(i).archive);
         }
        return p;
    }

    public boolean hasUniteJour(){ return unite == UniteProjetEnum.JOUR; }
    public boolean hasUniteSemaine(){ return unite == UniteProjetEnum.SEMAINE; }

    public boolean estRetarde(){
        if(dateFinReelTard!=null){
            return dateFinReelTard.after(Calendar.getInstance().getTime());
        }else{
            return false;
        }
    }
    public boolean estPresqueFini(){ return (avancementGlobal >= LIMITE_PROJET_PRESQUE_FINI && avancementGlobal < 100);}
    public boolean estTermine(){ return avancementGlobal == 100; }

    public int prioriteProjetEtClient(){ return priorite + client.priorite;}

    public List<Tache> listTaches(){
        listTaches = Tache.find.where().eq("projet",this).findList();
        /*
        // Trier en fonction de idTache
        Collections.sort(listTaches, new Comparator<Tache>(){
            @Override
            public int compare(Tache t1, Tache t2) {
                String[] idT1Parse = t1.idTache.split("\\.");
                String[] idT2Parse = t2.idTache.split("\\.");
                Integer[] idT1Integer = new Integer[idT1Parse.length];
                Integer[] idT2Integer = new Integer[idT2Parse.length];
                for(int i=0; i<idT1Parse.length; i++){
                    idT1Integer[i] = Integer.parseInt(idT1Parse[i]);
                }
                for(int i=0; i<idT2Parse.length; i++){
                    idT2Integer[i] = Integer.parseInt(idT2Parse[i]);
                }
                for(int i=0; i<idT1Integer.length || i<idT2Integer.length; i++){
                    if(i >= idT1Integer.length)
                        return -1;
                    if(i >= idT2Integer.length)
                        return 1;
                    if(idT1Integer[i] < idT2Integer[i])
                        return -1;
                    if(idT1Integer[i] > idT2Integer[i])
                        return 1;
                }
                return 0;
            }
        });
         */
        return listTaches;
    }

    public List<Tache> listTachesAAfficher(){
        listTaches = listTaches();
        List<Tache> taches = new BeanList<>();
        for(Tache tache : listTaches){
            if(!tache.hasParent()){
                taches.add(tache);
            }
        }
        // Trier en fonction de idTache (normalement que des int)
        Collections.sort(taches, new Comparator<Tache>(){
            @Override
            public int compare(Tache t1, Tache t2) {
                return Integer.parseInt(t1.idTache) - Integer.parseInt(t2.idTache);
            }
        });
        return taches;
    }
}
