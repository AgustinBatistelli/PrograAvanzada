package raza;

public class RazaCorredora extends TipoRaza {
	
	private final int VIDA_INICIAL = 52;
	private final int DANIO_BASE = 58;
	private final int RANGO_MIN = 2;
	private int RANGO_MAX = 5;
	
	public RazaCorredora() {
		this.vida = VIDA_INICIAL;
		this.danioActual = DANIO_BASE;
		this.posicion = RANGO_MIN;
	}

	@Override
	public void atacar(TipoRaza tipoRaza) {
		int distancia = Math.abs(this.posicion - tipoRaza.posicion);
		
		if(distancia < RANGO_MIN || distancia > RANGO_MAX)
			return;
			
		if(this.vida > this.VIDA_INICIAL * 0.75) {
			tipoRaza.recibirDanio(this.danioActual * 2);
		} else {
			tipoRaza.recibirDanio(this.danioActual);
		}
	}

	@Override
	public void recibirDanio(int danio) {
		this.vida -= (1/3 * danio);
		RANGO_MAX += this.vida;
	}

	@Override
	public void mover(int movimiento) {
		if(Math.abs(movimiento) > 10) {
			System.out.println("Movimiento invalido");
			return;
		}

		posicion += movimiento;
	}

	@Override
	public void descansar() {
		this.vida += 0.5 * this.VIDA_INICIAL;
		RANGO_MAX += this.vida;
	}
	
	public int getRangoMax() {
		return this.RANGO_MAX;
	}

}
