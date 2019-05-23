import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public abstract class BaseDeDatos {

  public Lista peliculas;

  // Constructor.
  public BaseDeDatos(){
    this.peliculas = new Lista();
  }

  /* Método que nos regresa el número de VHS en la base de datos.
  * Simplemente regresamos la longitud de la lista donde las estamos almacenando.
  */
  public int getNumPeliculas() {
      return peliculas.getLongitud();
  }

  /* Método que nos regresa todas las peliculas por si las necesitamos.
  * Regresamos la copia de la lista.
  */
  public Lista getPeliculas(){
    return peliculas.copia();
  }

  /* Método que agrega un VHS al final de la base de datos.
  * Simplemente agregamos al final de la lista.
  */
  public void agregaVHS(Pelicula vhs){
    if(vhs != null)
      peliculas.agregaFinal(vhs);
  }

  /* Método que elimina un VHS de la base de datos.
  * Tomamos el VHS y lo quitamos de la lista.
  */
  public void eliminaVHS(Pelicula vhs){
    peliculas.elimina(vhs);
  }

  /* Método que vacía la base de datos.
  * Borramos cada elemento de la lista.
  */
  public void vaciaBaseDeDatos(){
    peliculas.limpia();
  }

  /* Método que guarda un VHS en la base de datos.
  * Tomamos el primer elemento de la base y lo escribimos, después hacemos lo mismo
  * con cada uno de los elementos hasta que ya no haya ninguno.
  */
  public void guarda(BufferedWriter out) throws IOException{
    Lista.Nodo n = peliculas.getCabeza();
    while(n != null) {
        Pelicula r = (Pelicula) n.get();
        r.guarda(out);
        n = n.getSiguiente();
    }
  }

  /* Método que carga la base de datos en un archivo de texto.
  * Lo usamos para sobreescribir un archivo existente, primero vaciamos el archivo,
  * después agregamos cada VHS recibido (en el formato necesitado para agregar).
  */
  public void carga(BufferedReader in) throws IOException{
    peliculas.limpia();
    do{
      Pelicula pelicula = creaPelicula();
      if(!pelicula.carga(in))
        break;
      agregaVHS(pelicula);
    } while (true);
  }

  /* Método que carga la base de datos en un archivo de texto.
  * Lo usamos para sobreescribir un archivo existente, primero vaciamos el archivo,
  * después agregamos cada VHS recibido (en el formato necesitado para agregar,
  * para después imprimirlos.
  */
  public void dameDatos(BufferedReader in) throws IOException{
    do{
      Pelicula pelicula = creaPelicula();
      if(!pelicula.dameDatos(in))
        break;
      agregaVHS(pelicula);
    } while (true);
  }


  /* Nos da el método que crea un VHS con el formato necesario para después poder
  * agregarlo a la base de datos.
  */
  public abstract Pelicula creaPelicula();

}
