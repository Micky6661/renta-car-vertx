package py.com.rentacar.service;

import com.google.gson.Gson;
import py.com.rentacar.controllers.UserController;
import py.com.rentacar.models.Users;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Servicio REST para la Users
 *
 * @Api /api/usuarios
 * @ResponseUtils - extends - utilizado para el manejo de las respuestas
 */

@Path("/api/users")
@Consumes(MediaType.APPLICATION_JSON)
public class UserService extends ResponseUtils {

    UserController controller = new UserController();

    @GET
    public String findAll() {
        List<Users> usersList;
        String json = null;
        try {
            usersList = controller.getUsers();
            json = new Gson().toJson(usersList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    @GET
    @Path("/username/{name}")
    public String findByUsername(@PathParam("name") String username) {
        Users user;
        String json = null;
        try {
            user = controller.getUserByName(username);
            json = new Gson().toJson(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    @GET
    @Path("/{id}")
    public String findById(@PathParam("id") String id) {
        Users user;
        String json = null;
        try {
            user = controller.getUserById(id);
            json = new Gson().toJson(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    @POST
    public Response create(Users user) {
        try {
            controller.createUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            Response.serverError().build();
        }

        return Response.status(201).entity(STATUS201).build();
    }

    @PUT
    public Response update(Users user, String id) {
        try {
            controller.updateUser(user, id);
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
            controller.deleteUser(id);
        } catch (Exception e) {
            e.printStackTrace();
            Response.status(500).entity(STATUS500).build();
        }

        return Response.status(202).entity(STATUS202).build();
    }
}

