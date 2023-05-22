package RestaurantUpgrade;

import java.util.List;

public class Facture
{
    private List<Plat> plats;
    private Commande commande;
    private double montant;
    private Serveur serveur;

    public Facture(List<Plat> plats, double montant, Serveur serveur, Commande commande)
    {
        this.plats = plats;
        this.serveur = serveur;
        this.commande = commande;
        this.montant = commande.calculerMontant();
    }


    public List<Plat> getPlats()
    {
        return plats;
    }

    public double getMontant()
    {
        return montant;
    }

    public Serveur getServeur()
    {
        return serveur;
    }

    public Commande getCommande()
    {
        return commande;
    }

    @Override
    public String toString()
    {
        return "Facture{" +
                "plats=" + plats +
                ", montant=" + montant +
                ", serveur=" + serveur +
                ", commande=" + commande +
                '}';
    }




}
