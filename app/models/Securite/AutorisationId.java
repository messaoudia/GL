package models.Securite;

import javax.persistence.Embeddable;

/**
 * Created by yachironi on 23/02/16.
 */
@Embeddable
public class AutorisationId implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Long utilisateur_id;
    public Long entite_securise_id;

    public AutorisationId() {

    }

    public AutorisationId(Long utilisateur_id, Long entite_securise_id) {
        this.utilisateur_id = utilisateur_id;
        this.entite_securise_id = entite_securise_id;
    }

    public Long getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(Long utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public Long getEntite_securise_id() {
        return entite_securise_id;
    }

    public void setEntite_securise_id(Long entite_securise_id) {
        this.entite_securise_id = entite_securise_id;
    }

    public int hashCode() {
        return Math.toIntExact(utilisateur_id + entite_securise_id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        AutorisationId b = (AutorisationId) obj;
        if (b == null)
            return false;
        if (b.utilisateur_id == utilisateur_id && b.entite_securise_id == entite_securise_id) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return utilisateur_id + ", " + entite_securise_id;
    }
}
