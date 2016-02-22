package models;

import com.avaje.ebean.common.BeanList;
import models.Exceptions.NotAvailableTask;
import models.Securite.EntiteSecurise;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table
@DiscriminatorValue("TACHE")
public class Tache extends EntiteSecurise {


    @Constraints.Required
    public String nom;
    @Constraints.Required
    @Constraints.MinLength(4)
    public String description;
    @Constraints.Min(0)
    @Constraints.Max(3)
    public Integer niveau;
    public Boolean critique;
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateDebut;
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateFinTot;
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
    public Tache predecesseur;
    @OneToMany(mappedBy = "predecesseur")
    public List<Tache> successeurs;

    @ManyToOne
    public Tache parent;
    @OneToMany(mappedBy = "parent")
    public List<Tache> enfants;

    public boolean archive;

    public static Finder<Long, Tache> find = new Finder<>(Tache.class);

    @ManyToOne(cascade = CascadeType.ALL)
    public Utilisateur responsableTache;

    public Tache(String nom, String description, Integer niveau, Boolean critique, Date dateDebut,
                 Date dateFinTot, Date dateFinTard, Double chargeInitiale, Double chargeConsommee,
                 Double chargeRestante, List<Contact> interlocuteurs, Projet projet) {
        this.nom = nom;
        this.description = description;
        this.niveau = niveau;
        this.critique = critique;
        this.dateDebut = dateDebut;
        this.dateFinTot = dateFinTot;
        this.dateFinTard = dateFinTard;
        this.chargeInitiale = chargeInitiale;
        this.chargeConsommee = chargeConsommee;
        this.chargeRestante = chargeRestante;
        this.interlocuteurs = (interlocuteurs == null) ? new BeanList<>() : interlocuteurs;
        this.successeurs = new BeanList<>();
        this.enfants = new BeanList<>();
        this.projet = projet;
        this.archive = false;
    }

    public Tache() {
        this.interlocuteurs = new BeanList<>();
        this.successeurs = new BeanList<>();
        this.enfants = new BeanList<>();
        this.archive = false;
    }

    /**
     * Create a tache
     */
    public static Tache create(Tache tache) {
        tache.save();
        return tache;
    }

    /**
     * Create a task
     */
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
                    tache.description.equals(this.description) &&
                    tache.niveau.equals(this.niveau) &&
                    tache.critique.equals(this.critique) &&
                    tache.dateDebut.equals(this.dateDebut) &&
                    tache.dateFinTot.equals(this.dateFinTot) &&
                    tache.chargeInitiale.equals(this.chargeInitiale) &&
                    tache.dateFinTard.equals(this.dateFinTard) &&
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
        sb.append("[Tâche : ").append(id).append("] : ").append(nom).append(", ").append(description);
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

    public double getChargeConsommee() {
        return this.chargeConsommee;
    }

    public Double getchargeRestante() {
        return this.chargeRestante;
    }

    public void setChargeConsommee(Double chargeConsommee) throws NotAvailableTask{
        if (enfants.size() != 0) {
            throw new NotAvailableTask("Tache " + nom + " non terminale, modification de ses filles uniquement");
        }
        this.chargeConsommee = chargeConsommee;
        updateChargeConsommeeTacheRecursive(this);
        updatechargeRestanteTacheRecursive(this);
        save();
    }

    public void setchargeRestante(Double chargeRestante) throws NotAvailableTask{
        if (enfants.size() != 0) {
            throw new NotAvailableTask("Tache " + nom + " non terminale, modification de ses filles uniquement");
        }
        this.chargeRestante = chargeRestante;
        updateChargeConsommeeTacheRecursive(this);
        updatechargeRestanteTacheRecursive(this);
        save();
    }

    /**
     * Modifie la charge de la tâche actuelle avec les charges en parametre
     *
     * @param chargeConsommee
     * @param chargeRestante
     * @throws NotAvailableTask
     */
    public void modifierCharge(Double chargeConsommee, Double chargeRestante) throws NotAvailableTask {
        if (!estDisponible()) {
            throw new NotAvailableTask("Tache " + nom + ", pas encore disponible, modification de charge impossible");
        }
        if (enfants.size() != 0) {
            throw new NotAvailableTask("Tache " + nom + " non terminale, modification de ses filles uniquement");
        }
        this.chargeConsommee = chargeConsommee;
        this.chargeRestante = chargeRestante;
        updateChargeConsommeeTacheRecursive(this);
        updatechargeRestanteTacheRecursive(this);
        updateAvancementTache();
    }

    /**
     * TODO testme
     * Mets a jour l'avancement de la tâche éventuellement composée de sous-tâches
     */
    private void updateAvancementTache() {
        //TODO set avancement en fonction des tâches filles (récursivement)
    }

    /**
     * Cree une sous-tâche a cette tâche
     *
     * @param fille
     */
    public void associerSousTache(Tache fille) throws IllegalStateException {
        if (niveau == 3) {
            throw new IllegalStateException("Creation d'une tache fille de niveau superieur a 3 impossible");
        }
        if (this.enfants.contains(fille)) {
            throw new IllegalStateException("Il y a deja cette tache enfant pour cette tache");
        }
        fille.niveau = this.niveau + 1;
        fille.associerTacheMere(this);
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
    public void modifierResponsable(Utilisateur responsable) throws IllegalArgumentException {
        if (this.responsableTache == responsable) {
            throw new IllegalArgumentException("Remplacement du responsableProjet de tache par le même responsableProjet");
        }
        this.responsableTache = responsable;
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
        if (this.predecesseur == predecesseur) {
            throw new IllegalArgumentException("Remplacement du predecesseur de la tache courante par le même predecesseur");
        }
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
        return (predecesseur == null || predecesseur.chargeRestante == 0.0);
    }

    public boolean hasPredecesseur() {
        return predecesseur != null;
    }

    public boolean hasSuccesseur() {
        return !successeurs.isEmpty();
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
                if(sousTache.predecesseur.dateFinTard.after(sousTache.dateDebut)) return false;
            }
            if(sousTache.hasSuccesseur()) {
                for(Tache successeur : sousTache.successeurs) {
                    if(sousTache.dateFinTard.after(successeur.dateDebut)) return false;
                }
            }
        }
        return true;
    }

    public boolean hasParent() {
        return parent != null;
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
    private void updatechargeRestanteTacheRecursive(Tache tache) {
        if(tache.hasParent()) {
            Double chargeRestanteNouvel = 0.0;
            for(Tache tacheMemeNiveau : tache.parent.enfants){
                chargeRestanteNouvel += tacheMemeNiveau.chargeRestante;
            }
            tache.parent.chargeRestante = chargeRestanteNouvel;
            tache.parent.save();
            updatechargeRestanteTacheRecursive(tache.parent);
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


    // TODO ajouter l'exception(chargeConsomee>chargeRestante) dans la fonction modifierCharge + test exception


}