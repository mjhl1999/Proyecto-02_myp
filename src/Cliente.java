public class Cliente{

/**
* Clase para definir como serán los clientes que adquieran los Vhs de la tienda.
-> nombre: Nos dice el nombre del cliente.
-> cuenta: El número de cuenta del cliente (de exactamente 5 dígitos).
-> peliculasRentadas: Nos dice el número de peliculas rentadas que tiene el cliente.
-> esFrecuente: Nos dice si es un cliente recuente o si es solo de paso.
*/

  // El nombre del cliente.
  String nombre;
  // El número de cuenta del cliente.
  int cuenta;
  // El número de peliculas rentadas.
  int peliculasRentadas;
  // Nos dice si es cliente frecuente, sirve para los descuentos.
  boolean esFrecuente;


  // Constructor.
  public Cliente(String nombre, int cuenta, int peliculasRentadas, boolean esFrecuente){
    this.nombre = nombre;
    this.cuenta = cuenta;
    this.peliculasRentadas = peliculasRentadas;
    this.esFrecuente = esFrecuente;
  }


  /**
	* Define el nombre del cliente.
	* @param nombre el nombre del cliente.
	*/
  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  /**
	* Método que nos regresa el nombre del cliente.
	* @return el nombre del cliente.
	*/
  public String getNombre(){
    return nombre;
  }

  /**
	* Define el número de cuenta del cliente.
	* @param cuenta el número de cuenta del cliente.
	*/
  public void setCuenta(int cuenta){
    this.cuenta = cuenta;
  }

  /**
	* Método que nos regresa el número de cuenta del cliente.
	* @return el número de cuenta del cliente.
	*/
  public int getCuenta(){
    return cuenta;
  }

  /**
	* Define el número de peliculas rentadas que tiene el cliente.
	* @param peliculasRentadas el número de peliculas rentadas que tiene el cliente.
	*/
  public void setRentadas(int peliculasRentadas){
    this.peliculasRentadas = peliculasRentadas;
  }

  /**
  * Método que nos regresa el número de peliculas rentadas que tiene el cliente.
	* @return el número de peliculas rentadas que tiene cliente.
	*/
  public int getRentadas(){
    return peliculasRentadas;
  }

  /**
	* Define si el cliente es frecuente o no.
	* @param esFrecuente si el cliente es frecuente o no.
	*/
  public void setEsFrecuente(boolean esFrecuente){
    this.esFrecuente = esFrecuente;
  }

  /**
  * Método que nos regresa si el cliente es frecuente.
	* @return si el cliente es frecuente.
	*/
  public boolean getEsFrecuente(){
    return esFrecuente;
  }


}
