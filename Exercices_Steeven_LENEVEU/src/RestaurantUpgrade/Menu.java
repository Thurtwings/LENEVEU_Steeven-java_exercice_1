package RestaurantUpgrade;

import java.util.ArrayList;

public class Menu {
    private String nom;
    private ArrayList<Plat> plats;

    public Menu(String nom, ArrayList<Plat> plats) {
        this.nom = nom;
        this.plats = plats;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Plat> getPlats() {
        return plats;
    }

}

