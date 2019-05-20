public class BaseDeDatosPeliculas extends BaseDeDatos {

  @Override public Pelicula creaPelicula(){
    Pelicula pelicula = new VHS(0, null, 0, null, null, 0.0);
    return pelicula;
  }
}
