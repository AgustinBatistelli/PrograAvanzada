package codigo;

public class Arista {
	
	private int nodoOrigen;
	private int nodoDestino;
	
	public Arista(int nodoOrigen, int nodoDestino) {
		this.nodoOrigen = nodoOrigen;
		this.nodoDestino = nodoDestino;
	}

	public int getNodoOrigen() {
		return nodoOrigen;
	}

	public int getNodoDestino() {
		return nodoDestino;
	}

	@Override
	public String toString() {
		return "Arista [nodoOrigen=" + nodoOrigen + ", nodoDestino=" + nodoDestino + "]";
	}
	
	
	
}
