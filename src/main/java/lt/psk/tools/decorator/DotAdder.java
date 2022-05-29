package lt.psk.tools.decorator;

import lt.psk.tools.generator.AddressGenerator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class DotAdder implements AddressGenerator {

    @Inject @Delegate @Any AddressGenerator addressGenerator;

    public String generateAddress(String address) {
        String newAddress = addressGenerator.generateAddress(address);
        int gIndex = newAddress.indexOf(" g ");
        if (gIndex == -1) {
            return newAddress;
        }
        return newAddress.substring(0, gIndex + 2) + '.' + newAddress.substring(gIndex + 2);
    }
}
