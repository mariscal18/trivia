package juego;

import archivos.texto.LectorPreguntas;
import binario.EscritorBinario;
import binario.LectorBinario;
import controladores.ControladorMenuBienvenida;
import estructuras.ListaPreguntas;
import java.io.IOException;
import modelo.ListaUsuarios;
import modelo.Usuario;
import modelo.Pregunta;
import modelo.PreguntaSeleccionMultiple;
import modelo.PreguntaSeleccionUnica;
import modelo.PreguntaVerdaderoFalso;
import vistas.InterfazMenuBienvenida;

/**
 * Estase consiste en el controlada clor del programa, que contiene el main
 *
 * @version 3 de noviembre 2022
 * @author @author Keiron Garro Matamoros C23212, Jorge Zúñiga Torres C08740
 */
public class Juego {

    public static ListaPreguntas listaPreguntas;
    public static ListaUsuarios listaUsuarios;
    public static LectorBinario lector;
    public static EscritorBinario escritor;
    public static LectorPreguntas cargador;
    public static final String fileUsuarios = "usuarios.dat";
    public static final String ruta = "file.txt";
    public static ListaPreguntas lista1;
    public static ListaPreguntas lista2;
    public static ListaPreguntas lista3;

    public static void cargarListaPreguntas() throws IOException, ClassNotFoundException {

        cargador.open(ruta);
        String ruta = cargador.readRuta();
        cargador.close();

        cargador.open(ruta);
        int a = cargador.contarLineas();
        cargador.close();

        cargador.open(ruta);
        listaPreguntas.setListaPreguntas(cargador.readListaPreguntas(a));
        cargador.close();
    }

    public static void cargarListaUsuarios() throws IOException, ClassNotFoundException {
        lector.open(fileUsuarios);
        lector.readAll();
        lector.close();
    }

    public static void escribirListaUsuarios() throws IOException {
        escritor.open(fileUsuarios);
        escritor.writeAll();
        escritor.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        listaPreguntas = new ListaPreguntas();
        listaUsuarios = new ListaUsuarios();
        cargador = new LectorPreguntas();
        lector = new LectorBinario();
        escritor = new EscritorBinario();
        cargarListaPreguntas();
        cargarListaUsuarios();

        lista1 = new ListaPreguntas();
        lista2 = new ListaPreguntas();
        lista3 = new ListaPreguntas();

        for (Pregunta p : listaPreguntas.getListaPreguntas()) {
            if (p instanceof PreguntaVerdaderoFalso) {
                lista1.agregar(p);
            }
            if (p instanceof PreguntaSeleccionUnica) {
                lista2.agregar(p);
            }
            if (p instanceof PreguntaSeleccionMultiple) {
                lista3.agregar(p);
            }
        }

        InterfazMenuBienvenida menu = new InterfazMenuBienvenida();
        ControladorMenuBienvenida controlador = new ControladorMenuBienvenida(menu);

    }

}
