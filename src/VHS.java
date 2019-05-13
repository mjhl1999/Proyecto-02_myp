public class VHS{

	int id;
	String nombre;
	int año;
  String director;
	boolean disponibilidad;
	double precio;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public int getAño(){
		return año;
	}

	public void setAño(int año){
		this.año = año;
	}

	public String getDirector(){
		return director;
	}

	public void setDirector(String director){
		this.director = director;
	}

	public boolean getDisponibilidad(){
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad){
		this.disponibilidad = disponibilidad;
	}

	public double getPrecio(){
		return precio;
	}

	public void setPrecio(double precio){
		this.precio = precio;
	}

}
