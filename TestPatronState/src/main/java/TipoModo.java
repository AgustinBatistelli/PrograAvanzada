
public abstract class TipoModo {
	
	protected double danio = 10;
	protected String nombreModo;
	
	abstract public void handleAtacar(Tanque tanqueAtacado);
	abstract public double calcularDanioRecibido(double ataqueRecibido);
//	
//	@Override
//	public String toString() {
//		return nombreModo;
//	}
}
