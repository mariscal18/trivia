/**
 *
 * @author Administrator
 */

package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.InterfazPreguntaTrueFalse;

public class ControladorTrueFalse implements ActionListener {

    private InterfazPreguntaTrueFalse vista;

    public ControladorTrueFalse(InterfazPreguntaTrueFalse vista) {
        this.vista = vista;
        vista.volver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.volver) {
            vista.dispose();
        }
    }
}