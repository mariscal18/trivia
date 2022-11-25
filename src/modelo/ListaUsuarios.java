/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.IOException;
import java.io.Serializable;
import juego.Juego;

/**
 *
 * @author maris
 */
public class ListaUsuarios implements Serializable {

    private Usuario[] listaUsuarios;
    private final String fileName = "usuarios.dat";

    public ListaUsuarios() {
        this.listaUsuarios = new Usuario[0];
    }

    public void agregar(Usuario usuario) throws IOException, ClassNotFoundException {
        this.aumentarLista();
        listaUsuarios[listaUsuarios.length - 1] = usuario;
    }

    private void aumentarLista() {
        Usuario[] listaAux = new Usuario[listaUsuarios.length + 1];
        for (int i = 0; i < listaUsuarios.length; i++) {
            listaAux[i] = listaUsuarios[i];
        }
        listaUsuarios = listaAux;
    }

    public Usuario[] getListaUsuarios() {
        return listaUsuarios;
    }
}
