import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class VHS implements Pelicula{
/**
* Clase para definir como será un VHS con todas sus propiedades como lo pueden ser:
-> id: Un identificador unico por VHS.
-> nombre: El nombre que tendrá el VHS, el cual puede no ser único.
-> año: El año en que se creó.
-> director: La persona que lo dirigió.
-> disponibilidad: Nos dice si hay existencias o no de un VHs en la tienda.
-> precio: El precio que tendrá rentar/comprar el VHS.
*/

	// El identificador de los VHS.
	int id;
	// El nombre del VHS.
	String nombre;
	// El año del VHS.
	int año;
	// El director.
	String director;
	// Nos dice si hay existencias en la tienda.
	String disponibilidad;
	// Precio de renta/venta.
	double precio;


	// Constructor.
	public VHS(int id, String nombre, int año, String director, String disponibilidad,
						double precio){
		this.id = id;
		this.nombre = nombre;
		this.año = año;
		this.director = director;
		this.disponibilidad = disponibilidad;
		this.precio = precio;
	}


	/**
	* Define el Id del VHS.
	* @param id el id del VHS.
	*/
	public void setId(int id){
		this.id = id;
	}

	/**
	* Método que nos regresa el Id del VHS.
	* @return el id del VHS.
	*/
	public int getId(){
		return id;
	}

	/**
	* Define el nombre del VHS.
	* @param nombre el nombre del VHS.
	*/
	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	/**
	* Método que nos da el nombre del VHS.
	* @return el nombre del VHS.
	*/
	public String getNombre(){
		return nombre;
	}

	/**
	* Define el año del VHS.
	* @param año el año del VHS.
	*/
	public void setAño(int año){
		this.año = año;
	}

	/**
	* Método que nos da el año del VHS.
	* @return el año del VHS.
	*/
	public int getAño(){
		return año;
	}

	/**
	* Define el director del VHS.
	* @param director el director del VHS.
	*/
	public void setDirector(String director){
		this.director = director;
	}

	/**
	* Método que nos da el director del VHS.
	* @return el director del VHS.
	*/
	public String getDirector(){
		return director;
	}

	/**
	* Define la disponibilidad del VHS.
	* @param disponibilidad la disponibilidad del VHS.
	*/
	public void setDisponibilidad(String disponibilidad){
		this.disponibilidad = disponibilidad;
	}

	/**
	* Método que nos dice la disponibilidad del VHS.
	* @return si está disponible o no del VHS.
	*/
	public String getDisponibilidad(){
		return disponibilidad;
	}

	/**
	* Define el año del VHS.
	* @param año el año del VHS.
	*/
	public void setPrecio(double precio){
		this.precio = precio;
	}

	/**
	* Método que nos da el precio del VHS.
	* @return el precio del VHS.
	*/
	public double getPrecio(){
		return precio;
	}

	/* Método que guarda un VHS en la base de datos.
	* Simplemente escribimos en la salida cada atributo de un VHS con formato.
	*/
	@Override public void guarda(BufferedWriter out) throws IOException {
		out.write(String.format("%d\t%s\t%d\t%s\t%s\t%2.2f\n",
							id, nombre, año, director, disponibilidad, precio ));
	}

	/* Método que nos dice si es posible cargar la base de datos, mientras la carga.
	*	Definimos los atributos del VHS con cada entrada recibida al ejecutar y si
	* los tiene todos, regresamos true al cargarlo.
	*/
	@Override public boolean carga(BufferedReader in) throws IOException {
			String vhs = in.readLine();
			if (vhs == null)
					return false;
			vhs = vhs.trim();
			if (vhs.equals(""))
					return false;
			String[] datos = vhs.split("\t");
			if (datos.length != 6)
					throw new IOException();
			try {
					this.id = Integer.parseInt(datos[0]);
					this.nombre = datos[1];
					this.año = Integer.parseInt(datos[2]);
					this.director = datos[3];
					this.disponibilidad = datos[4];
					this.precio = Double.parseDouble(datos[5]);

					// Nos sirve para poder imprimir cada atributo de forma explicita en la BDD.
					System.out.println("___" + "\n \n" + 
														 "Id: " + id + "\n" +
			                       "Nombre: " + nombre + "\n" +
			                       "Año: " + año + "\n" +
			                       "Director: " + director + "\n" +
			                       "Disponibilidad: " + disponibilidad + "\n" +
			                       "Precio: " + precio + "\n" +
														 "___" + "\n");

			} catch(NumberFormatException e) {
					throw new IOException();
			}
			return true;
	}


	@Override public void actualiza(Pelicula pelicula) {
			if (!(pelicula instanceof VHS))
					throw new ClassCastException();
			VHS vhs = (VHS) pelicula;
			setId(vhs.getId());
			setNombre(vhs.getNombre());
			setAño(vhs.getAño());
			setDirector(vhs.getDirector());
			setDisponibilidad(vhs.getDisponibilidad());
			setPrecio(vhs.getPrecio());
	}

}
