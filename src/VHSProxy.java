import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class VHSProxy implements Pelicula{

  // El VHS.
  VHS vhs;

  // Constructor.
  public VHSProxy(VHS vhs){
    this.vhs = vhs;
  }

  /* Método que guarda un VHS.
  * Simplemente mandamos llamar al método que guarda desde VHS.
  */
  @Override public void guarda(BufferedWriter out) throws IOException {
		vhs.guarda(out);
	}

  /* Método que carga un VHS.
  * Simplemente mandamos llamar al método que carga desde VHS.
  */
	@Override public boolean carga(BufferedReader in) throws IOException {
			return vhs.carga(in);
	}

  /* Método que nos da los datos de un VHS.
  * Simplemente mandamos llamar al método que nos da los datos de desde VHS.
  */
	@Override public boolean dameDatos(BufferedReader in) throws IOException {
			return vhs.dameDatos(in);
	}

  /* Método que actualiza un VHS.
  * Simplemente mandamos llamar al método que actualiza desde VHS.
  */
  @Override public void actualiza(Pelicula pelicula) {
			vhs.actualiza(pelicula);
	}

}
