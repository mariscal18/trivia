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
import modelo.PreguntaSeleccionUnica;
import vistas.InterfazPreguntaSeleccionUnica;

public class ControladorSeleccionUnica implements ActionListener {

    private InterfazPreguntaSeleccionUnica vista;
    private ListaUsuarios listaUs = Juego.listaUsuarios;
    private ListaPreguntas lista = Juego.lista2;
    private int questionIndex;
    private int userIndex = ControladorIniciar.index;
    private int listSize;
    private PreguntaSeleccionUnica actual;

    public ControladorSeleccionUnica(InterfazPreguntaSeleccionUnica vista) {
        this.vista = vista;
        vista.volver.addActionListener(this);
        vista.a.addActionListener(this);
        vista.b.addActionListener(this);
        vista.c.addActionListener(this);
        vista.d.addActionListener(this);
        genNum();
        actual = (PreguntaSeleccionUnica) lista.getListaPreguntas()[questionIndex];
        vista.jTextField1.setText(actual.getTexto());
        vista.a.setText(actual.getRespuesta1());
        vista.b.setText(actual.getRespuesta2());
        vista.c.setText(actual.getRespuesta3());
        vista.d.setText(actual.getRespuesta4());
        this.vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.a) {
            if (actual.evaluarRespuesta(1)) {
                listaUs.getListaUsuarios()[userIndex].setNiv2_correct(listaUs.
                        getListaUsuarios()[userIndex].getNiv2_correct() + 1);
                JOptionPane.showMessageDialog(vista, "RESPUESTA CORRECTA");
            } else {
                listaUs.getListaUsuarios()[userIndex].setNiv2_incorrect(listaUs.
                        getListaUsuarios()[userIndex].getNiv2_incorrect() + 1);
                JOptionPane.showMessageDialog(vista, "RESPUESTA INCORRECTA");
            }
            try {
                Juego.escribirListaUsuarios();
            } catch (IOException ex) {
                Logger.getLogger(ControladorSeleccionUnica.class.getName()).log(Level.SEVERE, null, ex);
            }
            genNum();
            actual = (PreguntaSeleccionUnica) lista.getListaPreguntas()[questionIndex];
            vista.jTextField1.setText(actual.getTexto());
        }

        if (e.getSource() == vista.b) {
            if (actual.evaluarRespuesta(2)) {
                listaUs.getListaUsuarios()[userIndex].setNiv2_correct(listaUs.
                        getListaUsuarios()[userIndex].getNiv2_correct() + 1);
                JOptionPane.showMessageDialog(vista, "RESPUESTA CORRECTA");
            } else {
                listaUs.getListaUsuarios()[userIndex].setNiv2_incorrect(listaUs.
                        getListaUsuarios()[userIndex].getNiv2_incorrect() + 1);
                JOptionPane.showMessageDialog(vista, "RESPUESTA INCORRECTA");
            }
            try {
                Juego.escribirListaUsuarios();
            } catch (IOException ex) {
                Logger.getLogger(ControladorSeleccionUnica.class.getName()).log(Level.SEVERE, null, ex);
            }
            genNum();
            actual = (PreguntaSeleccionUnica) lista.getListaPreguntas()[questionIndex];
            vista.jTextField1.setText(actual.getTexto());
        }

        if (e.getSource() == vista.c) {
            if (actual.evaluarRespuesta(3)) {
                listaUs.getListaUsuarios()[userIndex].setNiv2_correct(listaUs.
                        getListaUsuarios()[userIndex].getNiv2_correct() + 1);
                JOptionPane.showMessageDialog(vista, "RESPUESTA CORRECTA");
            } else {
                listaUs.getListaUsuarios()[userIndex].setNiv2_incorrect(listaUs.
                        getListaUsuarios()[userIndex].getNiv2_incorrect() + 1);
                JOptionPane.showMessageDialog(vista, "RESPUESTA INCORRECTA");
            }
            try {
                Juego.escribirListaUsuarios();
            } catch (IOException ex) {
                Logger.getLogger(ControladorSeleccionUnica.class.getName()).log(Level.SEVERE, null, ex);
            }
            genNum();
            actual = (PreguntaSeleccionUnica) lista.getListaPreguntas()[questionIndex];
            vista.jTextField1.setText(actual.getTexto());
        }

        if (e.getSource() == vista.d) {
            if (actual.evaluarRespuesta(4)) {
                listaUs.getListaUsuarios()[userIndex].setNiv2_correct(listaUs.
                        getListaUsuarios()[userIndex].getNiv2_correct() + 1);
                JOptionPane.showMessageDialog(vista, "RESPUESTA CORRECTA");
            } else {
                listaUs.getListaUsuarios()[userIndex].setNiv2_incorrect(listaUs.
                        getListaUsuarios()[userIndex].getNiv2_incorrect() + 1);
                JOptionPane.showMessageDialog(vista, "RESPUESTA INCORRECTA");
            }
            try {
                Juego.escribirListaUsuarios();
            } catch (IOException ex) {
                Logger.getLogger(ControladorSeleccionUnica.class.getName()).log(Level.SEVERE, null, ex);
            }
            genNum();
            actual = (PreguntaSeleccionUnica) lista.getListaPreguntas()[questionIndex];
            vista.jTextField1.setText(actual.getTexto());
        }

        if (e.getSource() == vista.volver) {
            vista.dispose();
        }

    }

    public void genNum() {
        this.questionIndex = (int) (Math.random() * (lista.getListaPreguntas().length));
    }
}
