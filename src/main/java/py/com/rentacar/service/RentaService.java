package py.com.rentacar.service;

import py.com.rentacar.controllers.RentaController;
import py.com.rentacar.models.Operacion.Renta;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("api/rentas")
@Produces(MediaType.APPLICATION_JSON)
public class RentaService extends ResponseUtils {

    @Inject
    RentaController controller;

    @GET
    public Response findAll() {
        List<Renta> rentaList = null;
        try {
            rentaList = controller.getRentas();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.ok(rentaList).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") String id) {
        Renta renta = null;
        try {
            renta = controller.getRentasById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.ok(renta).build();
    }

    @POST
    public Response create(Renta renta) {
        try {
            controller.createRenta(renta);
        } catch (Exception e) {
            e.printStackTrace();
            Response.serverError().build();
        }

        return Response.status(201).entity(STATUS201).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") String id, Renta renta) {
        try {
            controller.updateRenta(renta, id);
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
            controller.deleteRenta(id);
        } catch (Exception e) {
            e.printStackTrace();
            Response.status(500).entity(STATUS500).build();
        }

        return Response.status(202).entity(STATUS202).build();
    }
}
