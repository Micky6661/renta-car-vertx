package py.com.rentacar.dao;

import py.com.rentacar.models.Users;

import java.util.List;

public class UserDAO extends DbUtils<Users> {

    public static final String TABLE = "Users";

    public List<Users> getUsuarios() {
        List<Users> userList = null;
        try {
            userList = this.findAll(TABLE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }

    public Users getUserById(int id) {
        Users user = null;
        try {
            user = this.findById(Users.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public void deleteUser(int id) {
        try {
            this.delete(Users.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
