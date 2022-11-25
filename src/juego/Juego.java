package juego;

import binario.EscritorBinario;
import binario.LectorBinario;
import controladores.ControladorMenuBienvenida;
import java.io.IOException;
import modelo.ListaUsuarios;
import vistas.InterfazMenuBienvenida;

/**
 * Estase consiste en el controlada clor del programa, que contiene el main
 *
 * @version 3 de noviembre 2022
 * @author @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740
 */
public class Juego {

    public static ListaUsuarios listaUsuarios;
    public static LectorBinario lector;
    public static EscritorBinario escritor;
    public static final String fileUsuarios = "usuarios.dat";

    public static void cargarLista() throws IOException, ClassNotFoundException {
        lector.open(fileUsuarios);
        lector.readAll();
        lector.close();
    }

    public static void escribirLista() throws IOException {
        escritor.open(fileUsuarios);
        escritor.writeAll();
        escritor.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        listaUsuarios = new ListaUsuarios();
        lector = new LectorBinario();
        escritor = new EscritorBinario();
        InterfazMenuBienvenida menu = new InterfazMenuBienvenida();
        ControladorMenuBienvenida controlador = new ControladorMenuBienvenida(menu);

    }

}
