import java.util.ArrayList;

public class Tropa implements Unidad {
	
	private ArrayList<Unidad> arrayUnidades = new ArrayList<Unidad>();
	
	
	public void atacar(Unidad unidad) {
		for(Unidad unidadAtacante : arrayUnidades) {
			unidadAtacante.atacar(unidad);
		}
		
	}

	
	public void recibirAtaque(int ataqueRecibido) {
		int numRandom = (int) Math.floor(Math.random() * arrayUnidades.size());
		Unidad unidadAtacada = arrayUnidades.get(numRandom);
		
		unidadAtacada.recibirAtaque(ataqueRecibido);
		
		if(!unidadAtacada.estaVivo()) {
			arrayUnidades.remove(unidadAtacada);
		}
		
	}

	
	public boolean estaVivo() {
		return arrayUnidades.size() > 0;
	}
	
	public void agregar(Unidad unidad) {
		arrayUnidades.add(unidad);
	}
	
	@Override
	public String toString() {
		return this.arrayUnidades.toString();
	}

}
