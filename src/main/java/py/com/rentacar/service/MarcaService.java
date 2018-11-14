package py.com.rentacar.service;

import com.google.gson.Gson;
import py.com.rentacar.controllers.MarcaController;
import py.com.rentacar.models.Vehiculo.Marca;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/marcas")
@Consumes(MediaType.APPLICATION_JSON)
public class MarcaService extends ResponseUtils {

    MarcaController controller = new MarcaController();

    @GET
    public String findAll() {
        List<Marca> marcaList;
        String json = null;
        try {
            marcaList = controller.getMarcas();
            json = new Gson().toJson(marcaList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }


    @GET
    @Path("/{id}")
    public String findById(@PathParam("id") String id) {
        Marca marca;
        String json = null;
        try {
            marca = controller.getMarcaById(id);
            json = new Gson().toJson(marca);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    @POST
    public Response create(Marca marca) {
        try {
            controller.createMarca(marca);
        } catch (Exception e) {
            e.printStackTrace();
            Response.serverError().build();
        }
        return Response.status(201).entity(STATUS201).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(Marca marca, @PathParam("id") String id) {
        try {
            controller.updateMarca(marca, id);
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
            controller.deleteMarca(id);
        } catch (Exception e) {
            e.printStackTrace();
            Response.status(500).entity(STATUS500).build();
        }

        return Response.status(202).entity(STATUS202).build();
    }
}