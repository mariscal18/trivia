/**
 *
 * @author Administrator
 */
package controladores;

import estructuras.ListaPreguntas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import juego.Juego;
import modelo.ListaUsuarios;
import modelo.PreguntaSeleccionMultiple;
import vistas.InterfazPreguntaSeleccionMultiple;

public class ControladorSeleccionMultiple implements ActionListener {

    private InterfazPreguntaSeleccionMultiple vista;
    private ListaUsuarios listaUs = Juego.listaUsuarios;
    private ListaPreguntas lista = Juego.lista3;
    private int questionIndex;
    private int userIndex = ControladorIniciar.index;
    private int listSize;
    private PreguntaSeleccionMultiple actual;

    public ControladorSeleccionMultiple(InterfazPreguntaSeleccionMultiple vista) {
        this.vista = vista;
        vista.volver.addActionListener(this);
        vista.evaluar.addActionListener(this);
        genNum();
        actual = (PreguntaSeleccionMultiple) lista.getListaPreguntas()[questionIndex];
        vista.pregunta.setText(actual.getTexto());
        vista.jTextField1.setText(actual.getRespuesta1());
        vista.jTextField2.setText(actual.getRespuesta2());
        vista.jTextField4.setText(actual.getRespuesta3());
        vista.jTextField3.setText(actual.getRespuesta4());
        this.vista.setLocationRelativeTo(null);
        vista.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.evaluar) {
            System.out.println(actual.getRespuesta1() + actual.getRespuesta2() + actual.getRespuesta3() + actual.getRespuesta4());
            System.out.println(actual.getValorRespuesta1() + " " + actual.getValorRespuesta2() + " " + actual.getValorRespuesta3() + " " + actual.getValorRespuesta4());

            if (actual.evaluarRespuesta(vista.jComboBox1.getSelectedIndex() + 1, vista.jComboBox2.getSelectedIndex() + 1, vista.jComboBox3.getSelectedIndex() + 1, vista.jComboBox4.getSelectedIndex() + 1)) {
                listaUs.getListaUsuarios()[userIndex].setNiv3_correct(listaUs.
                        getListaUsuarios()[userIndex].getNiv3_correct() + 1);
                JOptionPane.showMessageDialog(vista, "RESPUESTAS CORRECTAS");
            } else {
                listaUs.getListaUsuarios()[userIndex].setNiv3_incorrect(listaUs.
                        getListaUsuarios()[userIndex].getNiv3_incorrect() + 1);
                JOptionPane.showMessageDialog(vista, "RESPUESTAS INCORRECTAS");
            }

            try {
                Juego.escribirListaUsuarios();
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(ControladorSeleccionMultiple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

            genNum();
            actual = (PreguntaSeleccionMultiple) lista.getListaPreguntas()[questionIndex];
            vista.pregunta.setText(actual.getTexto());
            vista.jTextField1.setText(actual.getRespuesta1());
            vista.jTextField2.setText(actual.getRespuesta2());
            vista.jTextField4.setText(actual.getRespuesta3());
            vista.jTextField3.setText(actual.getRespuesta4());
        }

        if (e.getSource() == vista.volver) {
            vista.dispose();
        }
    }

    public void genNum() {
        this.questionIndex = (int) (Math.random() * (lista.getListaPreguntas().length));
    }
}
