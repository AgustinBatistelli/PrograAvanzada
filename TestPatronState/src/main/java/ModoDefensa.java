
public class ModoDefensa extends TipoModo{	
	private double defensa;

	public ModoDefensa() {
		this.nombreModo = "Defensa";
		this.danio = super.danio / 2;
		this.defensa = 5;
	}

	@Override
	public void handleAtacar(Tanque tanqueAtacado) {
		tanqueAtacado.recibirAtaque(danio);	
	}

	@Override
	public double calcularDanioRecibido(double ataqueRecibido) {
		return ataqueRecibido / defensa;
	}



}
