package lt.psk.tools.persistence;

import lombok.Getter;
import lombok.Setter;
import lt.psk.tools.entities.Client;
import lt.psk.tools.interceptors.LoggedInvocation;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ViewScoped
@Named
public class UpdateClientDetails implements Serializable {

    @Getter
    private List<Client> allClients;

    @Inject
    private ClientDAO clientDAO;

    @Getter
    @Setter
    private Client clientToUpdate = new Client();

    @PostConstruct
    public void init(){
        loadAllClients();
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    @LoggedInvocation
    public String updateClientName() {
        Client client = allClients.stream().filter(c -> c.getId().equals(clientToUpdate.getId())).collect(Collectors.toList()).get(0);
        client.setName(clientToUpdate.getName());
        try {
            clientDAO.update(client);
        } catch (OptimisticLockException e) {
            return "/index.xhtml?faces-redirect=true&error=optimistic-lock-exception";
        }
        return "/index?faces-redirect=true";
    }

    private void loadAllClients(){
        this.allClients = clientDAO.loadAll();
    }
}
