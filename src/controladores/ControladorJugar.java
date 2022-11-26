/**
 *
 * @author Administrator
 */

package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.InterfazMenuJugar;
import controladores.ControladorMenuBienvenida;
import javax.swing.JOptionPane;
import juego.Juego;
import modelo.ListaUsuarios;
import vistas.InterfazPreguntaSeleccionMultiple;
import vistas.InterfazPreguntaSeleccionUnica;
import vistas.InterfazPreguntaTrueFalse;

public class ControladorJugar implements ActionListener {

    private InterfazMenuJugar vista;
    private int index;
    private ListaUsuarios lista;

    public ControladorJugar(InterfazMenuJugar vista) {
        lista = Juego.listaUsuarios;
        index = ControladorIniciar.index;
        this.vista = vista;
        vista.jugar.addActionListener(this);
        vista.volver.addActionListener(this);
        vista.niveles.addActionListener(this);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        System.out.println(e.getSource());
        
        if (e.getSource() == vista.jugar) {
            
            int opcion = vista.niveles.getSelectedIndex();
            
            switch(opcion){
                case 0 -> {
                    InterfazPreguntaTrueFalse interfaz = new InterfazPreguntaTrueFalse(ControladorMenuBienvenida.vista, true);
                    ControladorTrueFalse controlador = new ControladorTrueFalse(interfaz);
                }
                case 1 -> {
                    if(lista.getListaUsuarios()[index].getNiv1_correct() > 5){
                        InterfazPreguntaSeleccionUnica interfaz = new InterfazPreguntaSeleccionUnica(ControladorMenuBienvenida.vista, true);
                        ControladorSeleccionUnica controlador = new ControladorSeleccionUnica(interfaz);
                    } else{
                        JOptionPane.showMessageDialog(vista, "No ha contestado al menos 5 correctas del nivel 1");
                    }   
                }
                case 2 -> {
                    if(lista.getListaUsuarios()[index].getNiv2_correct() > 5){
                        InterfazPreguntaSeleccionMultiple interfaz = new InterfazPreguntaSeleccionMultiple(ControladorMenuBienvenida.vista, true);
                        ControladorSeleccionMultiple controlador = new ControladorSeleccionMultiple(interfaz);
                    } else{
                        JOptionPane.showMessageDialog(vista, "No ha contestado al menos 5 correctas del nivel 2");
                    }   
                }
            }
            
        }

        if (e.getSource() == vista.volver) {
            vista.dispose();
        }
    }
}