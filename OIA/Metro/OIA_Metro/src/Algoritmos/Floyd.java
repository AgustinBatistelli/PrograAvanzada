package Algoritmos;

import Grafos.GrafoDirigidoPonderado;

public class Floyd {
	
	public static int[][] floyd(GrafoDirigidoPonderado grafo) {
		
		int[][] matrizAnterior = grafo.getMatrizAdyacencia().clone();
		llenarMatrizAnterior(matrizAnterior);
		int[][] matrizSiguiente = matrizAnterior.clone();
		for (int k = 1; k < matrizAnterior.length; k++) {
			for (int i = 1; i < matrizAnterior.length; i++) {
				for (int j = 1; j < matrizAnterior.length; j++) {
					if (i != k && j != k & j != i) {
						if (hayOtroCamino(matrizAnterior, k, i, j)) {
							matrizSiguiente[i][j] = matrizAnterior[i][k] + matrizAnterior[k][j];
						}
					}
				}
			}
			matrizAnterior = matrizSiguiente;
			matrizSiguiente = matrizAnterior.clone();
		}
		return matrizAnterior;
	}

	private static boolean hayOtroCamino(int[][] matrizAnterior, int k, int i, int j) {
		return matrizAnterior[i][k] != Integer.MAX_VALUE && matrizAnterior[k][j] != Integer.MAX_VALUE
				&& matrizAnterior[i][j] > matrizAnterior[i][k] + matrizAnterior[k][j];
	}

	private static void llenarMatrizAnterior(int[][] matrizAnterior) {
		for (int i = 0; i < matrizAnterior.length; i++) {
			matrizAnterior[i][i] = Integer.MAX_VALUE;
		}
	}
}
