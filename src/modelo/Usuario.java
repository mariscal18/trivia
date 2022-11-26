package modelo;

import java.io.Serializable;

/**
 *
 * @author maris
 */
public class Usuario implements Serializable {

    private String user;
    private String password;
    private int niv1_correct;
    private int niv1_incorrect;
    private int niv2_correct;
    private int niv2_incorrect;
    private int niv3_correct;
    private int niv3_incorrect;

    public Usuario(String user, String password) {
        this.user = user;
        this.password = password;
        niv1_correct = 0;
        niv1_incorrect = 0;
        niv2_correct = 0;
        niv2_incorrect = 0;
        niv3_correct = 0;
        niv3_incorrect = 0;
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
    
    public String printStats(){
        String string = "VERDADERO/FALSO = " + niv1_correct + " correctas, " + niv1_incorrect + " incorrectas.";
        string += "\n\nSEL. ÚNICA = " + niv2_correct + " correctas, " + niv2_incorrect + " incorrectas.";
        string += "\n\nSEL. MÚLTIPLE = " + niv3_correct + " correctas, " + niv3_incorrect + " incorrectas.";
        
        return string;
    }

    @Override
    public String toString() {
        return "Usuario{" + "user=" + user + ", password=" + password + '}';
    }
    
}
