package lt.psk.tools.controller;

import lombok.Getter;
import lombok.Setter;
import lt.psk.tools.contracts.ClientDTO;
import lt.psk.tools.contracts.ShopDTO;
import lt.psk.tools.entities.Client;
import lt.psk.tools.entities.Shop;
import lt.psk.tools.persistence.ClientDAO;
import lt.psk.tools.persistence.ShopDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("/clients")
public class ClientController {

    @Inject
    @Getter
    @Setter
    private ClientDAO clientDAO;

    @Inject
    @Getter
    @Setter
    private ShopDAO shopDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientById(@PathParam("id") final Long id) {
        Client client = clientDAO.findOne(id);
        if (client == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setName(client.getOccupation());

        List<ShopDTO> shopDTOs = new ArrayList<>();

        for (Shop shop : client.getShops()) {
            ShopDTO shopDTO = new ShopDTO();
            shopDTO.setId(shop.getId());
            shopDTO.setAddress(shop.getAddress());
            shopDTO.setCity(shop.getCity());

            shopDTOs.add(shopDTO);
        }
        clientDTO.setShops(shopDTOs);

        return Response.ok(clientDTO).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateClient(@PathParam("id") final Long clientId, ClientDTO clientDTO) {
        try {
            Client client = clientDAO.findOne(clientId);
            if (client == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            client.setName(clientDTO.getName());
            client.setOccupation(clientDTO.getOccupation());
            List<Shop> shops = new ArrayList<>();
            List<Shop> clientShops = client.getShops();

            for (ShopDTO shopDTO : clientDTO.getShops()) {
                Shop shop = shopDAO.findOne(shopDTO.getId());
                if (shop == null) {
                    shop = new Shop();
                    shop.setCity(shopDTO.getCity());
                    shop.setAddress(shopDTO.getAddress());
                    shops.add(shop);
                }

                if (clientShops.contains(shop)) {
                    shops.add(shop);
                }
            }
            client.setShops(shops);
            clientDAO.update(client);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setOccupation(clientDTO.getOccupation());

        List<Shop> shops = new ArrayList<>();

        for (ShopDTO shopDTO : clientDTO.getShops()) {
            Shop shop = shopDAO.findOne(shopDTO.getId());
            if (shop != null){
                shops.add(shop);
            }
        }
        client.setShops(shops);
        clientDAO.update(client);

        return Response.status(201).entity(clientDTO).build();
    }
}
