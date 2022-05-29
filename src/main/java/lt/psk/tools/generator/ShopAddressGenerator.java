package lt.psk.tools.generator;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ShopAddressGenerator implements AddressGenerator {

    public String generateAddress(String address) {
        return address + "123";
    }

}
