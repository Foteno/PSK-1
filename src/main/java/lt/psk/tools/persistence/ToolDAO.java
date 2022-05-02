package lt.psk.tools.persistence;

import lt.psk.tools.entities.Tool;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class ToolDAO {

    @Inject
    private EntityManager em;

    public void persist(Tool tool){
        this.em.persist(tool);
    }

    public Tool findOne(Integer id){
        return em.find(Tool.class, id);
    }

    public Tool update(Tool tool){
        return em.merge(tool);
    }
}
