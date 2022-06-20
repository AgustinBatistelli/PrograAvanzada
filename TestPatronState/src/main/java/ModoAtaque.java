
public class ModoAtaque extends TipoModo {
	
	public ModoAtaque() {
		this.nombreModo = "Ataque";
		this.danio = super.danio;
	}

	@Override
	public void handleAtacar(Tanque tanqueAtacado) {
		tanqueAtacado.recibirAtaque(danio);
	}

	@Override
	public double calcularDanioRecibido(double ataqueRecibido) {
		return ataqueRecibido;
		
	}

	
	
	
}
