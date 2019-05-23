import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


public interface Pelicula {

    /**
     * Guarda la pelicula en la salida recibida.
     * @param out la salida donde hay que guardar la pelicula.
     * @throws IOException si ocurre un error de entrada/salida.
     */
    public void guarda(BufferedWriter out) throws IOException;

    /**
     * Carga la pelicula de la entrada recibida.
     * @param in la entrada de donde hay que cargar la pelicula.
     * @return true si una pelicula válido fue leído; false en
     *         otro caso.
     * @throws IOException si ocurre un error de entrada/salida.
     */
    public boolean carga(BufferedReader in) throws IOException;

    /**
     * Carga la pelicula de la entrada recibida.
     * @param in la entrada de donde hay que cargar la pelicula.
     * @return true si una pelicula válido fue leído; false en
     *         otro caso.
     * @throws IOException si ocurre un error de entrada/salida.
     * Además imprime los datos.
     */
    public boolean dameDatos(BufferedReader in) throws IOException;

    /**
     * Actualiza los valores de la pelicula con los de la pelicula recibida.
     * @param pelicula la pelicula con la cual actualizar los valores.
     * @throws ClassCastException si la pelicula recibida no es instancia de la
     *         misma clase de la pelicula que invoca el método.
     */
    public void actualiza(Pelicula pelicula);
}
