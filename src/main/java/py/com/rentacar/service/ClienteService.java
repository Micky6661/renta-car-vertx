package py.com.rentacar.service;

import com.google.gson.Gson;
import py.com.rentacar.controllers.ClienteController;
import py.com.rentacar.models.Cliente.Cliente;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/clientes")
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteService extends ResponseUtils {

    ClienteController controller = new ClienteController();

    @GET
    public String findAll() {
        List<Cliente> clienteList;
        String json = null;
        try {
            clienteList = controller.getClientes();
            json = new Gson().toJson(clienteList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }


    @GET
    @Path("/{id}")
    public String findById(@PathParam("id") String id) {
        Cliente cliente;
        String json = null;
        try {
            cliente = controller.getClienteById(id);
            json = new Gson().toJson(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    @POST
    public Response create(Cliente cliente) {
        try {
            controller.createCliente(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            Response.serverError().build();
        }

        return Response.status(201).entity(STATUS201).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(Cliente cliente, @PathParam("id") String id) {
        try {
            controller.updateCliente(cliente, id);
        } catch (Exception e) {
            e.printStackTrace();
            Response.status(500).entity(STATUS500).build();
        }

        return Response.status(202).entity(STATUS201).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        try {
            controller.deleteCliente(id);
        } catch (Exception e) {
            e.printStackTrace();
            Response.status(500).entity(STATUS500).build();
        }

        return Response.status(202).entity(STATUS202).build();
    }
}