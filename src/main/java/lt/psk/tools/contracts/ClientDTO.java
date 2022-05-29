package lt.psk.tools.contracts;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClientDTO {

    private Long id;
    private String name;
    private String occupation;
    private List<ShopDTO> shops;
}


