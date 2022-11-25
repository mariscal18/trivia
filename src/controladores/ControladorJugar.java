/**
 *
 * @author Administrator
 */

package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.InterfazMenuJugar;
import controladores.ControladorMenuBienvenida;
import vistas.InterfazPreguntaSeleccionMultiple;
import vistas.InterfazPreguntaSeleccionUnica;
import vistas.InterfazPreguntaTrueFalse;

public class ControladorJugar implements ActionListener {

    private InterfazMenuJugar vista;

    public ControladorJugar(InterfazMenuJugar vista) {
        this.vista = vista;
        vista.volver.addActionListener(this);
        vista.niveles.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.jugar) {
            
            int opcion = vista.niveles.getSelectedIndex();
            
            switch(opcion){
                case 0 -> {
                    InterfazPreguntaTrueFalse interfaz = new InterfazPreguntaTrueFalse(ControladorMenuBienvenida.vista, true);
                    ControladorTrueFalse controlador = new ControladorTrueFalse(interfaz);
                }
                case 1 -> {
                    InterfazPreguntaSeleccionUnica interfaz = new InterfazPreguntaSeleccionUnica(ControladorMenuBienvenida.vista, true);
                    ControladorSeleccionUnica controlador = new ControladorSeleccionUnica(interfaz);
                }
                case 2 -> {
                    InterfazPreguntaSeleccionMultiple interfaz = new InterfazPreguntaSeleccionMultiple(ControladorMenuBienvenida.vista, true);
                    ControladorSeleccionMultiple controlador = new ControladorSeleccionMultiple(interfaz);
                }
            }
            
        }

        if (e.getSource() == vista.volver) {
            vista.dispose();
        }
    }
}