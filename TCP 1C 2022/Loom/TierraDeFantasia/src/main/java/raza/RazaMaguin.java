package raza;

public class RazaMaguin extends TipoRaza {

	private final int VIDA_INICIAL = 132;
	private final int DANIO_BASE = 63;
	private final int RANGO_MIN = 0;
	private final int RANGO_MAX = 30;

	private boolean descansado;

	public RazaMaguin() {
		this.vida = VIDA_INICIAL;
		this.danioActual = DANIO_BASE;
		this.posicion = RANGO_MIN;
		this.descansado = false;
	}

	@Override
	public void atacar(TipoRaza tipoRaza) {

		int distancia = Math.abs(this.posicion - tipoRaza.posicion);
		
		if(distancia > RANGO_MAX)
			return;
			
		this.vida += Math.ceil((VIDA_INICIAL * 0.3));

		if(this.vida > VIDA_INICIAL)
			this.vida = VIDA_INICIAL;

		tipoRaza.recibirDanio(this.danioActual);

		if(this.descansado) {
			this.danioActual = DANIO_BASE;
			this.descansado = !this.descansado;
		}
	}

	@Override
	public void recibirDanio(int danio) {
		this.vida -= danio;
		this.danioActual += 21;
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
		descansado = true;
		this.danioActual *= 3;
	}

}
