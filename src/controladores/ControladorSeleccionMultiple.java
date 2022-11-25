/**
 *
 * @author Administrator
 */

package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.InterfazPreguntaSeleccionMultiple;

public class ControladorSeleccionMultiple implements ActionListener {

    private InterfazPreguntaSeleccionMultiple vista;

    public ControladorSeleccionMultiple(InterfazPreguntaSeleccionMultiple vista) {
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