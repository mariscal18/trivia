package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import juego.Juego;
import modelo.ListaUsuarios;
import modelo.Usuario;
import vistas.InterfazMenuBienvenida;
import vistas.InterfazMenuIniciar;
import vistas.InterfazMenuInscribirse;

public class ControladorInscribirse implements ActionListener {

    private InterfazMenuInscribirse vista;
    private InterfazMenuBienvenida parent;
    private ListaUsuarios lista = Juego.listaUsuarios;
    private String user;
    private String password;

    public ControladorInscribirse(InterfazMenuInscribirse vista, InterfazMenuBienvenida parent) {
        this.vista = vista;
        this.parent = parent;
        this.vista.continuar.addActionListener(this);
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.continuar) {
            this.user = vista.user.getText();
            this.password = vista.password.getText();

            if (validarLength(user, 4, 8)) {
                if (validarLength(password, 3, 10)) {

                    if (validarUser(user)) {

                        try {
                            Usuario u = new Usuario(user, password);
                            lista.agregar(u);                           
                            Juego.escribirListaUsuarios();
                            vista.dispose();
                            InterfazMenuIniciar interfaz = new InterfazMenuIniciar(parent, true);
                            ControladorIniciar menu = new ControladorIniciar(interfaz,lista.getListaUsuarios().length-1);

                        } catch (IOException | ClassNotFoundException ex) {
                            Logger.getLogger(ControladorInscribirse.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(vista, "Este usuario ya se encuentra en uso");

                    }

                } else {
                    JOptionPane.showMessageDialog(vista, "La contraseña debe tener minimo 3 y como maximo 10 caracteres");
                }

            } else {
                JOptionPane.showMessageDialog(vista, "El usuario debe tener minimo 4 y como maximo 8 caracteres");

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

    public boolean validarUser(String user) {
        boolean temp = true;

        for (Usuario usuario : lista.getListaUsuarios()) {
            if (usuario.getUser().equals(user)) {
                temp = false;
                return temp;
            }
        }
        return temp;
    }

}
