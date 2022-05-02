package lt.psk.tools.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CLIENT")
@NamedQueries({
        @NamedQuery(name = "Client.findAll", query = "select a from Client as a")
})
@Getter
@Setter
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String occupation;

    @ManyToMany(mappedBy = "clients")
    private List<Shop> shops;
}
