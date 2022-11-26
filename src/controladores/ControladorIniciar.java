/**
 *
 * @author Administrator
 */

package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.InterfazMenuIniciar;
import vistas.InterfazMenuJugar;
import controladores.ControladorMenuBienvenida;
import vistas.InterfazMenuEstadisticas;

public class ControladorIniciar implements ActionListener {

    private InterfazMenuIniciar vista;
    public static int index;
    
    public ControladorIniciar(InterfazMenuIniciar vista) {
        this.index = 0;
        this.vista = vista;
        vista.jugar.addActionListener(this);
        vista.estadisticas.addActionListener(this);
        vista.volver.addActionListener(this);
        vista.setVisible(true);
    }

    public ControladorIniciar(InterfazMenuIniciar vista, int index) {
        this.index = index;
        this.vista = vista;
        vista.jugar.addActionListener(this);
        vista.estadisticas.addActionListener(this);
        vista.volver.addActionListener(this);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.jugar) {
            InterfazMenuJugar interfaz = new InterfazMenuJugar(ControladorMenuBienvenida.vista, true);
            ControladorJugar controlador = new ControladorJugar(interfaz);
        }
        if (e.getSource() == vista.estadisticas) {
            InterfazMenuEstadisticas interfaz = new InterfazMenuEstadisticas(ControladorMenuBienvenida.vista, true);
            ControladorEstadisticas controlador = new ControladorEstadisticas(interfaz);
        }
        if (e.getSource() == vista.volver) {
            vista.dispose();
        }
    }
}