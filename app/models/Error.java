package models;

public class Error
{
    public boolean nomVide, nomTropLong, nomIncorrect;
    public boolean prenomVide, prenomTropLong, prenomIncorrect;
    public boolean emailVide, emailIncorrecte, emailTropLong;
    public boolean telVide, telIncorrecte, telTropLong;
    public boolean userExist;

    public boolean hasErrorUtilisateur()
    {
        return nomVide || nomTropLong || nomIncorrect
                || prenomVide || prenomTropLong || prenomIncorrect
                || emailVide || emailIncorrecte || emailTropLong
                || telVide || telIncorrecte || telTropLong
                || userExist;
    }

}