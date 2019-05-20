import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>Clase para listas doblemente ligadas.</p>
 *
 * <p>Las listas nos permiten agregar elementos al inicio o final de la lista,
 * eliminar elementos de la lista, comprobar si un elemento está o no en la
 * lista, y otras operaciones básicas.</p>
 *
 * <p>Las listas son iterables utilizando sus nodos.</p>
 */
public class Lista {

    /**
     * Clase para nodos de uso interno a la clase Lista.
     */
    public class Nodo {

        /* El elemento del nodo. */
        private Object elemento;
        /* El nodo anterior. */
        private Nodo anterior;
        /* El nodo siguiente. */
        private Nodo siguiente;

        /**
         * Construye un nodo con un elemento.
         * @param elemento el elemento del nodo.
         */
        public Nodo(Object elemento) {
            this.elemento = elemento;
        }

        /**
         * Regresa el nodo anterior del nodo.
         * @return el nodo anterior del nodo.
         */
        public Nodo getAnterior() {
            return this.anterior;
        }

        /**
         * Regresa el nodo siguiente del nodo.
         * @return el nodo siguiente del nodo.
         */
        public Nodo getSiguiente() {
            return this.siguiente;
        }

        /**
         * Regresa el elemento del nodo.
         * @return el elemento del nodo.
         */
        public Object get() {
            return this.elemento;
        }
    }

    /* Primer elemento de la lista. */
    private Nodo cabeza;
    /* Último elemento de la lista. */
    private Nodo rabo;
    /* Número de elementos en la lista. */
    private int longitud;

    /**
     * Regresa la longitud de la lista.
     * @return la longitud de la lista, el número de elementos que contiene.
     */
    public int getLongitud() {
        return this.longitud;
    }

    /**
     * Nos dice si la lista es vacía.
     * @return <code>true</code> si la lista es vacía, <code>false</code> en
     *         otro caso.
     */
    public boolean esVacia() {
        if (this.cabeza != null && this.rabo != null)
            return false;
        else
            return true;
    }

    /**
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaFinal(Object elemento) throws IllegalArgumentException {
        if (elemento == null)
            throw new IllegalArgumentException();
        Nodo nuevo = new Nodo(elemento);
        longitud++;
        if(rabo == null)
            cabeza = rabo = nuevo;
        else {
            nuevo.anterior = rabo;
            rabo.siguiente = nuevo;
            rabo = nuevo;
        }
    }

    /**
     * Agrega un elemento al inicio de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaInicio(Object elemento) throws IllegalArgumentException {
        if (elemento == null)
            throw new IllegalArgumentException();
        Nodo nuevo = new Nodo(elemento);
        longitud++;
        if(cabeza == null)
            cabeza = rabo = nuevo;
        else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
    }

    /**
     * Inserta un elemento en un índice explícito.
     *
     * Si el índice es menor o igual que cero, el elemento se agrega al inicio
     * de la lista. Si el índice es mayor o igual que el número de elementos en
     * la lista, el elemento se agrega al fina de la misma. En otro caso,
     * después de mandar llamar el método, el elemento tendrá el índice que se
     * especifica en la lista.
     * @param i el índice dónde insertar el elemento. Si es menor que 0 el
     *          elemento se agrega al inicio de la lista, y si es mayor o igual
     *          que el número de elementos en la lista se agrega al final.
     * @param elemento el elemento a insertar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void inserta(int i, Object elemento) throws IllegalArgumentException {
        if (elemento == null)
            throw new IllegalArgumentException();
        if (i <= 0) {
            agregaInicio(elemento);
        }
        else if (i >= longitud) {
            agregaFinal(elemento);
        }
        else {
            int contador = 0;
            Nodo nodo = cabeza;
            if (nodo == null) {
                agregaInicio(elemento);
                return;
            }
            while(nodo != null) {
                if (contador == i) {
                    Nodo nuevo = new Nodo(elemento);
                    longitud++;
                    nuevo.siguiente = nodo;
                    if (nodo.anterior != null) {
                        nuevo.anterior = nodo.anterior;
                        nuevo.anterior.siguiente = nuevo;
                    }
                    nuevo.siguiente.anterior = nuevo;
                    return;
                }
                contador++;
                nodo = nodo.siguiente;
            }
        }
    }

    /**
     * Elimina un elemento de la lista. Si el elemento no está contenido en la
     * lista, el método no la modifica.
     * @param elemento el elemento a eliminar.
     */
    public void elimina(Object elemento) {
        Nodo nodo = cabeza;
        while(nodo != null) {
            if(nodo.elemento.equals(elemento)) {
                this.longitud--;
                if (nodo.siguiente != null && nodo.anterior != null) {
                    nodo.siguiente.anterior = nodo.anterior;
                    nodo.anterior.siguiente = nodo.siguiente;
                }
                else if (nodo.siguiente != null && nodo.anterior == null) {
                    nodo.siguiente.anterior = null;
                    cabeza = nodo.siguiente;
                }
                else if (nodo.anterior != null && nodo.siguiente == null) {
                    nodo.anterior.siguiente = null;
                    rabo = nodo.anterior;
                }
                else if (nodo.anterior == null && nodo.siguiente == null)
                    cabeza = rabo = null;
                return;
            }
            nodo = nodo.siguiente;
        }
        return;
    }

