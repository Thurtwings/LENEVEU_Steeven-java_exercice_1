package RestaurantUpgrade;

import java.util.List;

public class Commande
{
    private List<Plat> plats;
    private Serveur serveur;
    private Table table;
    private CommandeStatut statut;

    public Commande(List<Plat> plats, Serveur serveur, Table table, CommandeStatut statut)
        {
            this.plats = plats;
            this.serveur = serveur;
            this.table = table;
            this.statut = CommandeStatut.NON_ORDERED;
        }

    public List<Plat> getPlats()
    {
        return plats;
    }

    public Serveur getServeur()
    {
        return serveur;
    }

    public Table getTable()
    {
        return table;
    }

    public void setPlats(List<Plat> plats)
    {
        this.plats = plats;
    }

    public void setServeur(Serveur serveur)
    {
        this.serveur = serveur;
    }

    public void setTable(Table table)
    {
        this.table = table;
    }

    public CommandeStatut getStatut()
    {
        return statut;
    }



    public void changerStatut(int statut)
    {
        if (statut >= 0 && statut <= 3)
        {
            switch (statut)
            {
                case 0:
                    this.statut = CommandeStatut.NON_ORDERED;
                    break;
                case 1:
                    this.statut = CommandeStatut.ORDERED;
                    break;
                case 2:
                    this.statut = CommandeStatut.SERVED;
                    break;
                case 3:
                    this.statut = CommandeStatut.PAID;
                    break;

            }

        }
        else this.statut = CommandeStatut.NON_ORDERED;

    }


    public double calculerMontant()
    {
        double montant = 0;
        for (Plat plat : plats) {
            montant += plat.getPrix();
        }
        return montant;
    }
}
