package composite;

import java.util.LinkedList;
import java.util.List;

public class Tropa implements Unidad {
	
	private List<Unidad> unidades = new LinkedList<Unidad>();

	public void atacar(Unidad otro) {
		// TODO Auto-generated method stub
		
	}

	public void recibir(int danio) {
		// TODO Auto-generated method stub
		
	}

	public boolean estaVivo() {
			
		for(Unidad unidad : unidades) {
			if(unidad.estaVivo())
				return true;
		}
		
		return false;
	}

}
