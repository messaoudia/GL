package models;

import models.Exceptions.IllegalTaskCreation;
import models.Exceptions.NotAvailableTask;
import models.Securite.EntiteSecurise;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
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
    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public LocalDate dateDebut;
    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public LocalDate dateFinTot;
    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public LocalDate dateFinTard;
    @Constraints.Min(0)
    public Integer chargeInitiale;
    @Constraints.Min(0)
    public Integer chargeConsommee;
    @Constraints.Min(0)
    public Integer chargeTotale;
    public Boolean disponible;

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
    public List<Tache> enfants;

    public static Finder<Long, Tache> find = new Finder<>(Tache.class);

    @ManyToOne
    public Utilisateur responsable;

    public Tache(String nom, String description, Integer niveau, Boolean critique, LocalDate dateDebut,
                 LocalDate dateFinTot, LocalDate dateFinTard, Integer chargeInitiale, Integer chargeConsommee,
                 Integer chargeTotale, Boolean disponible, List<Contact> interlocuteurs, Projet projet) {
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
        this.disponible = disponible;
        this.interlocuteurs = interlocuteurs;
        this.projet = projet;
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
                    tache.chargeTotale.equals(this.chargeTotale) &&
                    tache.disponible.equals(this.disponible) &&
                    tache.projet.id.equals(this.projet.id));
        } catch (ClassCastException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "[Tâche : " + id + "] : " + nom + ", " + description +
                "\nniveau : " + niveau + "\ncritique : " + critique +
                "\ndateDebut : " + dateDebut + "\ndateFinTot : " + dateFinTot +
                "\ndateFinTard : " + dateFinTard + "\nchargeInitiale : " + chargeInitiale +
                "\nchargeConsommee : " + chargeConsommee + "\nchargeTotale : " + chargeTotale +
                "\ndisponible : " + disponible + "\ninterlocuteurs : " + interlocuteurs +
                "\nprojet : " + projet.nom + "\n";
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
        if (!disponible) {
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
     * TODO testme
     * Affecte l'utilisateur en parametre en tant que responsable de la tache
     *
     * @param responsable
     * @throws IllegalStateException
     */
    public void associerResponsable(Utilisateur responsable) throws IllegalStateException {
        if (this.responsable != null) {
            throw new IllegalStateException("Il y a deja un responsable pour cette tache");
        }
        this.responsable = responsable;
    }

    /**
     * TODO testme
     * Modifie le responsable de tache par l'utilisateur en parametre
     *
     * @param responsable
     * @throws IllegalArgumentException
     */
    public void modifierResponsable(Utilisateur responsable) throws IllegalArgumentException {
        if (this.responsable == responsable) {
            throw new IllegalArgumentException("Remplacement du responsable de tache par le même responsable");
        }
        this.responsable = responsable;
    }

    /**
     * TODO testme
     * Affecte la tache en parametre en tant que predecesseur de la tache courante
     *
     * @param predecesseur
     * @throws IllegalStateException
     */
    public void associerPredecesseur(Tache predecesseur) throws IllegalStateException {
        if (this.predecesseur != null) {
            throw new IllegalStateException("Il y a deja un predecesseur pour cette tache");
        }
        this.predecesseur = predecesseur;
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
        this.predecesseur = predecesseur;
    }

    /**
     * TODO testme
     * Ajoute la tache en parametre en tant que sucesseur de la tache courante
     *
     * @param successeur
     * @throws IllegalStateException
     */
    public void associerSuccesseur(Tache successeur) throws IllegalStateException {
        if (this.successeurs.contains(successeur)) {
            throw new IllegalStateException("Il y a deja ce successeur pour cette tache");
        }
        this.successeurs.add(successeur);
    }

    /**
     * TODO testme
     *
     * @return la charge restante pour ce projet (en l'unité définie pour le projet)
     */
    public Integer getChargeRestante() {
        return chargeTotale - chargeConsommee;
    }
}