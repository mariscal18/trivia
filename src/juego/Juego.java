package juego;

import archivos.texto.LectorPreguntas;
import binario.EscritorBinario;
import binario.LectorBinario;
import controladores.ControladorMenuBienvenida;
import estructuras.ListaPreguntas;
import java.io.IOException;
import modelo.ListaUsuarios;
import modelo.Usuario;
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
        cargador = new LectorPreguntas();
        cargarListaPreguntas();
        
        System.out.println(listaPreguntas.getListaPreguntas().length);
        System.out.println(listaPreguntas.getListaPreguntas()[1]);

        //ESTO ES TEMPORAL, PARA PROBAR LAS PREGUNTAS
        //NÓTESE QUE QUEMADO NO GUARDA EN NINGUNA PARTE LOS DATOS DE LAS ESTADÍSTICAS
        Usuario quemado = new Usuario("Quemado", "burnt");
        listaUsuarios = new ListaUsuarios();
        listaUsuarios.agregar(quemado);
        //*********************************************************************************
        
        //ESTE CODIGO DEBE DESCOMENTARSE CUANDO ESTÉ LISTA LA VALIDACIÓN DE USUARIO
        /*
        listaUsuarios = new ListaUsuarios();
        */
        
        lector = new LectorBinario();
        escritor = new EscritorBinario();
        InterfazMenuBienvenida menu = new InterfazMenuBienvenida();
        ControladorMenuBienvenida controlador = new ControladorMenuBienvenida(menu);

    }

}
