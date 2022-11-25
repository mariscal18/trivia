package binario;

import juego.Juego;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import modelo.ListaUsuarios;
import modelo.Usuario;

public class LectorBinario {

    private ObjectInputStream in;
    ListaUsuarios lista = Juego.listaUsuarios;

    public LectorBinario() {
    }

    public void open(String fileName) throws IOException {
        in = new ObjectInputStream(new FileInputStream(fileName));
    }

    public Usuario read() throws IOException, ClassNotFoundException {
        Usuario u = (Usuario) in.readObject();
        return u;
    }

    public void readAll() throws IOException, ClassNotFoundException {

        while (true) {

            try {
                lista.agregar(read());
            } catch (EOFException e) {
                break;
            }

        }

    }

    public void close() throws IOException {
        in.close();
    }

}
