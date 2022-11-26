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

    public int getNiv1_correct() {
        return niv1_correct;
    }

    public void setNiv1_correct(int niv1_correct) {
        this.niv1_correct = niv1_correct;
    }

    public int getNiv1_incorrect() {
        return niv1_incorrect;
    }

    public void setNiv1_incorrect(int niv1_incorrect) {
        this.niv1_incorrect = niv1_incorrect;
    }

    public int getNiv2_correct() {
        return niv2_correct;
    }

    public void setNiv2_correct(int niv2_correct) {
        this.niv2_correct = niv2_correct;
    }

    public int getNiv2_incorrect() {
        return niv2_incorrect;
    }

    public void setNiv2_incorrect(int niv2_incorrect) {
        this.niv2_incorrect = niv2_incorrect;
    }

    public int getNiv3_correct() {
        return niv3_correct;
    }

    public void setNiv3_correct(int niv3_correct) {
        this.niv3_correct = niv3_correct;
    }

    public int getNiv3_incorrect() {
        return niv3_incorrect;
    }

    public void setNiv3_incorrect(int niv3_incorrect) {
        this.niv3_incorrect = niv3_incorrect;
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
