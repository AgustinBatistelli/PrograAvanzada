
public class Guerrero implements Unidad {
	private int vida = 100,
			danio = 10;

	
	public void atacar(Unidad unidad) {
		if(unidad.estaVivo())
			unidad.recibirAtaque(danio);
		
	}

	
	public void recibirAtaque(int ataqueRecibido) {
		vida -= ataqueRecibido;
	}

	
	public boolean estaVivo() {
		return vida > 0;
	}

	
	public String toString() {
		return "Guerrero [vida=" + vida + ", danio=" + danio + "]";
	}

	
	
}

