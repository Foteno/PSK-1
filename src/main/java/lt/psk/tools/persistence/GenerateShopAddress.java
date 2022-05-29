package lt.psk.tools.persistence;

import lt.psk.tools.generator.AddressGenerator;
import lt.psk.tools.interceptors.LoggedInvocation;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateShopAddress implements Serializable {

    @Inject
    private AddressGenerator addressGenerator;

    private CompletableFuture<String> addressGenerationTask = null;

    @LoggedInvocation
    public String generateNewAddress(String address) {
        addressGenerationTask = CompletableFuture.supplyAsync(() -> addressGenerator.generateAddress(address));
        return  "/index.xhtml?faces-redirect=true";
    }

    public boolean isAddressGenerationRunning() {
        return addressGenerationTask != null && !addressGenerationTask.isDone();
    }

    public String getAddressGenerationStatus() throws ExecutionException, InterruptedException {
        if (addressGenerationTask == null) {
            return null;
        } else if (isAddressGenerationRunning()) {
            return "Address generation in progress";
        }
        return "Suggested address: " + addressGenerationTask.get();
    }
}
