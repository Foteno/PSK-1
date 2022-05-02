package lt.psk.tools.useCases;

import lombok.Getter;
import lombok.Setter;
import lt.psk.tools.entities.Shop;
import lt.psk.tools.persistence.ShopDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Shops {

    @Inject
    private ShopDAO shopDAO;

    @Getter
    @Setter
    private Shop shopToCreate = new Shop();

    @Getter
    private List<Shop> allShops;

    @PostConstruct
    public void init(){

        loadAllShops();
    }

    @Transactional
    public void createShops(){
        this.shopDAO.persist(shopToCreate);
    }

    private void loadAllShops(){

        this.allShops = shopDAO.loadAll();
    }

}
