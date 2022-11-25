package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import juego.Juego;
import modelo.ListaUsuarios;
import modelo.Usuario;
import vistas.InterfazMenuInscribirse;

public class ControladorInscribirse implements ActionListener {

    private InterfazMenuInscribirse vista;
    private ListaUsuarios lista = Juego.listaUsuarios;
    private String user;
    private String password;

    public ControladorInscribirse(InterfazMenuInscribirse vista) {
        this.vista = vista;
        this.vista.continuar.addActionListener(this);
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.continuar) {
            this.user = vista.user.getText();
            this.password = vista.password.getText();
            if (validarLength(user, 4, 8) && validarLength(password, 3, 10)) {
                try {
                    lista.agregar(new Usuario(user, password));
                    Juego.escribirLista();
                    //DISPOSE
                    //CONTROLADOR INICIAR ()
                    System.out.println(lista.getListaUsuarios().length);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(ControladorInscribirse.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public boolean validarLength(String texto, int min, int max) {
        boolean temp = false;
        if (texto.length() >= min && texto.length() <= max) {
            temp = true;
        }
        return temp;
    }

}
