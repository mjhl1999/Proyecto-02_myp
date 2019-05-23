import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Práctica 5: Excepciones, entrada/salida y enumeraciones.
 */
public class Cliente {

    public static Lista elegidas(VHSFactory base, Lista peli){
        base = new VHSFactory();
        //Lista seleccion = new Lista();

        //seleccion.agregaFinal(peli);

        System.out.println("\n ---------- \n" + "Las peliculas elegidas son: " + peli.toString() +
                          "\n ---------- \n");

        return peli;
    }

    /* Crea una base de datos y la llena cargándola del disco duro. Después la
       regresa. */
    public static VHSFactory lectura(String nombreArchivo) {
        VHSFactory bdd = new VHSFactory();

        try {
            FileInputStream fileIn = new FileInputStream(nombreArchivo);
            InputStreamReader isIn = new InputStreamReader(fileIn);
            BufferedReader in = new BufferedReader(isIn);
            bdd.dameDatos(in);
            in.close();
        } catch (IOException ioe) {
            System.out.printf("\nNo pude cargar del archivo \"%s\".\n\n",
                              nombreArchivo);
            System.exit(1);
        }

        System.out.println("----- Mostrando elementos para que el cliente escoja un VHS -----" + "\n");

        Lista r = bdd.getPeliculas();
        Lista.Nodo nodo = r.getCabeza();
        for (int i = 0; i < r.getLongitud(); i++ ) {
          System.out.println(i + ". " + nodo.get().toString() + "\n");
          nodo = nodo.getSiguiente();
        }

        System.out.printf("Base de datos cargada exitosamente de \"%s\".\n\n",
                          nombreArchivo);

        return bdd;
    }

}
