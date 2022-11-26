package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import juego.Juego;
import modelo.ListaUsuarios;
import vistas.InterfazMenuBienvenida;
import vistas.InterfazMenuIngresar;
import vistas.InterfazMenuIniciar;

public class ControladorIngresar implements ActionListener {

    private InterfazMenuIngresar vista;
    private InterfazMenuBienvenida parent;
    private ListaUsuarios lista = Juego.listaUsuarios;
    private String user;
    private String password;

    public ControladorIngresar(InterfazMenuIngresar vista, InterfazMenuBienvenida parent) {
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


            if (validarIngreso(user, password)) {

                vista.dispose();
                InterfazMenuIniciar interfaz = new InterfazMenuIniciar(parent, true);
                ControladorIniciar menu = new ControladorIniciar(interfaz, lista.getListaUsuarios().length - 1);

            } else {
                JOptionPane.showMessageDialog(vista, "Usuario o Contraseña incorrectos");

            }

        }
    }

    public boolean validarIngreso(String user, String password) {
        boolean temp = false;

        for (int i = 0; i < lista.getListaUsuarios().length; i++) {
            if (lista.getListaUsuarios()[i].getUser().equals(user) && lista.getListaUsuarios()[i].getPassword().equals(password)) {
                temp = true;
                return temp;
            }
        }
        return temp;
    }

}
