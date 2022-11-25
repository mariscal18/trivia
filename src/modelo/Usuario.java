package modelo;

import java.io.Serializable;

/**
 *
 * @author maris
 */
public class Usuario implements Serializable {

    private String user;
    private String password;

    public Usuario(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String id) {
        this.user = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "user=" + user + ", password=" + password + '}';
    }
    
    

}
