public class VHSFactory extends BaseDeDatos {

  /* Método que nos crea como será un VHS, es decir la forma en la que se ven:
  * VHS(Id, Nombre, Año, Director, Disponibilidad, Precio).
  */
  @Override public Pelicula creaPelicula(){
    Pelicula pelicula = new VHS(0, null, 0, null, null, 0.0);
    return pelicula;
  }

}
