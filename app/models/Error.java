package models;

public class Error
{
    public boolean nomVide, nomTropLong;
    public boolean prenomVide, prenomTropLong;
    public boolean emailVide, emailIncorrecte;
    public boolean telVide, telIncorrecte;
    public boolean userExist;
    public boolean nomClientVide, nomClientTropLong;
    public boolean adresseVide, adresseTropLong;
    public boolean codePostalVide, codePostaleTropLong;
    public boolean villeVide,villeTropLong;
    public boolean paysVide, paysTropLong;
    public boolean descriptionTropLong;

    public boolean nomProjetVide;
    public boolean dateThDebutProjetVide,dateThFinProjetVide;

    public boolean nomVideContact, nomTropLongContact;
    public boolean prenomVideContact, prenomTropLongContact;
    public boolean emailVideContact, emailIncorrecteContact, emailTropLongContact;
    public boolean telVideContact, telIncorrecteContact, telTropLongContact;

    public boolean hasErrorUtilisateur()
    {
        return nomVide || nomTropLong
                || prenomVide || prenomTropLong
                || emailVide || emailIncorrecte
                || telVide || telIncorrecte || userExist;
    }

    public boolean hasErrorProjet(){
        return nomProjetVide || dateThDebutProjetVide || dateThFinProjetVide || descriptionTropLong;
    }

    public boolean hasErrorContact() {
        return nomVideContact || nomTropLongContact || prenomVideContact || prenomTropLongContact || emailVideContact
                || emailIncorrecteContact || telVideContact || telIncorrecteContact || telTropLongContact || emailTropLongContact;
    }

    public boolean hasErrorClient(){
        return nomClientVide || nomClientTropLong || adresseVide || adresseTropLong || codePostalVide || codePostaleTropLong
                || villeVide || villeTropLong || paysVide || paysTropLong;
    }

}