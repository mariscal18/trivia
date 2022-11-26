/**
 *
 * @author Administrator
 */

package controladores;

import estructuras.ListaPreguntas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import juego.Juego;
import modelo.ListaUsuarios;
import modelo.Pregunta;
import modelo.PreguntaVerdaderoFalso;
import vistas.InterfazPreguntaTrueFalse;

public class ControladorTrueFalse implements ActionListener {

    private InterfazPreguntaTrueFalse vista;
    private ListaUsuarios listaUs = Juego.listaUsuarios;
    private ListaPreguntas lista = Juego.lista1;
    private int questionIndex;
    private int userIndex = ControladorIniciar.index;
    private int listSize;
    private PreguntaVerdaderoFalso actual;

    public ControladorTrueFalse(InterfazPreguntaTrueFalse vista) {
        this.vista = vista;
        vista.volver.addActionListener(this);
        vista.v.addActionListener(this);
        vista.f.addActionListener(this);
        vista.setVisible(true);
        genNum();
        actual = (PreguntaVerdaderoFalso) lista.getListaPreguntas()[questionIndex];
        vista.texto.setText(actual.getTexto());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.v){
            if(actual.getRespuesta() == true){
                listaUs.getListaUsuarios()[userIndex].setNiv1_correct(listaUs.
                        getListaUsuarios()[userIndex].getNiv1_correct()+1);
                JOptionPane.showMessageDialog(vista, "RESPUESTA CORRECTA");
            }else{
                listaUs.getListaUsuarios()[userIndex].setNiv1_incorrect(listaUs.
                        getListaUsuarios()[userIndex].getNiv1_incorrect()+1);
                JOptionPane.showMessageDialog(vista, "RESPUESTA INCORRECTA");
            }
            genNum();
            actual = (PreguntaVerdaderoFalso) lista.getListaPreguntas()[questionIndex];
            vista.texto.setText(actual.getTexto());
            
        }
        
        if (e.getSource() == vista.f){
            if(actual.getRespuesta() == false){
                listaUs.getListaUsuarios()[userIndex].setNiv1_correct(listaUs.
                        getListaUsuarios()[userIndex].getNiv1_correct()+1);
                JOptionPane.showMessageDialog(vista, "RESPUESTA CORRECTA");
            }else{
                listaUs.getListaUsuarios()[userIndex].setNiv1_incorrect(listaUs.
                        getListaUsuarios()[userIndex].getNiv1_incorrect()+1);
                JOptionPane.showMessageDialog(vista, "RESPUESTA INCORRECTA");
            }
            genNum();
            actual = (PreguntaVerdaderoFalso) lista.getListaPreguntas()[questionIndex];
            vista.texto.setText(actual.getTexto());
            
        }

        if (e.getSource() == vista.volver) {
            vista.dispose();
        }
    }
    
    public void genNum(){
        this.questionIndex = (int) (Math.random() * (lista.getListaPreguntas().length));
    }
}