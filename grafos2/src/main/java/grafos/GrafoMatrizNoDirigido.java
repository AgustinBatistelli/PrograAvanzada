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
	
	
	
//	public void prim() {
//		HashSet<Integer> V_S = getNodos();
//		HashSet<Integer> solucion = new HashSet<Integer>();
//		ArrayList<Boolean> nodosVisitados = new ArrayList<Boolean>();
//		
//		solucion.add(0);
//		V_S.remove(0);
//		for(int i = 0; i < getCantNodos(); i++) {
//			HashSet<Integer>nodosAdyacentes = getNodosAdyacentes(i);
//			ArrayList<Double> aristasAdyacentes = new ArrayList<Double>();
//			
//			for(Integer nodo : solucion) {
//				for(int j = 0; j < getCantNodos(); j++) {
//					if(matriz[nodo][j] != VALOR_INFINITO) {
//						aristasAdyacentes.add(matriz[nodo][j]);						
//					}
//				}
//			}
//			
//			
//			
//			
//		}
//		
//	}

//	private double obtenerMenorArista(int nodo) {
//		double menor = matriz[nodo][0];
//		
//		for(int i = 1; i < getCantNodos(); i++) {
//			if(matriz[nodo][i] < menor) {
//				menor = matriz[nodo][i];
//			}
//		}
//		
//		return menor;
//	}
	
}
