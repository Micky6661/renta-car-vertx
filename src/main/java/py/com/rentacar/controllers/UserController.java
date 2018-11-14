package py.com.rentacar.controllers;

import py.com.rentacar.dao.UserDAO;
import py.com.rentacar.models.Users;

import javax.inject.Inject;
import java.util.List;

public class UserController {

    @Inject
    UserDAO dao;

    public List<Users> getUsers() {
        try {
            return dao.getUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Users getUserById(String id) {
        Users user = null;
        try {
            user = dao.getUserById(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public Users getUserByName(String username) {
        List<Users> usersListAux = null;
        Users user = null;
        try {
            usersListAux = dao.getByAtribute(Users.class, "Users", username, "username");
            user = usersListAux.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void createUser(Users user) {
        try {
            dao.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(Users user, String id) {
        try {
            dao.update(user, Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String id) {
        try {
            dao.deleteUser(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
