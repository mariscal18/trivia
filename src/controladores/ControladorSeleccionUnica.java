/**
 *
 * @author Administrator
 */

package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.InterfazPreguntaSeleccionUnica;

public class ControladorSeleccionUnica implements ActionListener {

    private InterfazPreguntaSeleccionUnica vista;

    public ControladorSeleccionUnica(InterfazPreguntaSeleccionUnica vista) {
        this.vista = vista;
        vista.volver.addActionListener(this);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.volver) {
            vista.dispose();
        }
    }
}