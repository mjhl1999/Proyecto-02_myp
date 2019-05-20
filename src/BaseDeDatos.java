import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public abstract class BaseDeDatos {

  public Lista peliculas;

  // Constructor.
  public BaseDeDatos(){
    this.peliculas = new Lista();
  }

  public int getNumPeliculas() {
      return peliculas.getLongitud();
  }

  public Lista getPeliculas(){
    return peliculas.copia();
  }


  public void agregaVHS(Pelicula vhs){
    if(vhs != null)
      peliculas.agregaFinal(vhs);
  }

  public void eliminaVHS(Pelicula vhs){
    peliculas.elimina(vhs);
  }


  public void vaciaBaseDeDatos(){
    peliculas.limpia();
  }

  public void guarda(BufferedWriter out) throws IOException{
    Lista.Nodo n = peliculas.getCabeza();
    while(n != null) {
        Pelicula r = (Pelicula) n.get();
        r.guarda(out);
        n = n.getSiguiente();
    }
  }

  public void carga(BufferedReader in) throws IOException{
    peliculas.limpia();
    do{
      Pelicula pelicula = creaPelicula();
      if(!pelicula.carga(in))
        break;
      agregaVHS(pelicula);
    } while (true);
  }

  public abstract Pelicula creaPelicula();

}
