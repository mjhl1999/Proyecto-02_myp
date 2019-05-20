import java.io.*;

public class Conexion{

  public void escribirBD(){
    try{
    FileWriter fichero = new FileWriter("BaseDeDatosVHS.db");
    fichero.close();
    }catch (Exception e) {
    }
  }


  public String lecturaBD(String direccion){
    String texto = "";

    try{
    BufferedReader br = new BufferedReader(new FileReader(direccion));
    String cadena = "";
    String lectura = br.readLine();

    while(lectura != null){
      cadena = cadena + lectura;
    }
    texto = cadena;

  }catch (Exception e) {
    System.err.println("No existe el archivo");
  }

  return texto;
  }


}
