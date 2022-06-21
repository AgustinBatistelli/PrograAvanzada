package grafos;

public class Adyacencia implements Comparable<Adyacencia> {
	int origen, destino, peso;

	public Adyacencia(int destino, int peso) {
		this.destino = destino;
		this.peso = peso;
	}

	public Adyacencia(int origen, int destino, int peso) {
		this.origen = origen;
		this.destino = destino;
		this.peso = peso;
	}

	public int getDestino() {
		return destino;
	}

	public int getPeso() {
		return peso;
	}

	public int getOrigen() {
		return origen;
	}

	@Override
	public int compareTo(Adyacencia o) {
		return this.peso - o.peso;
	}

	@Override
	public String toString() {
		return "[origen=" + origen + ", destino=" + destino + ", peso=" + peso + "]";
	}

}
