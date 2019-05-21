import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Interfaz para iteradores de lista. Un iterador de lista se puede visualizar
 * como que está siempre entre dos elementos de la lista, o antes del primero, o
 * después del último.
 */
public interface IteradorLista<T> extends Iterator<T> {

    /**
     * Nos dice si hay un elemento anterior. El método debe regresar
     * true, excepto cuando la lista esté vacía, o el iterador esté
     * antes del primer elemento.
     */
    public boolean hasPrevious();

    /**
     * Regresa el elemento anterior al iterador, y lo mueve a la izquierda.
     * @return el elemento anterior al iterador.
     * @throws NoSuchElementException si el iterador no tiene elemento anterior.
     */
    public T previous();

    /** Mueve el iterador a la izquierda del primer elemento. hasNext regresa true
    * si la lista no es vacía.
    */
    public void start();

    /** Mueve el iterador a la derecha del último elemento. hasPrevious regresa true
    * si la lista no es vacía.
    */
    public void end();
}
