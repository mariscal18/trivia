/**
 *
 * @author Administrator
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.InterfazMenuBienvenida;
import vistas.InterfazMenuIngresar;
import vistas.InterfazMenuIniciar;
import vistas.InterfazMenuInscribirse;

public class ControladorMenuBienvenida implements ActionListener {

    public static InterfazMenuBienvenida vista;

    public ControladorMenuBienvenida(InterfazMenuBienvenida vista) {
        this.vista = vista;
        vista.inscribirse.addActionListener(this);
        vista.ingresar.addActionListener(this);
        vista.salir.addActionListener(this);
        this.vista.setLocationRelativeTo(null);
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.inscribirse) {
            InterfazMenuInscribirse interfaz = new InterfazMenuInscribirse(vista, true);
            ControladorInscribirse controlador = new ControladorInscribirse(interfaz, vista);
        }
        if (e.getSource() == vista.ingresar) {
            InterfazMenuIngresar interfaz = new InterfazMenuIngresar(vista, true);
            ControladorIngresar controlador = new ControladorIngresar(interfaz, vista);
        }
        if (e.getSource() == vista.salir) {
            vista.dispose();
            System.exit(0);
        }
    }
}
