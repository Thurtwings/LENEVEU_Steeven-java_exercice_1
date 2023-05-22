package RestaurantUpgrade;

public class Serveur extends Personnel{
    public Serveur(String nom, String prenom, int anciennete, String surnom) {
        super(nom, prenom, anciennete, surnom);
    }

    @Override
    public String getRole() {
        return "Serveur";
    }
}
