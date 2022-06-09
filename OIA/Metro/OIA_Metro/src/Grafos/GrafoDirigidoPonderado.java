package Grafos;

import java.util.ArrayList;

import Algoritmos.Dijkstra;
import Algoritmos.Floyd;
import Algoritmos.Warshall;

public class GrafoDirigidoPonderado extends Grafo{ ///TIPO DE GRAFO DE DIJKSTRA, FLOYD, WARSHALL
	
	private int [] padres; //Se utiliza para reconstruir el camino con el menor costo en Dijkstra
	
	public GrafoDirigidoPonderado(int [][] matriz) { //ALGORITMO DE DIJKSTRA
		this.matrizAdyacencia = matriz;
		this.padres = new int[matriz.length];
	}
	
	
	///ALGORITMO DE DIJKSTRA
	public int[] getPadres() {
		return padres;
	}

	public void setPadres(int[] padres) {
		this.padres = padres;
	}

	public int[] realizarDijkstra(int nodoInicial) {
		return Dijkstra.dijkstra(nodoInicial, this);
	}
	
	public int[] realizarDijkstraConCamino(int nodoInicial) {
		return Dijkstra.dijkstraConCamino(nodoInicial, this);
	}
	
	public ArrayList<Integer> reconstruirCaminoDijkstra(int nodoFinal){
		return Dijkstra.reconstruirCamino(nodoFinal, this);
	}
	///FIN ALGORITMO DE DIJKSTRA
	
	///ALGORITMO DE FLOYD
	public int[][] realizarFloyd(){
		return Floyd.floyd(this);
	}
	///FIN ALGORITMO DE FLOYD
	
	///ALGORITMO DE WARSHALL
	public boolean[][] realizarWarshall(){
		return Warshall.warshall(this);
	}
	
}
