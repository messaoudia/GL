package models;

import com.avaje.ebean.common.BeanList;
import models.Exceptions.IllegalTaskCreation;
import models.Exceptions.NotAvailableTask;
import models.Securite.EntiteSecurise;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
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
    public Integer chargeInitiale;
    @Constraints.Min(0)
    public Integer chargeConsommee;
    @Constraints.Min(0)
    public Integer chargeTotale;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "listTachesCorrespondant")
    public List<Contact> interlocuteurs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    public Projet projet;

    @ManyToOne(cascade = CascadeType.ALL)
    public Tache predecesseur;
    @OneToMany(mappedBy = "predecesseur", cascade = CascadeType.ALL)
    public List<Tache> successeurs;

    @ManyToOne(cascade = CascadeType.ALL)
    public Tache parent;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Tache> enfants;

    public static Finder<Long, Tache> find = new Finder<>(Tache.class);

    @ManyToOne(cascade = CascadeType.ALL)
    public Utilisateur responsableTache;

    public Tache(String nom, String description, Integer niveau, Boolean critique, Date dateDebut,
                 Date dateFinTot, Date dateFinTard, Integer chargeInitiale, Integer chargeConsommee,
                 Integer chargeTotale, List<Contact> interlocuteurs, Projet projet) {
        this.nom = nom;
        this.description = description;
        this.niveau = niveau;
        this.critique = critique;
        this.dateDebut = dateDebut;
        this.dateFinTot = dateFinTot;
        this.dateFinTard = dateFinTard;
        this.chargeInitiale = chargeInitiale;
        this.chargeConsommee = chargeConsommee;
        this.chargeTotale = chargeTotale;
        this.interlocuteurs = (interlocuteurs==null)?new BeanList<>():interlocuteurs;
        this.successeurs = new BeanList<>();
        this.enfants = new BeanList<>();
        this.projet = projet;
    }

    public Tache() {
        this.interlocuteurs = new BeanList<>();
        this.successeurs = new BeanList<>();
        this.enfants = new BeanList<>();
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
                    tache.chargeTotale.equals(this.chargeTotale));
        } catch (ClassCastException e) {
            return false;
        }
    }

    public List<Tache> getSuccesseurs(){
        return find.where().eq("predecesseur",this).findList();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Tâche : ").append(id).append("] : ").append(nom).append(", ").append(description);
        sb.append("\nniveau : ").append(niveau).append("\ncritique : ").append(critique);
        sb.append("\ndateDebut : ").append(dateDebut).append("\ndateFinTot : ").append(dateFinTot);
        sb.append("\ndateFinTard : ").append(dateFinTard).append("\nchargeInitiale : ").append(chargeInitiale);
        sb.append("\nchargeConsommee : ").append(chargeConsommee).append("\nchargeTotale : ").append(chargeTotale);
        sb.append("\ninterlocuteurs : ");
        for (Contact c :interlocuteurs) {
            sb.append("\n\t").append(c);
        }
        sb.append("\nprojet : ").append(projet.nom);
        sb.append("\nresponsableTache : ").append(responsableTache.nom).append("\n");
        return sb.toString();
    }

    /**
     * TODO testme
     * Modifie la charge de la tâche actuelle avec les charges en parametre
     *
     * @param chargeConsommee
     * @param chargeTotale
     * @throws NotAvailableTask
     */
    public void modifierCharge(Integer chargeConsommee, Integer chargeTotale) throws NotAvailableTask {
        if (!estDisponible()) {
            throw new NotAvailableTask("Tache " + nom + ", pas encore disponible, modification de charge impossible");
        }
        if (enfants.size() != 0) {
            throw new NotAvailableTask("Tache " + nom + " non terminale, modification de ses filles uniquement");
        }
        this.chargeConsommee = chargeConsommee;
        this.chargeTotale = chargeTotale;
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
     * TODO testme
     * Cree une sous-tâche a cette tâche
     *
     * @param fille
     * @throws IllegalTaskCreation
     */
    public void associerSousTache(Tache fille) throws IllegalTaskCreation {
        if (niveau == 3) {
            throw new IllegalTaskCreation("Creation d'une tache fille de niveau superieur a 3 impossible");
        }
        enfants.add(fille);
    }

    /**
     * TODO testme
     * Cree une tache mere a cette tâche
     *
     * @param mere
     * @throws IllegalTaskCreation
     */
    public void associerTacheMere(Tache mere) throws IllegalTaskCreation {
        if (niveau == 3) {
            throw new IllegalTaskCreation("Creation d'une tache fille de niveau superieur a 3 impossible");
        }
        this.parent = mere;
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
    public void associerPredecesseur(Tache predecesseur) throws IllegalStateException {
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
     * @return la charge restante pour ce projet (en l'unité définie pour le projet)
     */
    public Integer chargeRestante() {
        return chargeTotale - chargeConsommee;
    }

    /**
     * TODO testme
     * @return true si la tache précédente est finie a 100% ou si pas de tache, false sinon
     */
    public boolean estDisponible() {
        return (predecesseur == null || predecesseur.chargeRestante() == 0);
    }

}