package py.com.rentacar.controllers;

import py.com.rentacar.dao.UserDAO;
import py.com.rentacar.models.Users;

import java.util.List;

public class UserController {

    UserDAO dao = new UserDAO();

    public List<Users> getUsers() {
        try {
            return dao.getUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(Users user) {
        try {
            dao.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
