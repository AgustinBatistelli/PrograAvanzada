
public class Tanque {
	private double salud = 100;
	

	private TipoModo modo = new ModoAtaque();
	
	public void cambiarModo(TipoModo modo) {
		this.modo = modo;
	}
	
	public void atacar(Tanque tanque) {
		modo.handleAtacar(tanque);
	}
	
	public void recibirAtaque(double ataqueRecibido) {
		double danioRecibido = modo.calcularDanioRecibido(ataqueRecibido);
		this.salud -= danioRecibido;
	}

	@Override
	public String toString() {
		return "Tanque [salud=" + salud + ", modo="  + modo + "]";
	}
	
}
