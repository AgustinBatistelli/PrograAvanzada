package grafos;

import java.util.ArrayList;
import java.util.HashSet;

public class GrafoMatrizNoDirigido extends GrafoMatrizAdyacencia {
	
	
	public GrafoMatrizNoDirigido(int cantNodos) {
		super(cantNodos);
	}


	@Override
	public void setArista(int nodoOrigen, int nodoDestino, double valor) {
		matriz[nodoOrigen][nodoDestino] = valor;
		matriz[nodoDestino][nodoOrigen] = valor;
		
	}
	
}
