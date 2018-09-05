package py.com.rentacar.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Miguel Martinez
 **/
@Entity
@Table(name = "User")
public class User implements Serializable {
    @Id
    private Integer userId;

    private String username;

    private String password;

    private static final long serialVersionUID = -8672858398542565036L;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
