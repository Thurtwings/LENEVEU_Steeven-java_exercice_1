package RestaurantUpgrade;

public abstract class Personnel
{
    private String nom;
    private String prenom;
    private int anciennete;
    private String surnom;

    public Personnel(String nom, String prenom, int anciennete, String surnom) {
        this.nom = nom;
        this.prenom = prenom;
        this.anciennete = anciennete;
        this.surnom = surnom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAnciennete() {
        return anciennete;
    }

    public String getSurnom() {
        return surnom;
    }

    public abstract String getRole();
}
