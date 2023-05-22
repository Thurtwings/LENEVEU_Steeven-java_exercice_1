package exo_1;

import java.util.ArrayList;
import java.util.List;

class Plat {
    private String nom;
    private String description;
    private double prix;

    public Plat(String nom, String description, double prix) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public double getPrix() {
        return prix;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}

class Menu {
    private String nom;
    private String description;
    private List<Plat> plats;

    public Menu(String nom, String description)
    {
        this.nom = nom;
        this.description = description;
        this.plats = new ArrayList<>();
    }

    public String getNom()
    {
        return nom;
    }

    public String getDescription()
    {
        return description;
    }

    public List<Plat> getPlats()
    {
        return plats;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void ajouterPlat(Plat plat)
    {
        plats.add(plat);
    }

    public void supprimerPlat(Plat plat)
    {
        plats.remove(plat);
    }

    public void modifierPlat(Plat plat, String nom, String description, double prix)
    {
        plat.setNom(nom);
        plat.setDescription(description);
        plat.setPrix(prix);
    }

    public void afficherPlats()
    {
        System.out.println("Plats du menu " + nom + " :");
        for (Plat plat : plats)
        {
            System.out.println("- " + plat.getNom() + " || " + plat.getDescription() + " || : " + plat.getPrix() + " euros");
        }
    }
}

class Client {
    private String nom;
    private String adresse;
    private String tel;

    public Client(String nom, String adresse, String tel) {
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }

    public void setTel(String tel)
    {
        this.tel = tel;
    }
}

class Commande
{
    private Client client;
    private List<Plat> plats;

    public Commande(Client client)
    {
        this.client = client;
        this.plats = new ArrayList<>();
    }

    public Client getClient()
    {
        return client;
    }

    public List<Plat> getPlats()
    {
        return plats;
    }

    public void ajouterPlat(Plat plat)
    {
        plats.add(plat);
    }

    public void afficherPlats()
    {
        System.out.println("Plats de " + client.getNom() + " :");
        for (Plat plat : plats)
        {
            System.out.println("• " + plat.getNom() + " || " + plat.getDescription() + " || : " + plat.getPrix() + " €");
        }
    }
}

class Restaurant
{
    private List<Menu> menus;
    private List<Client> clients;
    private List<Commande> commandes;

    public Restaurant() {
        this.menus = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.commandes = new ArrayList<>();
    }

    public List<Menu> getMenus()
    {
        return menus;
    }

    public List<Client> getClients()
    {
        return clients;
    }

    public List<Commande> getCommandes()
    {
        return commandes;
    }

    public void ajouterMenu(Menu menu)
    {
        menus.add(menu);
    }

    public void supprimerMenu(Menu menu)
    {
        menus.remove(menu);
    }

    public void modifierMenu(Menu menu, String nom, String description)
    {
        menu.setNom(nom);
        menu.setDescription(description);
    }

    public void afficherMenus()
    {
        System.out.println("Menus du restaurant :");
        for (Menu menu : menus)
        {
            System.out.println("- " + menu.getNom() + " (" + menu.getDescription() + ")");
        }
    }

    public void ajouterClient(Client client)
    {
        clients.add(client);
    }

    public void supprimerClient(Client client)
    {
        clients.remove(client);
    }

    public void modifierClient(Client client, String nom, String adresse, String numeroTelephone)
    {
        client.setNom(nom);
        client.setAdresse(adresse);
        client.setTel(numeroTelephone);
    }

    public void afficherClients()
    {
        System.out.println("Clients du restaurant :");
        for (Client client : clients)
        {
            System.out.println("- " + client.getNom() + " (" + client.getAdresse() + ", " + client.getTel() + ")");
        }
    }

    public void passerCommande(Client client, Menu menu, List<Plat> plats)
    {
        Commande commande = new Commande(client);
        for (Plat plat : plats)
        {
            commande.ajouterPlat(plat);
        }
        commandes.add(commande);
        System.out.println("exo_1.Commande passée pour " + client.getNom() + " :");
        commande.afficherPlats();
    }

    public void afficherCommandes(Client client)
    {
        System.out.println("Commandes pour " + client.getNom() + " :");
        for (Commande commande : commandes) {
            if (commande.getClient() == client) {
                commande.afficherPlats();
            }
        }
    }
}
