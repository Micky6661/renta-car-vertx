package py.com.rentacar.service;

import com.google.gson.Gson;
import py.com.rentacar.controllers.ModeloController;
import py.com.rentacar.models.Vehiculo.Modelo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/modelos")
@Consumes(MediaType.APPLICATION_JSON)
public class ModeloService extends ResponseUtils {

    ModeloController controller = new ModeloController();

    @GET
    public String findAll() {
        List<Modelo> modeloList;
        String json = null;
        try {
        	modeloList = controller.getModelos();
            json = new Gson().toJson(modeloList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }


    @GET
    @Path("/{id}")
    public String findById(@PathParam("id") String id) {
        Modelo modelo;
        String json = null;
        try {
            modelo = controller.getModeloById(id);
            json = new Gson().toJson(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    @POST
    public Response create(Modelo modelo) {
        try {
            controller.createModelo(modelo);
        } catch (Exception e) {
            e.printStackTrace();
            Response.serverError().build();
        }
        return Response.status(201).entity(STATUS201).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(Modelo modelo, @PathParam("id") String id) {
        try {
            controller.updateModelo(modelo, id);
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
            controller.deleteModelo(id);
        } catch (Exception e) {
            e.printStackTrace();
            Response.status(500).entity(STATUS500).build();
        }

        return Response.status(202).entity(STATUS202).build();
    }
}