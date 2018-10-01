package py.com.rentacar.service;

import com.google.gson.Gson;
import py.com.rentacar.controllers.UserController;
import py.com.rentacar.models.Users;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

/**
 * @author mmartinez
 * @class UserService
 * En esta clase se recibiran las peticiones realizadas desde el Front-End
 * siempre teniendo en cuenta la ruta y el tipo de peticion realizada
 */
@Path("/api/users")
public class UserService {

    UserController controller = new UserController();

    @GET
    public String findAll() {
        List<Users> userList;
        String json = null;
        try {
            userList = controller.getUsers();
            json = new Gson().toJson(userList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }
}

