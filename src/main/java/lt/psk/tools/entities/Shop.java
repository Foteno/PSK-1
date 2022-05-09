package lt.psk.tools.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SHOP")
@NamedQueries({
        @NamedQuery(name = "Shop.findAll", query = "select a from Shop as a")
})
@Getter
@Setter
public class Shop {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "ADDRESS")
    private String address;

    @Column
    private String city;

    @OneToMany(mappedBy = "shops")
    private List<Tool> tools;

    @ManyToMany(mappedBy = "shops")
    private List<Client> clients = new ArrayList<>();

}
