package lt.psk.tools.useCases;

import lombok.Getter;
import lombok.Setter;
import lt.psk.tools.entities.Shop;
import lt.psk.tools.entities.Tool;
import lt.psk.tools.persistence.ToolDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
public class Tools {

    @Inject
    private ToolDAO toolDAO;

    @Getter
    @Setter
    private Tool toolToCreate = new Tool();

    @PostConstruct
    public void init(){

        toolToCreate.setShops(new Shop());
    }

    @Transactional
    public void createTools(){

        this.toolDAO.persist(toolToCreate);
    }
}