    /**
     * Elimina el primer elemento de la lista y lo regresa.
     * @return el primer elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public Object eliminaPrimero() throws NoSuchElementException {
        if (esVacia())
            throw new NoSuchElementException();
        else {
            Object elemento = cabeza.elemento;
            if (cabeza.siguiente != null) {
                cabeza.siguiente.anterior = null;
                cabeza = cabeza.siguiente;
            }
            else
                cabeza = rabo = null;
            longitud--;
            return elemento;
        }
    }

    /**
     * Elimina el último elemento de la lista y lo regresa.
     * @return el último elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public Object eliminaUltimo() throws NoSuchElementException {
        if (esVacia())
            throw new NoSuchElementException();
        else {
            Object elemento = rabo.elemento;
            if (rabo.anterior != null) {
                rabo.anterior.siguiente = null;
                rabo = rabo.anterior;
            }
            else
                rabo = cabeza = null;
            longitud--;
            return elemento;
        }
    }

    /**
     * Nos dice si un elemento está en la lista.
     * @param elemento el elemento que queremos saber si está en la lista.
     * @return <tt>true</tt> si <tt>elemento</tt> está en la lista,
     *         <tt>false</tt> en otro caso.
     */
    public boolean contiene(Object elemento) {
        if (esVacia())
            return false;
        else {
            Nodo nodo = cabeza;
            while (nodo != null) {
                if (nodo.elemento.equals(elemento))
                    return true;
                nodo = nodo.siguiente;
            }
            return false;
        }
    }

    /**
     * Regresa la reversa de la lista.
     * @return una nueva lista que es la reversa la que manda llamar el método.
     */
    public Lista reversa() {
        Nodo nodo = cabeza;
        Lista lista = new Lista();
        while (nodo != null) {
            lista.agregaInicio(nodo.elemento);
            nodo = nodo.siguiente;
        }
        return lista;
    }

    /**
     * Regresa una copia de la lista. La copia tiene los mismos elementos que la
     * lista que manda llamar el método, en el mismo orden.
     * @return una copiad de la lista.
     */
    public Lista copia() {
        Nodo nodo = cabeza;
        Lista lista = new Lista();
        while (nodo != null) {
            lista.agregaFinal(nodo.elemento);
            nodo = nodo.siguiente;
        }
        return lista;
    }

    /**
     * Limpia la lista de elementos. El llamar este método es equivalente a
     * eliminar todos los elementos de la lista.
     */
    public void limpia() {
        cabeza = null;
        rabo = null;
        longitud = 0;
    }

    /**
     * Regresa el primer elemento de la lista.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public Object getPrimero() throws NoSuchElementException {
        if (esVacia())
            throw new NoSuchElementException();
        return cabeza.elemento;
    }

    /**
     * Regresa el último elemento de la lista.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public Object getUltimo() throws NoSuchElementException {
        if (esVacia())
            throw new NoSuchElementException();
        return rabo.elemento;
    }

    /**
     * Regresa el <em>i</em>-ésimo elemento de la lista.
     * @param i el índice del elemento que queremos.
     * @return el <em>i</em>-ésimo elemento de la lista.
     * @throws ExcepcionIndiceInvalido si <em>i</em> es menor que cero o mayor o
     *         igual que el número de elementos en la lista.
     */
    public Object get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= longitud)
            throw new IndexOutOfBoundsException();
        else {
            Nodo nodo = cabeza;
            int contador = 0;
            while (nodo != null) {
                if (contador == i)
                    return nodo.elemento;
                contador++;
                nodo = nodo.siguiente;
            }
        }
        return null;
    }

    /**
     * Regresa el índice del elemento recibido en la lista.
     * @param elemento el elemento del que se busca el índice.
     * @return el índice del elemento recibido en la lista, o -1 si el elemento
     *         no está contenido en la lista.
     */
    public int indiceDe(Object elemento) {
        Nodo nodo = cabeza;
        int contador = 0;
        while (nodo != null) {
            if (nodo.elemento.equals(elemento))
                return contador;
            contador++;
            nodo = nodo.siguiente;
        }
        return -1;
    }

    /**
     * Regresa una representación en cadena de la lista.
     * @return una representación en cadena de la lista.
     */
    @Override public String toString() {
        String resultado = "[";
        Nodo nodo = cabeza;
        while (nodo != null) {
            if (nodo.elemento.equals(rabo.elemento))
                resultado += String.format("%s", nodo.elemento);
            else
                resultado += String.format("%s, ", nodo.elemento);
            nodo = nodo.siguiente;
        }
        resultado += "]";
        return resultado;
    }

    /**
     * Nos dice si la lista es igual al objeto recibido.
     * @param o el objeto con el que hay que comparar.
     * @return <tt>true</tt> si la lista es igual al objeto recibido;
     *         <tt>false</tt> en otro caso.
     */
    @Override public boolean equals(Object o) {
        if (!(o instanceof Lista))
            return false;
        Lista aux = (Lista) o;
        if (this.longitud != aux.longitud)
            return false;
        Nodo nodo = cabeza;
        int contador = 0;
        while (nodo != null) {
            if (!(nodo.elemento.equals(aux.get(contador))))
                return false;
            contador++;
            nodo = nodo.siguiente;
        }
        return true;
    }

    /**
     * Regresa el nodo cabeza de la lista.
     * @return el nodo cabeza de la lista.
     */
    public Nodo getCabeza() {
        return cabeza;
    }

    /**
     * Regresa el nodo rabo de la lista.
     * @return el nodo rabo de la lista.
     */
    public Nodo getRabo() {
        return rabo;
    }
}
