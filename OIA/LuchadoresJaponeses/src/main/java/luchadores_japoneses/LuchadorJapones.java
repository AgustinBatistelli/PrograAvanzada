package luchadores_japoneses;

public class LuchadorJapones {

	private int peso;
	private int altura;
	private int dominaciones;

	public LuchadorJapones(int p, int h) {
		peso = p;
		altura = h;
		setDominaciones(0);
	}

	public boolean domina(LuchadorJapones otro) {
		return ((this.peso > otro.peso && this.altura > otro.altura) 
				|| (this.peso == otro.peso && this.altura > otro.altura) 
				|| (this.peso > otro.peso && this.altura == otro.altura));
	}

	public int getDominaciones() {
		return dominaciones;
	}

	public void setDominaciones(int dominaciones) {
		this.dominaciones = dominaciones;
	}
	
	
}
