package lt.psk.tools.useCases;

import lombok.Getter;
import lombok.Setter;
import lt.psk.tools.entities.Client;
import lt.psk.tools.entities.Shop;
import lt.psk.tools.persistence.ClientDAO;
import lt.psk.tools.persistence.ShopDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Clients {

    @Inject
    private ClientDAO clientDAO;

    @Inject
    private ShopDAO shopDAO;

    @Getter
    @Setter
    private Client clientToCreate = new Client();

    @Getter
    @Setter
    private Long shopToAssign;

    @Getter
    private List<Client> allClients;

    @PostConstruct
    public void init(){

        loadAllClients();
    }

    @Transactional
    public void createClients(){
        Shop shop = shopDAO.findOne(shopToAssign);
        if (shop != null) {
            clientToCreate.getShops().add(shop);
        }
        clientDAO.persist(clientToCreate);
    }

    @Transactional
    public void addClientToShop(){
        Shop shop = shopDAO.findOne(shopToAssign);
        if (shop != null) {
            clientToCreate.getShops().add(shop);
        }
        Client updateClient;
        if (clientToCreate.getId() != null) {
            updateClient = clientDAO.findOne(clientToCreate.getId());
            if (!updateClient.getShops().contains(shop))
            {
                updateClient.getShops().add(shop);
                clientDAO.update(updateClient);
            }
            return;
        }

        clientDAO.persist(clientToCreate);
    }

    private void loadAllClients(){

        this.allClients = clientDAO.loadAll();
    }

}
