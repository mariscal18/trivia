/**
 *
 * @author Jorge Zúñiga C08740 y Keiron Garro
 */

package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import juego.Juego;
import vistas.InterfazMenuEstadisticas;
import modelo.ListaUsuarios;

public class ControladorEstadisticas implements ActionListener {

    private ListaUsuarios lista = Juego.listaUsuarios; 
    private int index = ControladorIniciar.index;
    private InterfazMenuEstadisticas vista;

    public ControladorEstadisticas(InterfazMenuEstadisticas vista) {
        this.vista = vista;
        vista.volver.addActionListener(this);
        vista.jTextField1.setText("Estadísticas de " + lista.getListaUsuarios()[index].getUser());
        vista.area.setText(lista.getListaUsuarios()[index].printStats());
        this.vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.volver) {
            vista.dispose();
        }
    }
}