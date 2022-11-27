/**
 *
 * @author Administrator
 */
package controladores;

import estructuras.ListaPreguntas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        genNum();
        actual = (PreguntaVerdaderoFalso) lista.getListaPreguntas()[questionIndex];
        validarPregunta(actual);
        this.vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.v) {
            if (actual.getRespuesta() == true) {
                listaUs.getListaUsuarios()[userIndex].setNiv1_correct(listaUs.
                        getListaUsuarios()[userIndex].getNiv1_correct() + 1);
                JOptionPane.showMessageDialog(vista, "RESPUESTA CORRECTA");
            } else {
                listaUs.getListaUsuarios()[userIndex].setNiv1_incorrect(listaUs.
                        getListaUsuarios()[userIndex].getNiv1_incorrect() + 1);
                JOptionPane.showMessageDialog(vista, "RESPUESTA INCORRECTA");
            }
            try {
                Juego.escribirListaUsuarios();
            } catch (IOException ex) {
                Logger.getLogger(ControladorTrueFalse.class.getName()).log(Level.SEVERE, null, ex);
            }

            lista.eliminarPregunta(questionIndex);
            System.out.println(actual);
            validarPregunta(actual);
            System.out.println(actual);

        }

        if (e.getSource() == vista.f) {
            if (actual.getRespuesta() == false) {
                listaUs.getListaUsuarios()[userIndex].setNiv1_correct(listaUs.
                        getListaUsuarios()[userIndex].getNiv1_correct() + 1);
                JOptionPane.showMessageDialog(vista, "RESPUESTA CORRECTA");
            } else {
                listaUs.getListaUsuarios()[userIndex].setNiv1_incorrect(listaUs.
                        getListaUsuarios()[userIndex].getNiv1_incorrect() + 1);
                JOptionPane.showMessageDialog(vista, "RESPUESTA INCORRECTA");
            }
            try {
                Juego.escribirListaUsuarios();
            } catch (IOException ex) {
                Logger.getLogger(ControladorTrueFalse.class.getName()).log(Level.SEVERE, null, ex);
            }
            lista.getListaPreguntas()[questionIndex] = null;
            validarPregunta(actual);
        }

        if (e.getSource() == vista.volver) {
            vista.dispose();
        }
    }

    public void genNum() {
        this.questionIndex = (int) (Math.random() * (lista.getListaPreguntas().length));
    }

    public void validarPregunta(PreguntaVerdaderoFalso actual) {
        for (int i = 0; i < lista.getListaPreguntas().length; i++) {
            if (actual != null) {
                vista.texto.setText(this.actual.getTexto());
                break;
            } else {
                genNum();
                actual = (PreguntaVerdaderoFalso) lista.getListaPreguntas()[questionIndex];
            }
        }
        if (actual == null) {
            JOptionPane.showMessageDialog(vista, "Ya no quedan mas preguntas disponibles, pronto habran mas");
        }
    }
}
