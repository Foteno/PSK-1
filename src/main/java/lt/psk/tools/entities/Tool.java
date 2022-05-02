package lt.psk.tools.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TOOL")
@NamedQueries({
        @NamedQuery(name = "Tool.findAll", query = "select a from Tool as a")
})
@Getter
@Setter
public class Tool {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String brand;

    @Column(name = "TOOL_NAME")
    private String toolName;

    @Column
    private String category;

    @ManyToOne
    private Shop shops;

}
