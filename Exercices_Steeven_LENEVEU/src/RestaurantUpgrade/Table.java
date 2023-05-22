package RestaurantUpgrade;


import java.util.*;

public class Table
{
    private int capaciteMax;
    private ArrayList<Client> clients;
    private ArrayList<Plat> plats;
    private Menu menu;
    private String statut; // non commandé, commandé, servi, payé

    public Table(int capaciteMax) {
        this.capaciteMax = capaciteMax;
        clients = new ArrayList<Client>();
        plats = new ArrayList<Plat>();
        statut = "non commandé";
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public ArrayList<Plat> getPlats() {
        return plats;
    }

    public void addPlat(Plat plat) {
        plats.add(plat);
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public boolean estPleine() {
        return clients.size() == capaciteMax;
    }


}

