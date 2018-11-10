package py.com.rentacar.service;

import com.google.gson.Gson;
import py.com.rentacar.controllers.MarcaController;
import py.com.rentacar.controllers.ModeloController;
import py.com.rentacar.controllers.VehiculoController;
import py.com.rentacar.models.Vehiculo.Marca;
import py.com.rentacar.models.Vehiculo.Modelo;
import py.com.rentacar.models.Vehiculo.Vehiculo;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author Miguel Martinez
 **/
@Path("/api/vehiculos")
//@Consumes(MediaType.APPLICATION_JSON)
public class VehiculoService extends ResponseUtils {

    VehiculoController controller = new VehiculoController();

    MarcaController marcaController = new MarcaController();

    ModeloController modeloController = new ModeloController();

    @GET
    public String findAll() {
        List<Vehiculo> vehiculoList;
        String json = null;
        try {
            vehiculoList = controller.getVehiculos();
            json = new Gson().toJson(vehiculoList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    @GET
    @Path("/{id}")
    public String findById(@PathParam("id") String id) {
        Vehiculo vehiculo;
        String json = null;
        try {
            vehiculo = controller.getVehiculoById(id);
            json = new Gson().toJson(vehiculo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    @GET
    @Path("/marcas")
    public String findMarcas() {
        List<Marca> listaModelos = null;
        String json = null;
        try {
            listaModelos = marcaController.findAll();
            json = new Gson().toJson(listaModelos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    @GET
    @Path("/modelos")
    public String findModelos() {
        List<Modelo> listaModelos = null;
        String json = null;
        try {
            listaModelos = modeloController.findAll();
            json = new Gson().toJson(listaModelos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    @GET
    @Path("/validar/{matricula}/{chasis}")
    public String validarVehiculo(
            @PathParam("matricula") String matricula,
            @PathParam("chasis") String chasis) {
        Vehiculo vehiculoA;
        Vehiculo vehiculoB;
        try {
            vehiculoA = controller.getVehiculoByMatricula(matricula);
            vehiculoB = controller.getVehiculoByChasis(chasis);
            if (vehiculoA != null) {
                return new Gson().toJson(vehiculoA);
            }
            if (vehiculoB != null) {
                return new Gson().toJson(vehiculoB);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @POST
    public Response create(Vehiculo vehiculo) {
        try {
            controller.createVehiculo(vehiculo);
        } catch (Exception e) {
            e.printStackTrace();
            Response.serverError().build();
        }

        return Response.status(201).entity(STATUS201).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") String id, Vehiculo vehiculo) {
        try {
            controller.updateVehiculo(vehiculo, id);
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
            controller.deleteVehiculo(id);
        } catch (Exception e) {
            e.printStackTrace();
            Response.status(500).entity(STATUS500).build();
        }

        return Response.status(202).entity(STATUS202).build();
    }
}
