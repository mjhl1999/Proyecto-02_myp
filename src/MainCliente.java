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

public class MainCliente {

  static Cliente cliente;

  /* Imprime en pantalla cómo debe usarse el programa y lo termina. */
  private static void uso() {
      System.out.println("\n Uso: java main [-c|-e] <archivo> \n" +
                          "\n -c te permite leer el archivo, -e te permite elegir del archivo. \n\n" +
                          " Para poder ejecutar MainCliente es necesario primero haber ejecutado antes la clase Main " +
                          "pues es necesario para poder leer el archivo y elegir una pelicula de el. \n");
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
          bdd = cliente.lectura(nombreArchivo);
      else{
        bdd = cliente.lectura(nombreArchivo);

        int peli;
        Lista compras = new Lista();
        String terminado;

        do {
            Scanner sc = new Scanner(System.in);

          try{
              System.out.println("\n");
              System.out.println("Para dejar de elegir introduce -1. \n" +
                                "Elige un VHS de la base de datos: ");
              peli = sc.nextInt();

              System.out.println("\n" + "¿Terminaste de elegir? (Si/No)");
              terminado = sc.next();

              if(peli == -1)
                  break;
              else if(peli < -1 || peli >= bdd.getNumPeliculas()){
                  System.out.println("\n ----- \n" + "No puedes comprar este VHS, no existe en la " +
                                      "base de datos. \n" + "----- \n");
                  continue;
              }


          }catch (InputMismatchException ime) {
              System.out.println("\n" + "Entrada inválida: se descartará " +
                                "este VHS.\n");
              continue;
          }

          if(terminado.equals("Si")){
              compras.agregaFinal(peli);
              break;
          }
          else if(terminado.equals("No")){
              compras.agregaFinal(peli);
          }
          else{
              System.out.println("\n" + "Tu respuesta debe ser (Si/No): ");
              terminado = sc.next();

              if(terminado.equals("Si")){
                compras.agregaFinal(peli);
                break;
              }
              else if(terminado.equals("No")){
                compras.agregaFinal(peli);
              }
          }
          //peli = Integer.parseInt(opcion);
        } while (true);
        cliente.elegidas(bdd, compras);
      }
  }
}
