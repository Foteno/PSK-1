package lt.psk.tools.persistence;

import lombok.Getter;
import lombok.Setter;
import lt.psk.tools.entities.Client;
import lt.psk.tools.entities.Shop;
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
public class UpdateShopDetails implements Serializable {

    @Getter
    private List<Shop> allShops;

    @Inject
    private ShopDAO shopDAO;

    @Getter
    @Setter
    private Shop shopToUpdate = new Shop();

    @PostConstruct
    public void init(){
        loadAllShops();
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    @LoggedInvocation
    public String updateShopAddress() {
        Shop shop = allShops.stream().filter(c -> c.getId().equals(shopToUpdate.getId())).collect(Collectors.toList()).get(0);
        shop.setAddress(shopToUpdate.getAddress());
        try {
            shopDAO.update(shop);
        } catch (OptimisticLockException e) {
            return "/index.xhtml?faces-redirect=true&error=optimistic-lock-exception";
        }
        return "/index?faces-redirect=true";
    }

    private void loadAllShops(){
        this.allShops = shopDAO.loadAll();
    }
}
