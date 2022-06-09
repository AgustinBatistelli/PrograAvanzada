package composite;

public class Guerrero implements Unidad {

	private int salud = 100;

	public void atacar(Unidad otro) {
		if(estaVivo())
			otro.recibir(10);
	}

	public void recibir(int danio) {
		if(estaVivo())
			this.salud  -= danio;
	}

	public boolean estaVivo() {
		return this.salud > 0;
	}

}
