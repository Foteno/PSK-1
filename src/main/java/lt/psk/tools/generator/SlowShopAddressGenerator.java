package lt.psk.tools.generator;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;

@ApplicationScoped
@Specializes
public class SlowShopAddressGenerator extends ShopAddressGenerator {

    public String generateAddress(String address) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {
        }
        return address + " 159";
    }
}
