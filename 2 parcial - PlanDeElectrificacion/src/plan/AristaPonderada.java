package plan;

public class AristaPonderada extends Arista {

	private int costo;

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public AristaPonderada(int nodo1, int nodo2, int costo) {
		super(nodo1, nodo2);
		this.costo = costo;
	}

}