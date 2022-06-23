package Grafos;

import Algoritmos.Kruskal;
import Algoritmos.Prim;
public class GrafoNoDirigidoPonderado extends Grafo{
	
	public int[][] arbolAbarcadorDeMenorCosto;

	public GrafoNoDirigidoPonderado(int[][] matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
		this.arbolAbarcadorDeMenorCosto = new int[matrizAdyacencia.length][matrizAdyacencia.length];
	}

	public int[][] getArbolAbarcadorDeMenorCosto() {
		return arbolAbarcadorDeMenorCosto;
	}

	public void setArbolAbarcadorDeMenorCosto(int[][] arbolAbarcadorDeMenorCosto) {
		this.arbolAbarcadorDeMenorCosto = arbolAbarcadorDeMenorCosto;
	}
	
	public void mostrarArbolAbarcadorDeMenorCosto() {
		System.out.print("\t");
		for (int i = 0; i < arbolAbarcadorDeMenorCosto.length; i++) {
			System.out.print(i+1 + "\t");
		}
		System.out.println();
		for (int i = 0; i < arbolAbarcadorDeMenorCosto.length; i++) {
			System.out.print(i+1 + "\t");
			for (int j = 0; j < arbolAbarcadorDeMenorCosto.length; j++) {
				if (arbolAbarcadorDeMenorCosto[i][j] != 0) {
					System.out.print(arbolAbarcadorDeMenorCosto[i][j] + "\t");
				} else {
					System.out.print("-\t");
				}
			}
			System.out.println();
		}
	}
	
	public int realizarPrim(int nodoInicial) {
		return Prim.prim(nodoInicial, this);
	}
	
	public int realizarKruskal() {
		return Kruskal.kruskal(this);
	}

}
