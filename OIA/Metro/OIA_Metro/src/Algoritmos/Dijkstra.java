package Algoritmos;

import java.util.ArrayList;

import Grafos.GrafoDirigidoPonderado;

public class Dijkstra {
	
	private static int buscarMenorNodo(int[] d,ArrayList<Integer> s) {
		int menorValor = Integer.MAX_VALUE;
		int menorPos = 0;
		for (int i = 0; i < d.length; i++) {
			if (d[i] < menorValor && !existe (i,s)) {
				menorValor = d[i];
				menorPos = i;
			}
		}
		return menorPos;
	}

	/*
	 * Valida que un nodo no se encuentre en S
	 */
	
	private static boolean existe(int nodo, ArrayList<Integer> s) {
		for (Integer valor : s) {
			if (valor.equals(nodo)) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean existeOtroCamino(int[] costos, int nodoIntermedio, int nodoFin, int[][] matrizAdyacencia) {
		return costos[nodoIntermedio] != Integer.MAX_VALUE && matrizAdyacencia[nodoIntermedio][nodoFin] != Integer.MAX_VALUE
				&& costos[nodoFin] > costos[nodoIntermedio] + matrizAdyacencia[nodoIntermedio][nodoFin];
	}

	
	
	public static int[] dijkstra(int nodoIni, GrafoDirigidoPonderado grafo) {
		int[] costos = grafo.getMatrizAdyacencia()[nodoIni-1]; //el nodo 1 sería la posicion cero
		ArrayList<Integer> conjuntoSolucion = new ArrayList<Integer>();
		conjuntoSolucion.add(nodoIni-1);
		while (conjuntoSolucion.size() < grafo.getMatrizAdyacencia().length) {
			int nodoMenorCosto = buscarMenorNodo(costos,conjuntoSolucion);
			conjuntoSolucion.add(nodoMenorCosto);
			
			for (int i = 0; i < costos.length; i++) {
				if (!existe(i, conjuntoSolucion) && existeOtroCamino(costos, nodoMenorCosto, i, grafo.getMatrizAdyacencia())) {				
						costos[i] = costos[nodoMenorCosto] + grafo.getMatrizAdyacencia()[nodoMenorCosto][i];					
				}
			}

		}
		return costos;
	}
	
	public static int[] dijkstraConCamino(int nodoIni, GrafoDirigidoPonderado grafo) {
		int primerNodo=nodoIni-1;
		int[] costos = grafo.getMatrizAdyacencia()[primerNodo];
		for (int i = 0; i < grafo.getPadres().length; i++) {
			grafo.getPadres()[i] = -1; /// 0 0 0 0 0
		}
		ArrayList<Integer> conjuntoSolucion = new ArrayList<Integer>();
		conjuntoSolucion.add(nodoIni-1);
		
		while (conjuntoSolucion.size() < grafo.getMatrizAdyacencia().length) {
				int menorNodo = buscarMenorNodo(costos,conjuntoSolucion);
						
			conjuntoSolucion.add(menorNodo);
			  if(grafo.getPadres()[menorNodo] == -1)
				 grafo.getPadres()[menorNodo] = nodoIni-1;
			for (int i = 0; i < costos.length; i++) {
				if (!existe(i, conjuntoSolucion) && existeOtroCamino(costos, menorNodo, i, grafo.getMatrizAdyacencia() )) {					
						costos[i] = costos[menorNodo] + grafo.getMatrizAdyacencia()[menorNodo][i];
						grafo.getPadres()[i] = menorNodo;  
					
				}
			}

		}
		return costos;
	}
	
	public static  ArrayList<Integer> reconstruirCamino (int nodoFin, GrafoDirigidoPonderado grafo) {
		int i = nodoFin -1 ;
		ArrayList<Integer> solucion = new ArrayList<Integer>();
		solucion.add(nodoFin); /// 5 
		while (grafo.getPadres()[i] != -1) {
			i = grafo.getPadres()[i];
			solucion.add(i + 1);
		}
		return solucion;
	}

}
