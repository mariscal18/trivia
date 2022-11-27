/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import modelo.*;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author maris
 */
public class ListaPreguntas implements Serializable {

    private Pregunta[] listaPreguntas;

    public ListaPreguntas() {
        this.listaPreguntas = new Pregunta[0];
    }

    public void setListaPreguntas(Pregunta[] listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    public void agregar(Pregunta pregunta) throws IOException, ClassNotFoundException {
        this.aumentarLista();
        listaPreguntas[listaPreguntas.length - 1] = pregunta;
    }

    private void aumentarLista() {
        Pregunta[] listaAux = new Pregunta[listaPreguntas.length + 1];
        System.arraycopy(listaPreguntas, 0, listaAux, 0, listaPreguntas.length);
        listaPreguntas = listaAux;
    }

    public Pregunta[] getListaPreguntas() {
        return listaPreguntas;
    }
    
    public void eliminarPregunta(int index){
        listaPreguntas[index] = null;
    }

}
