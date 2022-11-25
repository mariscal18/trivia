/**
 *
 * @author Usuario
 */
package binario;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import juego.Juego;
import modelo.ListaUsuarios;
import modelo.Usuario;

public class EscritorBinario {

    private ObjectOutputStream out;

    private ListaUsuarios lista = Juego.listaUsuarios;

    public EscritorBinario() {

    }

    public void open(String fileName) throws IOException {
        out = new ObjectOutputStream(new FileOutputStream(fileName));
    }

    public void write(Usuario u) throws IOException {
        out.writeObject(u);
    }

    public void writeAll() throws IOException {
        for (Usuario u : lista.getListaUsuarios()) {
            if (u != null) {
                write(u);
            }
        }
    }

    public void close() throws IOException {
        out.close();
    }

}
