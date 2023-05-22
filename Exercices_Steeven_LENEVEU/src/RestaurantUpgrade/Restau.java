package RestaurantUpgrade;

import java.util.*;

public class Restau
{
    private ArrayList<Personnel> personnel;
    private ArrayList<Commis> commis;
    private ArrayList<Serveur> serveurs;
    private ArrayList<Chef> chefs;
    private ArrayList<Client> clients;
    private ArrayList<Plat> platsHorsMenu;
    private ArrayList<Menu> menus;
    private ArrayList<Table> tables;
    private ArrayList<Commande> commandes;
    private ArrayList<Facture> factures;

    public Restau() {
        personnel = new ArrayList<Personnel>();
        clients = new ArrayList<Client>();
        platsHorsMenu = new ArrayList<Plat>();
        menus = new ArrayList<Menu>();
        tables = new ArrayList<Table>();
        commandes = new ArrayList<Commande>();
        factures = new ArrayList<Facture>();
    }

    public void ajouterPersonnel(Personnel p) {
        personnel.add(p);
    }

    public void ajouterClient(Client c) {
        clients.add(c);
    }

    public void ajouterPlatHorsMenu(Plat p) {
        platsHorsMenu.add(p);
    }

    public void ajouterMenu(Menu m) {
        menus.add(m);
    }

    public void ajouterTable(Table t) {
        tables.add(t);
    }

    public ArrayList<Personnel> getPersonnel() {
        return personnel;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<PlatHorsMenu() {
    return platsHorsMenu;
}

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void affecterClientTable(Client client, Table table) {
        table.addClient(client);
    }

    public void commanderMenu(Table table, Menu menu, Serveur serveur) {
        table.setMenu(menu);
        commandes.add(new Commande(menu.getPlats(), serveur));
        table.setStatut("commandé");
    }

    public void commanderPlat(Table table, Plat plat, Serveur serveur) {
        table.addPlat(plat);
        commandes.add(new Commande(new ArrayList<Plat>(){{add(plat);}}, serveur));
        table.setStatut("commandé");
    }

    public void servir(Table table) {
        for (Commande commande : commandes) {
            if (commande.getStatut().equals("non servie")) {
                boolean tousLesPlatsServis = true;
                for (Plat plat : commande.getPlats()) {
                    if (!table.getPlats().contains(plat)) {
                        tousLesPlatsServis = false;
                        break;
                    }
                }
                if (tousLesPlatsServis) {
                    commande.setStatut("servie");
                }
            }
        }
        table.setStatut("servi");
    }

    public void genererFacture(Table table) {
        ArrayList<Plat> platsCommandes = new ArrayList<Plat>();
        double montant = 0;
        Serveur serveur = null;
        for (Commande commande : commandes) {
            if (commande.getStatut().equals("servie")) {
                boolean commandeDeCetteTable = false;
                for (Client client : table.getClients()) {
                    if (commande.getServeur().equals(client)) {
                        commandeDeCetteTable = true;
                        break;
                    }
                }
                if (commandeDeCetteTable) {
                    for (Plat plat : commande.getPlats()) {
                        if (!platsCommandes.contains(plat)) {
                            platsCommandes.add(plat);
                            montant += plat.getPrix();
                        }
                    }
                    serveur = commande.getServeur();
                }
            }
        }
        factures.add(new Facture(platsCommandes, montant, serveur));
    }

    public void reglerFacture(Table table) {
        double montant = 0;
        for (Facture facture : factures) {
            boolean factureDeCetteTable = true;
            for (Plat plat : facture.getPlats()) {
                if (!table.getPlats().contains(plat)) {
                    factureDeCetteTable = false;
                    break;
                }
            }
            if (factureDeCetteTable) {
                montant = facture.getMontant();
                factures.remove(facture);
                break;
            }
        }
        // Ici on peut imaginer un code pour effectuer le paiement de la facture
        // Mais ce n'est pas inclu dans ce code
    }

    public void donnerPourboire(Serveur serveur, double montant) {
        serveur.setAnciennete(serveur.getAnciennete() + 1);
        // Ici on peut imaginer un code pour ajouter le pourboire au salaire du serveur
        // Mais ce n'est pas inclu dans ce code
    }

    public void afficherPersonnel()
    {
        for (Personnel p : personnel)
        {
            System.out.println(p.getRole() + " : " + p.getNom() + " " + p.getPrenom() + " (" + p.getSurnom() + "), " + p.getAnciennete() + " ans d'ancienneté");
        }
    }
    public void afficherTables() {
        for (Table table : tables) {
            System.out.println("Table " + (tables.indexOf(table) + 1) + " : " + table.getClients().size() + " clients / " + table.getCapaciteMax() + " places");
        }
    }

    public void afficherMenus() {
        for (Menu menu : menus) {
            System.out.println("Menu " + menu.getNom());
            for (Plat plat : menu.getPlats()) {
                System.out.println("- " + plat.getNom() + " : " + plat.getDescription() + " (" + plat.getPrix() + "€)");
            }
        }
        System.out.println("Plats hors menu :");
        for (Plat plat : platsHorsMenu) {
            System.out.println("- " + plat.getNom() + " : " + plat.getDescription() + " (" + plat.getPrix() + "€)");
        }
    }

    public void afficherStatutsTables() {
        for (Table table : tables) {
            System.out.println("Table " + (tables.indexOf(table) + 1) + " : " + table.getStatut());
        }
    }

    public void afficherRevenus() {
        double totalPourboires = 0;
        for (Personnel p : personnel) {
            if (p instanceof Serveur) {
                Serveur serveur = (Serveur) p;
                double pourboire = serveur.getAnciennete() * 0.1; // Exemple de calcul de pourboire
                System.out.println(serveur.getNom() + " " + serveur.getPrenom() + " a eu " + pourboire + "€ de pourboire");
                totalPourboires += pourboire;
            }
        }
        System.out.println("Total des pourboires : " + totalPourboires + "€");
    }
}
