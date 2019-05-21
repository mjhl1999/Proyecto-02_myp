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
public class MainCliente {

    private static String elegidas(VHSFactory bdd, String peli){

        System.out.println("La pelicula que vas a rentar será: " + peli + "\n");

        return peli;
    }

    /* Crea una base de datos y la llena cargándola del disco duro. Después la
       regresa. */
    private static VHSFactory lectura(String nombreArchivo) {
        VHSFactory bdd = new VHSFactory();

        System.out.printf("Base de datos cargada exitosamente de \"%s\".\n\n",
                          nombreArchivo);

        System.out.println("----- Mostrando elementos de la base de datos explicitos -----" + "\n");

        /* Si se quiere quitar que los imprima explicitos se debe modificar el
        * método carga de la clase VHS.
        */

        try {
            FileInputStream fileIn = new FileInputStream(nombreArchivo);
            InputStreamReader isIn = new InputStreamReader(fileIn);
            BufferedReader in = new BufferedReader(isIn);
            bdd.carga(in);
            in.close();
        } catch (IOException ioe) {
            System.out.printf("No pude cargar del archivo \"%s\".\n",
                              nombreArchivo);
            System.exit(1);
        }

        System.out.println("----- Mostrando elementos para que el cliente escoja un VHS -----" + "\n");

        Lista r = bdd.getPeliculas();
        Lista.Nodo nodo = r.getCabeza();
        while (nodo != null) {
            System.out.println(nodo.get().toString() + "\n");
            nodo = nodo.getSiguiente();
        }

        return bdd;
    }

    /* Imprime en pantalla cómo debe usarse el programa y lo termina. */
    private static void uso() {
        System.out.println("\n Uso: java main [-c|-e] <archivo> \n" +
                            "\n -c te permite leer el archivo, -e te permite elegir del archivo. \n" +
                            " Para poder ejecutar MainCliente es necesario primero haber ejecutado antes la clase Main" +
                            "pues es necesario para poder leer el archivo y elegir una pleicula de el. \n");
        System.exit(1);
    }

    public static void main(String[] args) {
        if (args.length != 2)
            uso();

        String bandera = args[0];
        String nombreArchivo = args[1];

        if (!bandera.equals("-c") && !bandera.equals("-e"))
            uso();

        VHSFactory bdd;

        if (bandera.equals("-c"))
            bdd = lectura(nombreArchivo);
        else{
          Scanner sc = new Scanner(System.in);

          bdd = lectura(nombreArchivo);
          System.out.println("Elige un VHS de la base de datos para elegir: ");
          String peli = sc.nextLine();
            elegidas(bdd, peli);
        }
    }
}
