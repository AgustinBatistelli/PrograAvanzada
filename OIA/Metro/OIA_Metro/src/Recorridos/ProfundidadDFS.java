package Recorridos;

import java.util.ArrayList;

import Grafos.GrafoNoDirigidoPonderado;

public class ProfundidadDFS {
	
	private static boolean[] estado;

	public boolean[] getEstado() {
		return estado;
	}

	public void setEstado(boolean[] estado) {
		ProfundidadDFS.estado = estado;
	}
	
	public static int[] recorridoEnProfundidad(int nodoIni, GrafoNoDirigidoPonderado grafo) {
		int recorrido[] = new int[grafo.getMatrizAdyacencia().length];
		int indiceRecorrido = 0;
		estado = new boolean [grafo.getMatrizAdyacencia().length];
		ArrayList<Integer> pila = new ArrayList<Integer>();
		estado[nodoIni] = true;
		pila.add(nodoIni);
		while (pila.size()!= 0) {
			int nodoActual = pila.remove(pila.size() - 1);
			recorrido[indiceRecorrido] = nodoActual;
			indiceRecorrido++;
			//System.out.println(nodoActual);
			for(int j = 0; j < grafo.getMatrizAdyacencia().length; j++) {
				if(grafo.getMatrizAdyacencia()[nodoActual][j] != Integer.MAX_VALUE) {
					if(!estado[j]) {
						estado[j] = true;						
						pila.add(j);
					}
				}
			}
			
		}
		return recorrido;
	}
}
