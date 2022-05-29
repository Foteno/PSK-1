package lt.psk.tools.contracts;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShopDTO {

    private Long id;
    private String address;
    private String city;
    private List<ClientDTO> clients;
}
