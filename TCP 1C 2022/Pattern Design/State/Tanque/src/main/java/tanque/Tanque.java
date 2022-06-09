package tanque;

public class Tanque { //es nuestro Context
	
	private ModoTanque modo = new ModoNormal();
	
	public void atacar() {
		this.modo.atacar();
	}
	
	public void mover() {
		this.modo.mover();
	}
	
	public void cambiarModo() {
		this.modo = this.modo.cambiarModo();
	}

	public static void main(String[] args) {
		Tanque t = new Tanque();
	}
	
}
