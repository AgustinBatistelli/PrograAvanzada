package grafos;

public class GrafoMatirzNoDirigido extends GrafoMatrizAdyacencia{

	public GrafoMatirzNoDirigido(int cantNodos) {
		super(cantNodos);
	}
	
	@Override
	public void setArista(int nodoOrigen, int nodoDestino, double valor) {
		matriz[nodoOrigen][nodoDestino] = valor;
		matriz[nodoDestino][nodoOrigen] = valor;
	}
	
}
