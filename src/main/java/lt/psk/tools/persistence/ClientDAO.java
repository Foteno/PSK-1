package lt.psk.tools.persistence;

import lt.psk.tools.entities.Client;
import lt.psk.tools.entities.Shop;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ClientDAO {

    @Inject
    private EntityManager em;

    public List<Client> loadAll() {
        return em.createNamedQuery("Client.findAll", Client.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Client client){
        this.em.persist(client);
    }

    public void update(Client client){
        this.em.merge(client);
    }

    public Client findOne(Long id) {
        return em.find(Client.class, id);
    }
}
