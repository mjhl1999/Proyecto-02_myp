import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Interfaz para peliculas. Las peliculas deben de poder guardarse utilizando
 * una instancia de {@link BufferedWriter}, cargarse utilizando una instancia de
 * {@link BufferedReader}, y actualizarse con los valores de otro pelicula.
 */
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
     * @return <tt>true</tt> si un pelicula válido fue leído; <tt>false</tt> en
     *         otro caso.
     * @throws IOException si ocurre un error de entrada/salida.
     */
    public boolean carga(BufferedReader in) throws IOException;

    /**
     * Actualiza los valores del pelicula con los del pelicula recibido.
     * @param pelicula la pelicula con la cual actualizar los valores.
     * @throws ClassCastException si la pelicula recibido no es instancia de la
     *         misma clase del pelicula que invoca el método.
     */
    public void actualiza(Pelicula pelicula);
}
