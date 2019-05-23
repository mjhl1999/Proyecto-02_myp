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
public class Main {

    /* Crea una base de datos y la llena a partir de los datos que el usuario
       escriba a través del teclado. Después la guarda en disco duro y la
       regresa. */
    private static VHSFactory escritura(String nombreArchivo) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");

        File archivo = new File(nombreArchivo);

        System.out.println("\n Entra vhs's a la base de datos.\n" +
                           "Cuando desees terminar, mete un Id = 0.\n");

        if (archivo.exists()) {
            System.out.printf("El archivo \"%s\" ya existe.\n" +
                              "Presiona Ctrl-C si no quieres reescribirlo, " +
                              "o Enter para continuar...\n", nombreArchivo);
            sc.nextLine();
        }

        VHSFactory bdd = new VHSFactory();

        do {
            int id;
            String nombre;
            int año = 0;
            String director;
            String disponibilidad;
            double precio = 0.0;

            try {
                System.out.printf("Id   : ");
                id = sc.nextInt();
                if (id == 0)
                  break;
                System.out.printf("Nombre   : ");
                nombre = sc.next();
                System.out.printf("Año   : ");
                año = sc.nextInt();
                System.out.printf("Director   : ");
                director = sc.next();
                System.out.printf("Disponibilidad   : ");
                disponibilidad = sc.next();
                System.out.printf("Precio : ");
                precio = sc.nextDouble();
            } catch (InputMismatchException ime) {
                System.out.println("\n Entrada inválida: se descartará " +
                                   "este VHS.\n");
                break;
            }

            VHS vhs = new VHS(id,
                              nombre,
                              año,
                              director,
                              disponibilidad,
                              precio);

            VHSProxy vhsProxy = new VHSProxy(vhs);

            bdd.agregaVHS(vhsProxy);

            System.out.println();
        } while (true);

        int n = bdd.getNumPeliculas();
        if (n == 1)
            System.out.printf("\nSe agregó 1 VHS.\n");
        else
            System.out.printf("\nSe agregaron %d VHS.\n", n);

        try {
            FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
            OutputStreamWriter osOut = new OutputStreamWriter(fileOut);
            BufferedWriter out = new BufferedWriter(osOut);
            bdd.guarda(out);
            out.close();
        } catch (IOException ioe) {
            System.out.printf("No pude guardar en el archivo \"%s\".\n",
                              nombreArchivo);
            System.exit(1);
        }

        System.out.printf("\nBase de datos guardada exitosamente en \"%s\".\n",
                          nombreArchivo);

        return bdd;
    }

    /* Crea una base de datos y la llena cargándola del disco duro. Después la
       regresa. */
    private static VHSFactory lectura(String nombreArchivo) {
        VHSFactory bdd = new VHSFactory();


        /* Si se quiere quitar que los imprima explicitos se debe modificar el
        * método carga de la clase VHS.
        */

        try {
            FileInputStream fileIn = new FileInputStream(nombreArchivo);
            InputStreamReader isIn = new InputStreamReader(fileIn);
            BufferedReader in = new BufferedReader(isIn);
            //bdd.carga(in);
            bdd.dameDatos(in);
            in.close();
        } catch (IOException ioe) {
            System.out.printf("\nNo pude cargar del archivo \"%s\".\n\n",
                              nombreArchivo);
            System.exit(1);
        }


        System.out.println("----- Mostrando elementos de la base de datos implicitos -----" + "\n");

        Lista r = bdd.getPeliculas();
        Lista.Nodo nodo = r.getCabeza();
        while (nodo != null) {
            System.out.println(nodo.get().toString() + "\n");
            nodo = nodo.getSiguiente();
        }

        int n = bdd.getNumPeliculas();

        if(n == 0)
          System.out.println("No hay elementos. \n");

        System.out.printf("\nBase de datos cargada exitosamente de \"%s\".\n\n",
                          nombreArchivo);

        return bdd;
    }

    /* Imprime en pantalla cómo debe usarse el programa y lo termina. */
    private static void uso() {
        System.out.println("\n Uso: java main [-g|-c] <archivo> \n" +
                            "\n -g te permite escribir un archivo, -c te permite leer el archivo");
        System.exit(1);
    }

    public static void main(String[] args) {
        if (args.length != 2)
            uso();

        String bandera = args[0];
        String nombreArchivo = args[1];

        if (!bandera.equals("-g") && !bandera.equals("-c"))
            uso();

        VHSFactory bdd;

        if (bandera.equals("-g"))
            bdd = escritura(nombreArchivo);
        else
            bdd = lectura(nombreArchivo);
    }
}
