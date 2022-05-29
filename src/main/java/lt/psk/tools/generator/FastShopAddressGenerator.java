package lt.psk.tools.generator;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@Alternative
@ApplicationScoped
public class FastShopAddressGenerator implements AddressGenerator {

    public String generateAddress(String address) {
        return address + " 9";
    }
}
