package raza;

public class RazaAguilera extends TipoRaza {
	
	private final int VIDA_INICIAL = 203;
	private final int DANIO_BASE = 140;
	private int daniosRecibidos;

	public RazaAguilera() {
		this.vida = VIDA_INICIAL;
		this.danioActual = DANIO_BASE;
		this.posicion = 0;
		this.daniosRecibidos = 0;
	}

	@Override
	public void atacar(TipoRaza tipoRaza) {
		int distancia = Math.abs(this.posicion - tipoRaza.posicion);
		
		tipoRaza.recibirDanio(this.danioActual - (2 * distancia));
	}

	@Override
	public void recibirDanio(int danio) {
		
		if(daniosRecibidos != 0) {
			this.vida -= danio * (10 * daniosRecibidos / 100);
		}
		
		this.vida -= danio;
		
		daniosRecibidos++;
	}

	@Override
	public void mover(int movimiento) {
		this.posicion += movimiento * 3;
	}

	@Override
	public void descansar() {
		this.vida = VIDA_INICIAL;
	}

}
