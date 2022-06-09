package raza;

public class RazaGolim extends TipoRaza {

	private int VIDA_INICIAL = 471;
	private final int DANIO_BASE = 121;
	private final int RANGO_MIN = 0;
	private final int RANGO_MAX = 8;
	private int cantAtaquesConsecutivos;
	private boolean fueAtacado;
	private boolean descansado;
	
	public RazaGolim() {
		this.vida = VIDA_INICIAL;
		this.danioActual = DANIO_BASE;
		this.posicion = RANGO_MIN;
		this.cantAtaquesConsecutivos = 0;
		this.fueAtacado = false;
		this.descansado = false;
	}

	@Override
	public void atacar(TipoRaza tipoRaza) {
		
		if(this.fueAtacado) {
			int distancia = Math.abs(this.posicion - tipoRaza.posicion);
			
			if(distancia < RANGO_MIN || distancia > RANGO_MAX)
				return;
			
			if(cantAtaquesConsecutivos != 0 && !descansado)
				tipoRaza.recibirDanio(this.danioActual * (20 * cantAtaquesConsecutivos / 100) );
			else
				tipoRaza.recibirDanio(this.danioActual);
			
			cantAtaquesConsecutivos++;
		}
	}

	@Override
	public void recibirDanio(int danio) {
		cantAtaquesConsecutivos = 0;
		this.vida -= danio * 2;
		this.fueAtacado = true;
	}

	@Override
	public void mover(int movimiento) {
		this.posicion += movimiento / 2;
	}

	@Override
	public void descansar() {
		this.VIDA_INICIAL += 0.9;
		this.VIDA_INICIAL += 146;
	}

}
