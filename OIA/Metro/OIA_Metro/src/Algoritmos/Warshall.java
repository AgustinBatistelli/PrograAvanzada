package Algoritmos;

import Grafos.GrafoDirigidoPonderado;

public class Warshall {
	
	public static boolean[][] warshall(GrafoDirigidoPonderado grafo){
		boolean [][] matrizAnterior = cargarMatrizBooleana(grafo);
		boolean [][] matrizSiguiente = matrizAnterior.clone();
		for(int k = 0; k < matrizAnterior.length; k++) {
			for(int i = 0; i < matrizAnterior.length; i++) {
				for(int j = 0; j < matrizAnterior.length; j++) {
					if(i!=k && j!=k && i!=j) {
						matrizSiguiente[i][j] = matrizAnterior[i][j] || (matrizAnterior[i][k] && matrizAnterior[k][j]); 
					}
				}
			}
			matrizAnterior = matrizSiguiente;
			matrizSiguiente = matrizAnterior.clone();
		}
		return matrizAnterior;
	}

	private static boolean[][] cargarMatrizBooleana(GrafoDirigidoPonderado grafo) {
		boolean [][]matriz = new boolean [grafo.getMatrizAdyacencia().length][grafo.getMatrizAdyacencia().length];
		for(int i = 0; i < grafo.getMatrizAdyacencia().length; i++) {
			for(int j =0; j < grafo.getMatrizAdyacencia().length; j++) {
				if(grafo.getMatrizAdyacencia()[i][j] != Integer.MAX_VALUE) {
					matriz[i][j] = true;
				} else {
					matriz[i][j] = false;
				}
			}
		}
		return matriz;
	}

}
