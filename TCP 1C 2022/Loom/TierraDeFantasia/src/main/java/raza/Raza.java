package raza;

public class Raza {
	
	private TipoRaza tipoRaza;
		
	public void atacar(TipoRaza tR) {
		this.tipoRaza.atacar(tR);
	}
	
	public void recibirDanio(int danio) {
		this.tipoRaza.recibirDanio(danio);
	}
	
	public void mover(int movimiento) {
		this.tipoRaza.mover(movimiento);
	}
	
	public void descansar() {
		this.tipoRaza.descansar();
	}
	
	public int getVida() {
		return this.tipoRaza.getVida();
	}

}
