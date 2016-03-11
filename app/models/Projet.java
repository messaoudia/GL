package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import com.avaje.ebean.common.BeanList;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import models.Securite.EntiteSecurise;
import controllers.Utils.Utils;
import play.Logger;
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
    @Column(length = 65535)
    public String description;

    @ManyToOne
    @JoinColumn
    public Utilisateur responsableProjet;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateDebutTheorique;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateFinTheorique;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateDebutReel;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateFinReelTot;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
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
        if (listTaches == null) {
            this.listTaches = new BeanList<>();
            this.chargeConsommee = 0.0;
            this.chargeRestante = chargeInitiale;
        } else {
            this.listTaches = listTaches;
            updateAvancementGlobal();
        }

        if (utilisateursNotifications == null || utilisateursNotifications.isEmpty()) {
            initUtilisateursNotifications();
        } else {
            this.utilisateursNotifications = utilisateursNotifications;
        }

    }

    private void initUtilisateursNotifications() {
        utilisateursNotifications = new BeanList<>();
        utilisateursNotifications.add(responsableProjet);
        for (Tache tache : listTaches) {
            if (!utilisateursNotifications.contains(tache.responsableTache))
                utilisateursNotifications.add(tache.responsableTache);
        }
        //save();
    }

    private void addUtilisateurNotification(Utilisateur user) {
        if (!utilisateursNotifications.contains(user)) {
            utilisateursNotifications.add(user);
            save();
        }
    }

    /**
     * Attention : cette méthode doit être appelé une fois la suppression (tache, responsable de tache) effectuée
     *
     * @param user
     */
    private void removeUtilisateurNotification(Utilisateur user) {
        if (responsableProjet.equals(user))
            return;

        for (Tache tache : listTaches) {
            // On ne supprime pas l'user des notifs car il a d'autre(s) tache(s) dans ce projet
            if (tache.responsableTache.equals(user))
                return;
        }
        removeDefinitivelyUtilisateurNotification(user);
        save();
    }

    private void removeDefinitivelyUtilisateurNotification(Utilisateur user) {
        if (utilisateursNotifications.contains(user)) {
            utilisateursNotifications.remove(user);
            save();
        }
    }

    public Projet(String nom, String description, Utilisateur responsableProjet, Date dateDebutTheorique, Date dateFinTheorique, UniteProjetEnum unite, Client client, Integer priorite) {
        this(nom, description, responsableProjet, dateDebutTheorique, dateFinTheorique, null, null, null, 0.0, unite, (byte) 0, true, false, client, priorite, null, null);
    }

    public Projet() {
        listTaches = new BeanList<>();
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
            return (projet.nom.equals(this.nom) &&
                    projet.description.equals(this.description) &&
                    //projet.dateDebutTheorique.equals(this.dateDebutTheorique) &&
                    Utils.equals(projet.dateDebutTheorique, this.dateDebutTheorique) &&
                    //projet.dateFinTheorique.equals(this.dateFinTheorique) &&
                    Utils.equals(projet.dateFinTheorique, this.dateFinTheorique) &&
                    //projet.dateDebutReel.equals(this.dateDebutReel) &&
                    Utils.equals(projet.dateDebutReel, this.dateDebutReel) &&
                    //projet.dateFinReelTot.equals(this.dateFinReelTot) &&
                    Utils.equals(projet.dateFinReelTot, this.dateFinReelTot) &&
                    //projet.dateFinReelTard.equals(this.dateFinReelTard) &&
                    Utils.equals(projet.dateFinReelTard, this.dateFinReelTard) &&
                    projet.chargeInitiale.equals(this.chargeInitiale) &&
                    projet.avancementGlobal.equals(this.avancementGlobal) &&
                    projet.enCours.equals(this.enCours) &&
                    projet.archive.equals(this.archive) &&
                    projet.priorite.equals(this.priorite) &&
                    Utils.isEqualList(projet.listTaches, listTaches) &&
                    Utils.isEqualList(projet.utilisateursNotifications, utilisateursNotifications));
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
        sb.append(", Restante :").append(chargeRestante).append("\n");
        sb.append(", Consommee :").append(chargeConsommee).append("\n");
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

    /**
     * !!! A NE JAMAIS APPELER DANS LES PAGES HTML !!!
     * Ajouter la tache en parametre a la liste des taches du projet
     *
     * @param tache
     * @param tache
     * @throws Exception
     */
    @Transient
    private void ajouterTache(Tache tache) throws Exception {

        // Met a jour le parent
        if (tache.hasParent()) {
            if (tache.parent.equals(tache))
                throw new IllegalArgumentException("Le parent de la tache " + tache.nom + " est lui-même!");

            //if(tache.parent.dateDebut.after(tache.dateDebut))
            if (Utils.after(tache.parent.dateDebut, tache.dateDebut))
                throw new IllegalArgumentException("Le parent [" + tache.parent.nom + " a une date de début (" + formateDate(tache.parent.dateDebut) + ") après la date de début (" + formateDate(tache.dateDebut) + ") de sa sous-tâche [" + tache.nom + "]");

            //if(tache.parent.dateFinTot.before(tache.dateFinTot))
            if (Utils.before(tache.parent.dateFinTot, tache.dateFinTot))
                throw new IllegalArgumentException("Le parent [" + tache.parent.nom + " a une date de fin au plus tot (" + formateDate(tache.parent.dateFinTot) + ") après la date de fin au plus tot (" + formateDate(tache.dateFinTot) + ") de sa sous-tâche [" + tache.nom + "]");

            //if(tache.parent.dateFinTard.before(tache.dateFinTard))
            if (Utils.before(tache.parent.dateFinTard, tache.dateFinTard))
                throw new IllegalArgumentException("Le parent [" + tache.parent.nom + " a une date de fin au plus tard (" + formateDate(tache.parent.dateFinTard) + ") après la date de fin au plus tard (" + formateDate(tache.dateFinTard) + ") de sa sous-tâche [" + tache.nom + "]");

            if (tache.parent.enfants == null)
                tache.parent.enfants = new BeanList<>();

            if (!tache.parent.enfants.contains(tache)) {
                tache.parent.enfants.add(tache);
                //tache.parent.save();
            }
        }

        // Met a jour les enfants
        if (tache.hasEnfant()) {
            if (tache.enfants.contains(tache))
                throw new IllegalArgumentException("Un des enfants de la tache " + tache.nom + " est lui-même!");

            for (Tache enfant : tache.enfants) {
                //if(tache.dateDebut.after(enfant.dateDebut))
                if (Utils.after(tache.dateDebut, enfant.dateDebut))
                    throw new IllegalArgumentException("Le parent [" + tache.nom + " a une date de début (" + formateDate(enfant.dateDebut) + ") après la date de début (" + formateDate(tache.dateDebut) + ") de sa sous-tâche [" + tache.nom + "]");


                //if(tache.dateFinTot.before(enfant.dateFinTot))
                if (Utils.before(tache.dateFinTot, enfant.dateFinTot))
                    throw new IllegalArgumentException("Le parent [" + tache.nom + " a une date de fin au plus tot (" + formateDate(enfant.dateFinTot) + ") après la date de fin au plus tot (" + formateDate(tache.dateFinTot) + ") de sa sous-tâche [" + tache.nom + "]");

                //if(tache.dateFinTard.before(enfant.dateFinTard))
                if (Utils.before(tache.dateFinTard, enfant.dateFinTard))
                    throw new IllegalArgumentException("Le parent [" + tache.nom + " a une date de fin au plus tard (" + formateDate(enfant.dateFinTard) + ") après la date de fin au plus tard (" + formateDate(tache.dateFinTard) + ") de sa sous-tâche [" + tache.nom + "]");

                enfant.parent = tache;
                //enfant.save();
            }
        }

        // Met a jour le prédécesseur
        if (tache.hasPredecesseur()) {
            if (tache.predecesseur.equals(tache))
                throw new IllegalArgumentException("Le predecesseur de la tache " + tache.nom + " est lui-même!");

            if (tache.predecesseur.successeurs == null)
                tache.predecesseur.successeurs = new BeanList<>();

            //if(tache.dateDebut.before(tache.predecesseur.dateFinTard))
            if (Utils.before(tache.dateDebut, tache.predecesseur.dateFinTard))
                throw new IllegalArgumentException("La tache " + tache.nom + " a une date de debut (" + formateDate(tache.dateDebut) + ") avant la date de fin au plus tard (" + formateDate(tache.predecesseur.dateFinTard) + ") de son predecesseur [" + tache.predecesseur.nom + "]");

            if (!Tache.checkPERT(tache, tache.predecesseur)) {
                throw new IllegalArgumentException("Le predecesseur " + tache.predecesseur.nom +
                        " de la tache " + tache.nom + " est présent dans sa hiérarchie directe.");
            }

            if (!tache.predecesseur.successeurs.contains(tache)) {
                tache.predecesseur.successeurs.add(tache);
                //tache.predecesseur.save();
            }
        }

        // Met a jour les successeur
        if (tache.hasSuccesseur()) {
            if (tache.successeurs.contains(tache))
                throw new IllegalArgumentException("Un des successeurs de la tache " + tache.nom + " est lui-même!");

            for (Tache successeur : tache.successeurs) {
                //if(tache.dateFinTard.after(successeur.dateDebut))
                if (Utils.after(tache.dateFinTard, successeur.dateDebut))
                    throw new IllegalArgumentException("La tache [" + tache.nom + " a une date de fin au plus tard (" + formateDate(tache.dateFinTard) + ") après la date de début (" + formateDate(successeur.dateDebut) + ") de son successeur [" + successeur.nom + "]");

                if (!Tache.checkPERT(tache, successeur)) {
                    throw new IllegalArgumentException("Le successeur " + successeur +
                            " de la tache " + tache.nom + " est présent dans sa hiérarchie directe.");
                }
                successeur.predecesseur = tache;
                //successeur.save();
            }
        }

        tache.responsableTache.update();
        tache.projet = this;
        tache.save();
        System.out.println("Dans ajouterTache : tache = " + tache + " - disponible = " + tache.disponible);
        listTaches.add(tache);

        saveAllProject();
        updateDatesProjet(tache);
        tache.initCharge(0.0, tache.chargeInitiale);

        // Initialisation des personnes a notifié par défaut à la création de la tache
        tache.addUtilisateurNotification(tache.responsableTache);
        tache.initUtilisateursNotificationsEnfants();
        tache.initUtilisateursNotificationsParents();
        this.addUtilisateurNotification(tache.responsableTache);

        updateAvancementGlobal();
        saveAllProject();
        calculeCheminCritique();
        saveAllProject();
    }

    private void updateDatesProjet(Tache tache) {
        // Mise a jour date de début
        //if(dateDebutReel == null || tache.dateDebut.before(dateDebutReel)){
        if (dateDebutReel == null || Utils.before(tache.dateDebut, dateDebutReel)) {
            dateDebutReel = tache.dateDebut;
        }

        // Mise a jour date de fin au + tot
        //if(dateFinReelTot == null || tache.dateFinTot.after(dateFinReelTot)){
        if (dateFinReelTot == null || Utils.after(tache.dateFinTot, dateFinReelTot)) {
            dateFinReelTot = tache.dateFinTot;
        }

        // Mise a jour date de fin au + tard
        //if(dateFinReelTard == null || tache.dateFinTard.after(dateFinReelTard)){
        if (dateFinReelTard == null || Utils.after(tache.dateFinTard, dateFinReelTard)) {
            dateFinReelTard = tache.dateFinTard;
        }
    }

    // TODO TEST ME
    private void updateDatesProjet() {
        if (listTaches.isEmpty())
            return;
        int i = 0;
        while (i < listTaches.size()) {
            if (!listTaches.get(i).archive)
                break;
            i++;
        }
        if (i == listTaches.size())
            return;

        Date dateDebut = listTaches.get(i).dateDebut;
        Date dateFinTot = listTaches.get(i).dateFinTot;
        Date dateFinTard = listTaches.get(i).dateFinTard;
        for (int j = i; j < listTaches.size(); j++) {
            Tache tache = listTaches.get(i);
            if (!tache.archive) {
                if (Utils.before(tache.dateDebut, dateDebut))
                    dateDebut = tache.dateDebut;

                if (Utils.after(tache.dateFinTot, dateFinTot))
                    dateFinTot = tache.dateFinTot;

                if (Utils.after(tache.dateFinTard, dateFinTard))
                    dateFinTard = tache.dateFinTard;
            }
        }
        this.dateDebutReel = dateDebut;
        this.dateFinReelTot = dateFinTot;
        this.dateFinReelTard = dateFinTard;
    }

    /**
     * Méthode uniquement appelée lorsque le projet n'a aucune tâche
     *
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
     *
     * @param tache
     * @param tacheDejaInseree
     * @throws Exception
     */
    public void creerTacheAuDessus(Tache tache, Tache tacheDejaInseree) throws Exception {
        // Vérifications initiales
        if (!listTaches.contains(tacheDejaInseree)) {
            throw new IllegalArgumentException("Le projet " + this.nom + " ne contient pas la tache " + tacheDejaInseree.nom);
        }
        if (listTaches.contains(tache)) {
            throw new IllegalArgumentException("Le projet " + this.nom + ", contient deja la tache " + tache.nom +
                    ", creation impossible");
        }

        // Même niveau et parent que la tache en dessous
        tache.niveau = tacheDejaInseree.niveau;
        tache.parent = (tacheDejaInseree.parent == null) ? null : tacheDejaInseree.parent;

        // Pas d'enfant
        tache.enfants = new BeanList<>();

        // Id de la tache est l'id de la tache qui va etre en dessous. Modification des id des autres taches ci-dessous
        tache.idTache = tacheDejaInseree.idTache;

        // Modification de l'id des autres taches

        String[] idTacheParse = tache.idTache.split("\\.");
        int idTacheInteger = Integer.parseInt(idTacheParse[tache.niveau]);

        for (Tache tacheDuProjet : listTaches) {
            if (!tacheDuProjet.equals(tache) && tacheDuProjet.niveau >= tache.niveau) {
                // On parse l'id(=A.B.C.D) pour avoir A, B, C et D
                String[] idTacheDuProjetParse = tacheDuProjet.idTache.split("\\.");
                int idTacheDuProjetInteger = Integer.parseInt(idTacheDuProjetParse[tache.niveau]);

                // Pour faire le changement : le prefixe doit être identique, et a l'indice niveau, ça doit être >=
                // (car il faut modifier aussi tacheDejaInseree qui a le meme id)
                if (samePrefix(idTacheDuProjetParse, idTacheParse, tache.niveau) && idTacheDuProjetInteger >= idTacheInteger) {
                    tacheDuProjet.idTache = reconstituerIdTache(idTacheDuProjetParse, idTacheDuProjetInteger + 1, tache.niveau);
                    tacheDuProjet.save();
                }
            }
        }

        ajouterTache(tache);
        save();
    }


    /**
     * A appeler quand on fait Créer une tache en dessous
     *
     * @param tache
     * @param tacheDejaInseree
     * @throws Exception
     */
    public void creerTacheEnDessous(Tache tache, Tache tacheDejaInseree) throws Exception {
        // Vérifications initiales
        if (!listTaches.contains(tacheDejaInseree)) {
            throw new IllegalArgumentException("Le projet " + this.nom + " ne contient pas la tache " + tacheDejaInseree.nom);
        }
        if (listTaches.contains(tache)) {
            throw new IllegalArgumentException("Le projet " + this.nom + ", contient deja la tache " + tache.nom +
                    ", creation impossible");
        }

        // Même niveau et parent que la tache en dessous
        tache.niveau = tacheDejaInseree.niveau;
        tache.parent = (tacheDejaInseree.parent == null) ? null : tacheDejaInseree.parent;

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
        for (Tache tacheDuProjet : listTaches) {
            if (!tacheDuProjet.equals(tache) && tacheDuProjet.niveau >= tache.niveau) {
                // On parse l'id(=A.B.C.D) pour avoir A, B, C et D
                String[] idTacheDuProjetParse = tacheDuProjet.idTache.split("\\.");
                int idTacheDuProjetInteger = Integer.parseInt(idTacheDuProjetParse[tache.niveau]);

                // Pour faire le changement : le prefixe doit être identique, et a l'indice niveau, ça doit être >=
                // (car il faut modifier aussi tacheDejaInseree+1 qui a le meme id)
                if (samePrefix(idTacheDuProjetParse, idTacheParse, tache.niveau) && idTacheDuProjetInteger >= idTacheInteger) {
                    tacheDuProjet.idTache = reconstituerIdTache(idTacheDuProjetParse, idTacheDuProjetInteger + 1, tache.niveau);
                    tacheDuProjet.save();
                }
            }
        }
        ajouterTache(tache);
        save();
    }

    /**
     * Créer une sous-tâche à la tache parent
     *
     * @param tache
     * @param parent
     * @throws Exception
     */
    public void creerSousTache(Tache tache, Tache parent) throws Exception {
        // Vérifications initiales
        if (parent.niveau > Tache.NIVEAU_MAX) {
            throw new IllegalArgumentException("La tache " + parent.nom +
                    " ne peut pas avoir de sous-tâche car elle est déjà au niveau de profondeur maximum (" + Tache.NIVEAU_MAX + ")");
        }

        if (!listTaches.contains(parent)) {
            throw new IllegalArgumentException("Le projet " + this.nom + " ne contient pas la tache " + parent.nom);
        }

        if (listTaches.contains(tache)) {
            throw new IllegalArgumentException("Le projet " + this.nom + ", contient deja la tache " + tache.nom + ", creation impossible");
        }

        // Même niveau et parent que la tache en dessous
        tache.niveau = parent.niveau + 1;

        // Parent est le parent de la tache. Mise a jour de la liste des enfants de 'parent' dans la methode 'ajouterTache'
        tache.parent = parent;

        // Pas d'enfant
        tache.enfants = new BeanList<>();

        // Si le parent a l'id 'A.B.C', alors tache a l'id 'A.B.C.1'
        int nbEnfants = parent.enfants.size() + 1;
        tache.idTache = parent.idTache + "." + nbEnfants;
        ajouterTache(tache);
        save();
    }

    /**
     * Vérifie si deux taches ont le meme prefixe pour leur idTache
     *
     * @param idTacheDuProjetParse
     * @param idTacheParse
     * @param niveau
     * @return
     */
    private boolean samePrefix(String[] idTacheDuProjetParse, String[] idTacheParse, int niveau) {
        // Condition pour faire le changement : il faut que ce qui précède l'id à l'indice niveau soit égal
        for (int i = 0; i < niveau; i++) {
            if (!idTacheDuProjetParse[i].equals(idTacheParse[i]))
                return false;
        }
        return true;
    }

    /**
     * Reconstitue idTache d'une tache en modifiant a l'indice niveau par newIdTacheInteger
     *
     * @param idTacheParse
     * @param newIdTache
     * @param niveau
     * @return
     */
    private String reconstituerIdTache(String[] idTacheParse, int newIdTache, int niveau) {
        String idTache = "";
        // Même debut entre 0 et niveau-1
        for (int i = 0; i < niveau; i++) {
            idTache += idTacheParse[i] + ".";
        }
        // Modification a l'indice niveau
        idTache += newIdTache + ".";

        // Meme fin entre niveau+1 et fin
        for (int i = niveau + 1; i < idTacheParse.length; i++) {
            idTache += idTacheParse[i] + ".";
        }
        return idTache.substring(0, idTache.length() - 1);
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

        // Met a jour le parent
        if (tache.hasParent()) {
            if (tache.parent.equals(tache))
                throw new IllegalArgumentException("Le parent de la tache " + tache.nom + " est lui-même!");

            //if(tache.parent.dateDebut.after(tache.dateDebut))
            if (Utils.after(tache.parent.dateDebut, tache.dateDebut))
                throw new IllegalArgumentException("Le parent [" + tache.parent.nom + " a une date de début (" + formateDate(tache.parent.dateDebut) + ") après la date de début (" + formateDate(tache.dateDebut) + ") de sa sous-tâche [" + tache.nom + "]");

            //if(tache.parent.dateFinTot.before(tache.dateFinTot))
            if (Utils.before(tache.parent.dateFinTot, tache.dateFinTot))
                throw new IllegalArgumentException("Le parent [" + tache.parent.nom + " a une date de fin au plus tot (" + formateDate(tache.parent.dateFinTot) + ") après la date de fin au plus tot (" + formateDate(tache.dateFinTot) + ") de sa sous-tâche [" + tache.nom + "]");

            //if(tache.parent.dateFinTard.before(tache.dateFinTard))
            if (Utils.before(tache.parent.dateFinTard, tache.dateFinTard))
                throw new IllegalArgumentException("Le parent [" + tache.parent.nom + " a une date de fin au plus tard (" + formateDate(tache.parent.dateFinTard) + ") après la date de fin au plus tard (" + formateDate(tache.dateFinTard) + ") de sa sous-tâche [" + tache.nom + "]");
        }

        // Met a jour les enfants
        if (tache.hasEnfant()) {
            if (tache.enfants.contains(tache))
                throw new IllegalArgumentException("Un des enfants de la tache " + tache.nom + " est lui-même!");

            for (Tache enfant : tache.enfants) {
                //if(tache.dateDebut.after(enfant.dateDebut))
                if (Utils.after(tache.dateDebut, enfant.dateDebut))
                    throw new IllegalArgumentException("Le parent [" + tache.nom + " a une date de début (" + formateDate(enfant.dateDebut) + ") après la date de début (" + formateDate(tache.dateDebut) + ") de sa sous-tâche [" + tache.nom + "]");

                //if(tache.dateFinTot.before(enfant.dateFinTot))
                if (Utils.before(tache.dateFinTot, enfant.dateFinTot))
                    throw new IllegalArgumentException("Le parent [" + tache.nom + " a une date de fin au plus tot (" + formateDate(enfant.dateFinTot) + ") après la date de fin au plus tot (" + formateDate(tache.dateFinTot) + ") de sa sous-tâche [" + tache.nom + "]");

                //if(tache.dateFinTard.before(enfant.dateFinTard))
                if (Utils.before(tache.dateFinTard, enfant.dateFinTard))
                    throw new IllegalArgumentException("Le parent [" + tache.nom + " a une date de fin au plus tard (" + formateDate(enfant.dateFinTard) + ") après la date de fin au plus tard (" + formateDate(tache.dateFinTard) + ") de sa sous-tâche [" + tache.nom + "]");

                enfant.parent = tache;
                enfant.save();
            }
        }

        // Met a jour le prédécesseur
        if (tache.hasPredecesseur()) {
            if (tache.predecesseur.equals(tache))
                throw new IllegalArgumentException("Le predecesseur de la tache " + tache.nom + " est lui-même!");

            if (tache.predecesseur.successeurs == null)
                tache.predecesseur.successeurs = new BeanList<>();

            //if(tache.dateDebut.before(tache.predecesseur.dateFinTard))
            if (Utils.before(tache.dateDebut, tache.predecesseur.dateFinTard))
                throw new IllegalArgumentException("La tache [" + tache.nom + " a une date de debut (" + formateDate(tache.dateDebut) + ") avant la date de fin au plus tard (" + formateDate(tache.predecesseur.dateFinTard) + ") de son predecesseur [" + tache.predecesseur.nom + "]");
        }
        // Met a jour les successeur
        if (tache.hasSuccesseur()) {
            if (tache.successeurs.contains(tache))
                throw new IllegalArgumentException("Un des successeurs de la tache " + tache.nom + " est lui-même!");

            for (Tache successeur : tache.successeurs) {
                //if(tache.dateFinTard.after(successeur.dateDebut))
                if (Utils.after(tache.dateFinTard, successeur.dateDebut))
                    throw new IllegalArgumentException("La tache [" + tache.nom + " a une date de fin au plus tard (" + formateDate(tache.dateFinTard) + ") après la date de début (" + formateDate(successeur.dateDebut) + ") de son successeur [" + successeur.nom + "]");
            }
        }


        //TODO modifier tâche
        tache.update();
        updateDatesProjet(tache);
        updateAvancementGlobal();
        update();
    }

    /**
     * Supprimer la tâche du systeme si elle n'a pas ete commencee (chargeConsommee == 0), l'archive sinon
     *
     * @param tache
     * @throws Exception
     */
    // @Transient
    public void supprimerTache(Tache tache) throws Exception {
        if (!listTaches.contains(tache)) {
            throw new IllegalArgumentException("Le projet " + this.nom + ", ne contient pas la tache " + tache.nom +
                    ", suppression impossible");
        }

        if (tache.hasEnfant()) {
            for (int i=tache.enfants.size()-1; i>=0; i--) {
                supprimerTache(tache.enfants.get(i));
            }
        }
        /*
        if (tache.getAvancementTache() > 0) {
            throw new IllegalStateException("Suppression de la tache " + tache.nom + " impossible car elle est déja commencée.");
        }
        */

        // Modifications au niveau des liaisons predecesseur/successeurs
        if (tache.hasPredecesseur() && tache.hasSuccesseur()) {
            Tache tAvant = tache.predecesseur;

            List<Tache> taches = tache.getSuccesseurs();
            for (int i = 0; i < taches.size(); i++) {
                tAvant.successeurs.remove(tache);
                taches.get(i).predecesseur = null;
                tAvant.associerSuccesseur(taches.get(i));
                taches.get(i).predecesseur.update();
                taches.get(i).update();
            }

            //tAvant.save();
        } else if (tache.hasPredecesseur()) {
            Tache tAvant = tache.predecesseur;
            tAvant.successeurs.remove(tache);
            tAvant.save();  // TODO ENLEVER?
        } else if (tache.hasSuccesseur()) {
            List<Tache> successeurs = tache.getSuccesseurs();
            for (int i = 0; i < successeurs.size(); i++) {
                successeurs.get(i).predecesseur = null;
            }
        }

        // Modification des idTache
        String[] idTacheParse = tache.idTache.split("\\.");
        int idTacheInteger = Integer.parseInt(idTacheParse[idTacheParse.length-1]);

        for (Tache tacheDuProjet : listTaches) {
            if (!tacheDuProjet.equals(tache) && tacheDuProjet.niveau >= tache.niveau) {
                // On parse l'id(=A.B.C.D) pour avoir A, B, C et D
                String[] idTacheDuProjetParse = tacheDuProjet.idTache.split("\\.");
                int idTacheDuProjetInteger = Integer.parseInt(idTacheDuProjetParse[tache.niveau]);

                // Pour faire le changement : le prefixe doit être identique, et a l'indice niveau, ça doit être >
                if (samePrefix(idTacheDuProjetParse, idTacheParse, tache.niveau) && idTacheDuProjetInteger > idTacheInteger) {
                    tacheDuProjet.idTache = reconstituerIdTache(idTacheDuProjetParse, idTacheDuProjetInteger - 1, tache.niveau);
                    tacheDuProjet.save();
                }
            }
        }

        // Notifications
        removeUtilisateurNotification(tache.responsableTache);

        listTaches.remove(tache);
        if(tache.hasParent()){
            Tache mere = tache.parent;
            mere.enfants.remove(tache);
            mere.update();
            if(!mere.enfants.isEmpty()){
                mere.enfants.get(0).updateChargesTachesMeresEtProjet();
            }
            else {
                mere.setChargeConsommee(0D);
                mere.setChargeRestante(mere.chargeInitiale);
            }
            tache.parent = null;
            tache.update();
        } else {
            updateAvancementGlobal();
            updateDatesProjet();
        }
        tache.projet = null;
        tache.predecesseur = null;
        for (int i = 0; i < tache.interlocuteurs.size(); i++) {
            tache.interlocuteurs.get(i).listTachesCorrespondant.remove(this);
            tache.interlocuteurs.get(i).update();
        }
        tache.interlocuteurs.clear();


        updateDatesProjet();

        updateAvancementGlobal();
        calculeCheminCritique();

        // Suppression ou archivage
        if (tache.getAvancementTache() == 0.0) {
            tache.removeUtilisateurNotification(tache.responsableTache);
            tache.removeUtilisateurNotificationEnfants();
            tache.removeUtilisateurNotificationParents();
            Logger.debug(tache.toString());
            if (tache.hasPredecesseur()) {
                Tache tAvant = tache.predecesseur;
                tAvant.successeurs.remove(tache);
            }
            //FIX BUG PK VIOLATION, DO NOT TOUCH
            tache.projet = null;
            tache.predecesseur = null;
            tache.successeurs = null;
            tache.parent = null;
            tache.enfants = null;
            Logger.debug("====================== DELETE ====================================");
            Ebean.deleteManyToManyAssociations(tache, "utilisateursNotifications");
            Logger.debug("===================================================================");

            tache.responsableTache.enleverResponsabiliteTache(tache);
            Tache tacheDB = Tache.find.byId(tache.id);

            Logger.debug(tacheDB.toString());

            //tache.utilisateursNotifications=null;
            //tache.update();
            //tache.delete();
            tache.archive=true;
            tache.update();

            //Utilisateur u = tache.responsableTache;
            //u.enleverResponsabiliteTache(tache);
            //Ebean.delete(tache);
            //tache.delete();
        } else {
            tache.archive = true;
            tache.save();
        }
        save();
    }

    public void updateChargesTachesMeresEtProjet(Tache mere) throws Exception {

        if (mere == null) {
            updateAvancementGlobal();
            save();
            return;
        }

        if (mere.hasEnfant()) {

            Double chargeConsommee = 0D;
            Double chargeRestante = 0D;

            for (int i = 0; i < mere.enfants.size(); i++) {
                chargeConsommee += mere.enfants.get(i).chargeConsommee;
                chargeRestante += mere.enfants.get(i).chargeRestante;
            }

            //mere.chargeConsommee = chargeConsommee;
            //mere.chargeRestante = chargeRestante;
            mere.updateChargeConsommeeTacheRecursive(mere);
            mere.updateChargeRestanteTacheRecursive(mere);
        }

        mere.save();
        mere.updateChargesTachesMeresEtProjet();

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

    private void calculeCheminCritique() throws Exception {
        if (listTaches.size() == 0) {
            return;
        }
        // Récupération des tâches qui sont à la toute fin et qui ont pour dates fin plus tard la date fin plus tard du projet
        List<Tache> listTachesFin = new ArrayList<Tache>();
        listTachesFin.add(listTaches.get(0));
        Date dateMaxTache = listTaches.get(0).dateFinTard;
        for (int i = 0; i < listTaches.size(); i++) {
            Tache tache = listTaches.get(i);
            tache.critique = false; // on réinitialise tous les champs 'critique'
            //if(tache.dateFinTard.equals(dateFinReelTard) && !tache.hasSuccesseur() && tache.enfants().isEmpty()){
            if (!tache.hasSuccesseur() && tache.enfants().isEmpty()) {
                if (Utils.equals(tache.dateFinTard, dateMaxTache)) {
                    listTachesFin.add(tache);
                } else if (Utils.after(tache.dateFinTard, dateMaxTache)) {
                    listTachesFin.clear();
                    dateMaxTache = tache.dateFinTard;
                    listTachesFin.add(tache);
                }
            }
        }
        if (listTachesFin.isEmpty())
            throw new Exception("Le projet [" + nom + "] n'a pas de chemin critique car aucune tache ne termine à la date de fin au plus" +
                    " tard du projet (" + formateDate(dateFinReelTard) + ")");

        // Récupération de la tâche ayant le moins de marge
        Tache tacheAvecMoinsMarge = listTachesFin.get(0);
        for (int i = 1; i < listTachesFin.size(); i++) {
            Tache tmp = listTachesFin.get(i);
            if ((tmp.dateFinTard.getTime() - tmp.dateFinTot.getTime()) <
                    (tacheAvecMoinsMarge.dateFinTard.getTime() - tacheAvecMoinsMarge.dateFinTot.getTime())) {
                tacheAvecMoinsMarge = tmp;
            }
        }

        System.out.println("Tache critique la plus à droite : " + tacheAvecMoinsMarge);

        // On remonte jusqu'en haut du chemin + on met la valeur 'true' au champ 'critique' d'une tache
        calculeCheminCritiqueRecursive(tacheAvecMoinsMarge);

    }

    private void calculeCheminCritiqueRecursive(Tache t) {
        t.critique = true;
        t.save();
        if (t.hasPredecesseur())
            calculeCheminCritiqueRecursive(t.predecesseur);

        if (t.parent != null)
            calculeCheminCritiqueTacheMere(t.parent);
    }

    private void calculeCheminCritiqueTacheMere(Tache t) {
        t.critique = true;
        t.save();
        if (t.parent != null)
            calculeCheminCritiqueTacheMere(t.parent);
    }

    public void updateAvancementGlobal() {
        Double chargeConsommeeGlobal = 0.0;
        Double chargeRestanteGlobal = 0.0;
        for (Tache tache : listTaches) {
            if (!tache.hasParent()) {
                chargeConsommeeGlobal += tache.chargeConsommee;
                chargeRestanteGlobal += tache.chargeRestante;
            }
        }
        if (listTaches.size() != 0) {
            this.chargeConsommee = chargeConsommeeGlobal;
            this.chargeRestante = chargeRestanteGlobal;
            Double avancementDouble = chargeConsommeeGlobal / (chargeConsommeeGlobal + chargeRestanteGlobal);
            BigDecimal bd = new BigDecimal(avancementDouble);
            BigDecimal bd2 = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
            String result = bd2.toString();
            if (result.equals("1.00")) {
                // Par example: "1"
                this.avancementGlobal = new Byte("100");


            }
            else if (result.length() == 3) {
                // Par example: "0.1"
                this.avancementGlobal = new Byte(result.substring(2, 3) + "0");
                if(nom.equals("AZERT"))
                    System.out.println("Byte if = " + avancementGlobal + " - bd = " + bd + " bd2 = " + bd2 + " result " + result );

            } else {
                // Par example: "0.15"
                this.avancementGlobal = new Byte(result.substring(2, 4));
                if(nom.equals("AZERT"))
                    System.out.println("Byte else = " + avancementGlobal + " - bd = " + bd + " bd2 = " + bd2 +  " result " + result);
            }
        }
        save();
    }

    public String formateDate(Date d) {
        if (d != null) {
            return dateFormat.format(d);
        } else {
            return "";
        }
    }

    public String formateDateTri(Date d) {
        if (d != null) {
            return dateFormatTri.format(d);
        } else {
            return "";
        }
    }

    public static List<Projet> getAll() {
        return find.all();
    }

    public static List<Projet> getAllNonArchivesNonTermines() {
        return find.where()
                .eq("archive", false)
                .eq("enCours", true)
                .findList();
    }

    public static List<Projet> getAllArchives(Boolean check) {
        if (check) {
            return find.where().eq("archive", true).eq("enCours", true).findList();
        } else {
            return find.where().eq("archive", true).findList();
        }
    }

    public static List<Projet> getAllTermines(Boolean check) {
        if (check) {
            return find.where().eq("enCours", false).eq("archive", false).findList();
        } else {
            return find.where().eq("enCours", false).findList();
        }
    }

    public static Projet supprimerProjet(Long idProjet) {
        Projet p = find.byId(idProjet);
        p.archive = true;
        p.save();
        for (Tache tache : p.listTaches()) {
            tache.archive = true;
            tache.save();
        }

        /*
        System.out.println("P" + p.nom);
        for (int i = 0; i < p.client.listeProjets.size(); i++) {
            System.out.println(p.client.listeProjets.get(i).nom);
            System.out.println(p.client.listeProjets.get(i).archive);
        }
        */
        return p;
    }

    @JsonSerialize
    public boolean hasUniteJour() {
        return unite == UniteProjetEnum.JOUR;
    }

    @JsonSerialize
    public boolean hasUniteSemaine() {
        return unite == UniteProjetEnum.SEMAINE;
    }

    public boolean estRetarde() {
        if (dateFinReelTard != null) {
            //return dateFinReelTard.after(Calendar.getInstance().getTime());
            return Utils.after(dateFinReelTard, Calendar.getInstance().getTime());
        } else {
            return false;
        }
    }

    public boolean estPresqueFini() {
        return (avancementGlobal >= LIMITE_PROJET_PRESQUE_FINI && avancementGlobal < 100);
    }

    public boolean estTermine() {
        return avancementGlobal == 100;
    }

    @JsonSerialize
    public int prioriteProjetEtClient() {
        return priorite + client.priorite;
    }

    public List<Tache> listTaches() {
        listTaches = Tache.find.where().eq("projet", this).eq("archive", false).findList();
        try {
            calculeCheminCritique();
        } catch (Exception e) {
            System.err.println("Erreur pour calcul chemin critique : " + e.getMessage());
        }
        return listTaches;
    }

    public List<Tache> listTachesAAfficher() {
        listTaches = listTaches();
        List<Tache> taches = new BeanList<>();
        for (Tache tache : listTaches) {
            if (!tache.hasParent()) {
                taches.add(tache);
            }
        }
        // Trier en fonction de idTache (normalement que des int)
        Collections.sort(taches, new Comparator<Tache>() {
            @Override
            public int compare(Tache t1, Tache t2) {
                return Integer.parseInt(t1.idTache) - Integer.parseInt(t2.idTache);
            }
        });
        return taches;
    }

    /**
     * TODO : a utiliser dans draftProjet
     *
     * @return
     */
    public Map<String, String> checkProjet() {
        final Map<String, String> errors = new HashMap<>();
        for (Tache tache : listTaches) {
            // Verification des predecesseur et successeurs
            if (tache.hasPredecesseur()) {
                if (Utils.before(tache.dateDebut, tache.predecesseur.dateFinTard)) {
                    errors.put("e1", "incoherence au niveau des dates debut entre tache:" + tache.nom + " et tache: " + tache.predecesseur.nom);
                }
                if (!Tache.checkPERT(tache, tache.predecesseur)) {
                    errors.put("e2", "le predecesseur de la tache:" + tache.nom + " est un parent ou un enfant de la tache: " + tache.predecesseur.nom);
                }
            }

            if (tache.hasSuccesseur()) {
                for (int i = 0; i < tache.successeurs.size(); i++) {
                    if (Utils.after(tache.dateFinTard, tache.successeurs.get(i).dateDebut)) {
                        errors.put("e3-" + i, "incoherence au niveau des dates fin tard entre tache:" + tache.nom + " et tache: " + tache.successeurs.get(i).nom);
                    }
                    if (!Tache.checkPERT(tache, tache.successeurs.get(i))) {
                        errors.put("e4-" + i, "le sucesseur de la tache:" + tache.nom + " est un parent ou un enfant de la tache: " + tache.successeurs.get(i).nom);
                    }
                }
            }

            // Vérification des dates des parents
            if (tache.hasParent()) {
                if (Utils.after(tache.parent.dateDebut, tache.dateDebut)) {
                    errors.put("e5", "incoherence au niveau des dates debut entre tache:" + tache.parent.nom + " et tache: " + tache.nom);

                }
                if (Utils.before(tache.parent.dateFinTot, tache.dateFinTot)) {
                    errors.put("e6", "incoherence au niveau des dates fin tot entre tache:" + tache.parent.nom + " et tache: " + tache.nom);

                }
                if (Utils.before(tache.parent.dateFinTard, tache.dateFinTard)) {
                    errors.put("e7", "incoherence au niveau des dates fin tard entre tache:" + tache.parent.nom + " et tache: " + tache.nom);
                }
            }

            // Vérification des dates des enfants
            if (tache.hasEnfant()) {

                for (int i = 0; i < tache.enfants.size(); i++) {

                    if (Utils.after(tache.dateDebut, tache.enfants.get(i).dateDebut)) {
                        errors.put("e8-" + i, "incoherence au niveau des dates debut entre tache:" + tache.nom + " et tache: " + tache.enfants.get(i).nom);
                    }
                    if (Utils.before(tache.dateFinTot, tache.enfants.get(i).dateFinTot)) {
                        errors.put("e9-" + i, "incoherence au niveau des dates fin tot entre tache:" + tache.nom + " et tache: " + tache.enfants.get(i).nom);

                    }

                    if (Utils.before(tache.dateFinTard, tache.enfants.get(i).dateFinTard)) {
                        errors.put("e10-" + i, "incoherence au niveau des dates fin tard entre tache:" + tache.nom + " et tache: " + tache.enfants.get(i).nom);
                    }
                }
            }
        }
        return errors;
    }

    public void saveAllProject() {
        for (Tache tache : listTaches) {
            tache.saveAllTask();
        }
        //client.save();
        if (utilisateursNotifications != null) {
            for (Utilisateur user : utilisateursNotifications) {
                user.save();
            }
        }

        save();
        //responsableProjet.save();

    }


    public String filtres() {
        String result = "";
        if (this.estTermine()) {
            result = result + " projet-finished ";
        }
        if (this.estPresqueFini()) {
            result = result + " projet-presque-fini ";
        }
        if (this.estRetarde() == true) {
            result = result + " projet-retarde ";
        }

        System.out.println("fonction : checkout projet " + result);
        return result;
    }


}
