package models;

public class Error
{
    public boolean nomVide, nomTropLong;
    public boolean prenomVide, prenomTropLong;
    public boolean emailVide, emailIncorrecte, emailTropLong;
    public boolean telVide, telIncorrecte, telTropLong;
    public boolean userExist;

    public boolean hasErrorUtilisateur()
    {
        return nomVide || nomTropLong
                || prenomVide || prenomTropLong
                || emailVide || emailIncorrecte || emailTropLong
                || telVide || telIncorrecte || telTropLong
                || userExist;
    }

}