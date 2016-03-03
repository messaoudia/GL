package models;

import com.avaje.ebean.common.BeanList;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import models.Exceptions.NotAvailableTask;
import models.Securite.EntiteSecurise;
import models.Utils.Utils;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table
@DiscriminatorValue("TACHE")
public class Tache extends EntiteSecurise {

    public static int NIVEAU_MAX = 3;

    public String idTache;
    @Constraints.Required
    public String nom;
    @Constraints.Required
    @Constraints.MinLength(4)
    public String description;
    @Constraints.Min(0)
    @Constraints.Max(3)
    public Integer niveau;
    public Boolean critique;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateDebut;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateFinTot;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateFinTard;
    @Constraints.Min(0)
    public Double chargeInitiale;
    @Constraints.Min(0)
    public Double chargeConsommee;
    @Constraints.Min(0)
    public Double chargeRestante;
    public Integer priorite = 0;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "listTachesCorrespondant")
    public List<Contact> interlocuteurs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    public Projet projet;

    @ManyToOne
    @JsonIgnore
    public Tache predecesseur;

    @OneToMany(mappedBy = "predecesseur")
    public List<Tache> successeurs;

    @ManyToOne
    public Tache parent;

    @OneToMany(mappedBy = "parent")
    @JsonIgnore
    public List<Tache> enfants;

    public boolean archive;

    public static Finder<Long, Tache> find = new Finder<>(Tache.class);

    @ManyToOne
    @JoinColumn
    public Utilisateur responsableTache;

    public boolean disponible;

    // TODO @qqch?
    @ManyToMany(cascade = CascadeType.ALL)
    public List<Utilisateur> utilisateursNotifications;

    public Tache(String nom, String description, Utilisateur responsableTache, Integer niveau, Boolean critique, Date dateDebut,
                 Date dateFinTot, Date dateFinTard, Double chargeInitiale, Double chargeConsommee,
                 Double chargeRestante, List<Contact> interlocuteurs, Projet projet, Tache predecesseur,
                 List<Tache> successeurs, List<Utilisateur> utilisateursNotifications, boolean disponible) {
        this.nom = nom;
        this.description = description;
        this.responsableTache = responsableTache;
        this.niveau = niveau;
        this.critique = critique;
        this.dateDebut = dateDebut;
        this.dateFinTot = dateFinTot;
        this.dateFinTard = dateFinTard;
        this.chargeInitiale = chargeInitiale;
        this.chargeConsommee = chargeConsommee;
        this.chargeRestante = chargeRestante;
        this.interlocuteurs = (interlocuteurs == null) ? new BeanList<>() : interlocuteurs;
        this.predecesseur = predecesseur;
        this.successeurs = (successeurs == null)?new BeanList<>():successeurs;
        this.enfants = new BeanList<>();
        this.projet = projet;
        this.archive = false;
        this.utilisateursNotifications = (utilisateursNotifications == null) ? new BeanList<>() : utilisateursNotifications;
        this.disponible = disponible;
    }

    public Tache() {
        this.interlocuteurs = new BeanList<>();
        this.successeurs = new BeanList<>();
        this.enfants = new BeanList<>();
        this.archive = false;
        this.utilisateursNotifications = new BeanList<>();
    }

    /**
     * Create a tache
     */
    public static Tache create(Tache tache) {
        tache.save();
        return tache;
    }

    public void initUtilisateursNotificationsEnfants(){
        for(Tache child : enfants){
            addUtilisateurNotification(child.responsableTache);
            child.addUtilisateurNotification(responsableTache);
            child.initUtilisateursNotificationsEnfants();
        }
    }

    public void initUtilisateursNotificationsParents(){
        if(hasParent()){
            addUtilisateurNotification(parent.responsableTache);
            parent.addUtilisateurNotification(responsableTache);
            parent.initUtilisateursNotificationsParents();
        }
    }

    public void addUtilisateurNotification(Utilisateur user){
        if(!utilisateursNotifications.contains(user)) {
            utilisateursNotifications.add(user);
            save();
        }
        if(!user.listTachesNotifications.contains(this)) {
            user.listTachesNotifications.add(this);
            user.save();
        }
    }

    public void removeUtilisateurNotification(Utilisateur user){
        if(!utilisateursNotifications.contains(user)) {
            utilisateursNotifications.remove(user);
            save();
        }
        if(!user.listTachesNotifications.contains(this)) {
            user.listTachesNotifications.remove(this);
            user.save();
        }
    }

    public void removeUtilisateurNotificationEnfants(){
        for(Tache child : enfants){
            removeUtilisateurNotification(child.responsableTache);
            child.removeUtilisateurNotification(responsableTache);
            child.removeUtilisateurNotificationEnfants();
        }
    }

    public void removeUtilisateurNotificationParents(){
        if(hasParent()){
            removeUtilisateurNotification(parent.responsableTache);
            parent.removeUtilisateurNotification(responsableTache);
            parent.removeUtilisateurNotificationParents();
        }
    }


    public static List<Tache> getAll() {
        return find.all();
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
            Tache tache = (Tache) obj;
            return (tache.id.equals(this.id) && tache.nom.equals(this.nom) &&
                    tache.idTache.equals(this.idTache) && tache.description.equals(this.description) &&
                    tache.niveau.equals(this.niveau) &&
                    tache.critique.equals(this.critique) &&
                    //tache.dateDebut.equals(this.dateDebut) &&
                    Utils.equals(tache.dateDebut, this.dateDebut) &&
                    //tache.dateFinTot.equals(this.dateFinTot) &&
                    Utils.equals(tache.dateFinTot, this.dateFinTot) &&
                    tache.chargeInitiale.equals(this.chargeInitiale) &&
                    //tache.dateFinTard.equals(this.dateFinTard) &&
                    Utils.equals(tache.dateFinTard, this.dateFinTard) &&
                    tache.chargeConsommee.equals(this.chargeConsommee) &&
                    tache.chargeRestante.equals(this.chargeRestante));
        } catch (ClassCastException e) {
            return false;
        }
    }

    public List<Tache> getSuccesseurs() {
        return find.where().eq("predecesseur", this).findList();
    }

    public List<Tache> getEnfants() {
        return find.where().eq("parent", this).findList();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Tâche : ").append(id).append(" - ").append(idTache).append("] : ").append(nom).append(", ").append(description);
        sb.append("\nniveau : ").append(niveau).append("\ncritique : ").append(critique);
        sb.append("\ndateDebut : ").append(dateDebut).append("\ndateFinTot : ").append(dateFinTot);
        sb.append("\ndateFinTard : ").append(dateFinTard).append("\nchargeInitiale : ").append(chargeInitiale);
        sb.append("\nchargeConsommee : ").append(chargeConsommee).append("\nchargeRestante : ").append(chargeRestante);
        sb.append("\ninterlocuteurs : ");
        for (Contact c : interlocuteurs) {
            sb.append("\n\t").append(c);
        }
        sb.append("\nprojet : ").append(projet.nom);
        sb.append("\nresponsableTache : ").append(responsableTache.nom).append("\n");
        return sb.toString();
    }

    public void setChargeConsommee(Double chargeConsommee) throws NotAvailableTask{
        if (enfants.size() != 0) {
            throw new NotAvailableTask("Tache " + nom + " non terminale, modification de ses filles uniquement");
        }
        this.chargeConsommee = chargeConsommee;
        updateChargeConsommeeTacheRecursive(this);
        updateChargeRestanteTacheRecursive(this);
        save();
    }

    public void setChargeRestante(Double chargeRestante) throws NotAvailableTask{
        if (enfants.size() != 0) {
            throw new NotAvailableTask("Tache " + nom + " non terminale, modification de ses filles uniquement");
        }
        this.chargeRestante = chargeRestante;
        updateEtatDisponibleSuccesseurs();
        updateChargeConsommeeTacheRecursive(this);
        updateChargeRestanteTacheRecursive(this);
        save();
    }

    private void updateEtatDisponibleSuccesseurs(){
        if(this.chargeRestante == 0.0 && hasSuccesseur()){
            for(Tache successeur : successeurs){
                successeur.disponible = true;
                successeur.save();
            }
            save();
        }
    }

    /**
     * Modifie la charge de la tâche actuelle avec les charges en parametre
     *
     * @param chargeConsommee
     * @param chargeRestante
     * @throws NotAvailableTask
     */

    public void initCharge(Double chargeConsommee, Double chargeRestante){
        this.chargeConsommee = chargeConsommee;
        this.chargeRestante = chargeRestante;
        updateEtatDisponibleSuccesseurs();
        updateChargesTachesMeresEtProjet();
    }
    public void modifierCharge(Double chargeConsommee, Double chargeRestante) throws NotAvailableTask {
        if (!estDisponible()) {
            throw new NotAvailableTask("Tache " + nom + ", pas encore disponible, modification de charge impossible");
        }
        if (enfants.size() != 0) {
            throw new NotAvailableTask("Tache " + nom + " non terminale, modification de ses filles uniquement");
        }
        this.chargeConsommee = chargeConsommee;
        this.chargeRestante = chargeRestante;
        updateEtatDisponibleSuccesseurs();
        updateChargesTachesMeresEtProjet();
    }

    public void updateChargesTachesMeresEtProjet(){
        updateChargeConsommeeTacheRecursive(this);
        updateChargeRestanteTacheRecursive(this);
        projet.updateAvancementGlobal(); // met a jour les charges du projet
        save();
        projet.save();
    }

    /**
     * Cree une sous-tâche a cette tâche
     *
     * @param fille
     */
    public void associerSousTache(Tache fille) throws IllegalStateException {
        if (niveau == NIVEAU_MAX) {
            throw new IllegalStateException("Creation d'une tache fille de niveau superieur a 3 impossible");
        }
        if (this.enfants.contains(fille)) {
            throw new IllegalStateException("Il y a deja cette tache enfant pour cette tache");
        }
        enfants.add(fille);
        save();
    }

    /**
     * Cree une tache mere a cette tâche
     *
     * @param parent
     */
    private void associerTacheMere(Tache parent) throws IllegalStateException {
        if (niveau == 0) {
            throw new IllegalStateException("Association d'une tache mere a une tache de niveau 0 impossible");
        }
        if (this.parent == parent) {
            throw new IllegalStateException("Ce parametre est le meme que le parent de cette tache");
        }
        this.parent = parent;
        save();
    }

    /**
     * Affecte l'utilisateur en parametre en tant que responsableProjet de la tache
     *
     * @param responsable
     * @throws IllegalStateException
     */
    public void associerResponsable(Utilisateur responsable) throws IllegalStateException {
        if (this.responsableTache != null) {
            throw new IllegalStateException("Il y a deja un responsableProjet pour cette tache");
        }
        this.responsableTache = responsable;
    }

    /**
     * TODO testme
     * Modifie le responsableProjet de tache par l'utilisateur en parametre
     *
     * @param responsable
     * @throws IllegalArgumentException
     */
    @Transient
    public void modifierResponsable(Utilisateur responsable) throws IllegalArgumentException {
        if (this.responsableTache == responsable) {
            throw new IllegalArgumentException("Remplacement du responsableProjet de tache par le même responsable de Tache");
        }

        Utilisateur ancienResponsableTache = this.responsableTache;
        this.responsableTache = responsable;
        removeUtilisateurNotification(ancienResponsableTache);
        addUtilisateurNotification(this.responsableTache);
    }

    /**
     * Affecte la tache en parametre en tant que predecesseur de la tache courante
     *
     * @param predecesseur
     * @throws IllegalStateException
     */
    private void associerPredecesseur(Tache predecesseur) throws IllegalStateException {
        if (this.predecesseur == predecesseur) {
            throw new IllegalStateException("Ce parametre est le meme que le predecesseur de cette tache");
        }
        this.predecesseur = predecesseur;
        if(predecesseur.successeurs == null){
            predecesseur.successeurs = new BeanList<>();
        }
        if(!predecesseur.successeurs.contains(this)){
            predecesseur.successeurs.add(this);
        }
        predecesseur.save();
        save();
    }

    /**
     * TODO testme
     * Modifie le predecesseur de la tache par la tache en parametre
     *
     * @param predecesseur
     * @throws IllegalArgumentException
     */
    public void modifierPredecesseur(Tache predecesseur) throws IllegalArgumentException {
        if (this.predecesseur.equals(predecesseur)) {
            throw new IllegalArgumentException("Remplacement du predecesseur de la tache courante par le même predecesseur");
        }
        if(this.predecesseur.hasSuccesseur() && this.predecesseur.successeurs.contains(this))
            this.predecesseur.successeurs.remove(this);
        associerPredecesseur(predecesseur);
    }

    /**
     * Ajoute la tache en parametre en tant que sucesseur de la tache courante
     *
     * @param successeur
     * @throws IllegalStateException
     */
    public void associerSuccesseur(Tache successeur) throws IllegalStateException {
        if (this.successeurs.contains(successeur)) {
            throw new IllegalStateException("Il y a deja ce successeur pour cette tache");
        }
        successeur.associerPredecesseur(this);
        successeurs.add(successeur);
        save();
    }

    /**
     * TODO testme
     *
     * @return la charge totale pour ce projet (en l'unité définie pour le projet)
     */
    public Double chargeTotale() {
        return chargeConsommee + chargeRestante;
    }

    /**
     * TODO testme
     *
     * @return true si la tache précédente est finie a 100% ou si pas de tache, false sinon
     */
    public boolean estDisponible() {
        return disponible;
    }

    public boolean estRetardee() {
        return dateFinTard.before(Calendar.getInstance().getTime());
    }

    public boolean hasPredecesseur() {
        return predecesseur != null;
    }

    public boolean hasSuccesseur() {
        return successeurs != null && !successeurs.isEmpty();
    }

    public int nbSuccesseurs(){
        return successeurs.size();
    }

    /**
     * Vérifier la cohérence des 3 dates (dateDebut <= dateFinTot <= dateFinTard)
     */
    public boolean verifierCoherenceDesDates() {
        if ((this.dateDebut.compareTo(this.dateFinTot) < 1) && (this.dateFinTot.compareTo(this.dateFinTard) < 1))
            return true;
        else return false;
    }

    /**
     * TODO testme
     */
    public Double getAvancementTache() {
        return (chargeConsommee / (chargeConsommee + chargeRestante));
    }

    /**
     * TODO testme
     * Vérification de l'ordre des sous-taches (enfants)
     * Parcourir la liste d'enfants, pour chaque sous-tache,
     * on verifie que dateFinTard de predecesseur <= dateDebut de sous-tache
     * et dateFinTard de sous-tache <= dateDebut de toutes les successeurs.
     */
    public boolean verifierOrdreSousTaches() {
        for(Tache sousTache : enfants){
            if(sousTache.hasPredecesseur()) {
                //if(sousTache.predecesseur.dateFinTard.after(sousTache.dateDebut)) return false;
                if(Utils.after(sousTache.predecesseur.dateFinTard, sousTache.dateDebut)) return false;
            }
            if(sousTache.hasSuccesseur()) {
                for(Tache successeur : sousTache.successeurs) {
                    //if(sousTache.dateFinTard.after(successeur.dateDebut)) return false;
                    if(Utils.after(sousTache.dateFinTard, successeur.dateDebut)) return false;
                }
            }
        }
        return true;
    }

    public boolean hasParent() {
        return parent != null;
    }
    public boolean hasEnfant() {
        return enfants != null || enfants.isEmpty();
    }

    /**
     * Mets a jour la charge consommee de la tâche éventuellement composée de sous-tâches
     */
    private void updateChargeConsommeeTacheRecursive(Tache tache) {
        if(tache.hasParent()) {
            Double chargeConsommeeNouvel = 0.0;
            for(Tache tacheMemeNiveau : tache.parent.enfants){
                chargeConsommeeNouvel += tacheMemeNiveau.chargeConsommee;
            }
            tache.parent.chargeConsommee = chargeConsommeeNouvel;
            tache.parent.save();
            updateChargeConsommeeTacheRecursive(tache.parent);
        }
    }

    /**
     * Mets a jour la charge totale de la tâche éventuellement composée de sous-tâches
     */
    private void updateChargeRestanteTacheRecursive(Tache tache) {
        if(tache.hasParent()) {
            Double chargeRestanteNouvel = 0.0;
            for(Tache tacheMemeNiveau : tache.parent.enfants){
                chargeRestanteNouvel += tacheMemeNiveau.chargeRestante;
            }
            tache.parent.chargeRestante = chargeRestanteNouvel;
            tache.parent.save();
            tache.parent.updateEtatDisponibleSuccesseurs();
            updateChargeRestanteTacheRecursive(tache.parent);
        }
    }

    final String DATE_PATTERN = "dd/MM/yyyy";
    final String DATE_PATTERN_TRI = "yyyy/MM/dd";
    final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
    final SimpleDateFormat dateFormatTri = new SimpleDateFormat(DATE_PATTERN_TRI);

    public String formateDate(Date d){
        return dateFormat.format(d);
    }

    public String formateDateTri(Date d){
        return dateFormatTri.format(d);
    }

    public List<Tache> enfants() {
        enfants =  Tache.find.where().eq("parent",this).findList();
        // Trier en fonction de idTache (tri que sur le dernier int)
        Collections.sort(enfants, new Comparator<Tache>(){
            @Override
            public int compare(Tache t1, Tache t2) {
                String[] idT1parse = t1.idTache.split("\\.");
                String[] idT2parse = t2.idTache.split("\\.");
                return Integer.parseInt(idT1parse[t1.niveau]) - Integer.parseInt(idT2parse[t2.niveau]);
            }
        });
        return enfants;
    }

    public boolean estTerminee(){ return getAvancementTache() == 100.0; }

    public long nbJourRestant() {
        Calendar cal = Calendar.getInstance();
        Calendar today = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE));
        long diff = Utils.differenceNbJours(today.getTime(), dateFinTard);
        if(diff<0)
            diff=0;
        return diff;
    }

    // TODO ajouter l'exception(chargeConsomee>chargeRestante) dans la fonction modifierCharge + test exception

    /**
     * TODO enlever les parents directs
     * @return
     */
    @JsonIgnore
    public List<Tache> getAllPredecesseursPossible() {
        List<Tache> listPredecesseurs = Tache.find.where().eq("projet",projet).le("dateFinTard",dateDebut).findList();
        return listPredecesseurs;
    }

    /**
     * TODO enlever les parents directs
     * @return
     */
    @JsonIgnore
    public List<Tache> getAllSuccesseursPossible() {
        List<Tache> listSuccesseur = Tache.find.where().eq("projet",projet).ge("dateDebut",dateFinTard).findList();
        return listSuccesseur;
    }

    public List<Tache> getAllTacheNonParentsDirects(List<Tache> listTache){
        List<Tache> listResult = new ArrayList<>();
        for(Tache t : listTache){
            switch (t.niveau){
                case 0 :
                    if(t.successeurs != null && !t.successeurs.contains(this)){
                        for (Tache tSucc : t.successeurs) {
                            if (tSucc.successeurs != null && !tSucc.successeurs.contains(this)) {
                                break;
                            }
                        }
                    }
                    listResult.add(t);
                    break;
                case 1 :
                    if(t.predecesseur != null && !t.predecesseur.equals(this) && t.successeurs != null && !t.successeurs.contains(this)){
                        if(t.successeurs != null) {
                            for (Tache tSucc : t.successeurs) {
                                if (tSucc.successeurs != null && tSucc.successeurs.contains(this)) {
                                    break;
                                }
                            }
                        }
                        listResult.add(t);
                    }
                    break;
                case 2 :
                    if(t.predecesseur != null && !t.predecesseur.equals(this) && t.predecesseur.predecesseur != null && !t.predecesseur.predecesseur.equals(this) &&
                            t.successeurs != null && !t.successeurs.contains(this)){
                        listResult.add(t);
                    }
                    break;
                case 3 :
                    if(t.predecesseur != null && !t.predecesseur.equals(this) && t.predecesseur.predecesseur != null&& !t.predecesseur.predecesseur.equals(this) &&
                            !t.predecesseur.predecesseur.predecesseur.equals(this)){
                        listResult.add(t);
                    }
                    break;
                default : break;
            }
        }
        if(listResult.contains(this)){
            listResult.remove(this);
        }
        return listResult;
    }
}