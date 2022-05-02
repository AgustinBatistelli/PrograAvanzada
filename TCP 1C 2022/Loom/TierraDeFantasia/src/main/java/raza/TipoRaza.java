package raza;

public abstract class TipoRaza {
	
	protected int vida;
	protected int danioActual;
	protected int posicion;
	
	public abstract void atacar(TipoRaza tipoRaza);
	public abstract void recibirDanio(int danio);
	public abstract void mover(int movimiento);
	public abstract void descansar();
	
	public int getVida() {
		return this.vida;
	}
	public int getDanioActual() {
		return this.danioActual;
	}
	public int getPosicion() {
		return this.posicion;
	}
	
}
