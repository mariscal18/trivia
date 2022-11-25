/**
 *
 * @author Administrator
 */

package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.InterfazMenuEstadisticas;

public class ControladorEstadisticas implements ActionListener {

    private InterfazMenuEstadisticas vista;

    public ControladorEstadisticas(InterfazMenuEstadisticas vista) {
        this.vista = vista;
        vista.volver.addActionListener(this);
        //vista.area.setText(listaUsuarios[index].printStats());
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.volver) {
            vista.dispose();
        }
    }
}