package Algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import Grafos.Arista;
import Grafos.GrafoNoDirigidoPonderado;


public class Kruskal {
	
	public static int kruskal(GrafoNoDirigidoPonderado grafo) {
		int costoTotal = 0;
		int[] padres = new int[grafo.getMatrizAdyacencia().length];
		boolean seguir=true;
		inicializarPadres(padres);
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		inicializarAristas(aristas, grafo);
		Collections.sort(aristas);

		Iterator<Arista> it = aristas.iterator();
		while ( seguir && it.hasNext()){
			Arista arista = it.next();
			if (encontrarPadre(arista.getNodo1(), padres) != encontrarPadre(arista.getNodo2(), padres)) {
				padres[encontrarPadre(arista.getNodo1(), padres)] = encontrarPadre(arista.getNodo2(), padres);
				costoTotal += arista.getCosto();
				grafo.getArbolAbarcadorDeMenorCosto()[arista.getNodo1()][arista.getNodo2()] = arista.getCosto();
				grafo.getArbolAbarcadorDeMenorCosto()[arista.getNodo2()][arista.getNodo1()] = arista.getCosto();
			}
			seguir=false; 
			int i=0;
			while(!seguir && i< padres.length -1 ) {
				if(padres[i]!=padres[i+1])
					seguir=true;
				i++;
							
			}
		}
		return costoTotal;
	}

	private static void inicializarAristas(ArrayList<Arista> aristas, GrafoNoDirigidoPonderado grafo) {
		for (int i = 0; i < grafo.getMatrizAdyacencia().length; i++) {
			for (int j = 0; j < i; j++) {
				if (grafo.getMatrizAdyacencia()[i][j] != Integer.MAX_VALUE) {
					aristas.add(new Arista(j, i, grafo.getMatrizAdyacencia()[i][j]));
				}
			}
		}
	}

	private static void inicializarPadres(int[] padres) {
		for (int i = 0; i < padres.length; i++) {
			padres[i] = i;
		}
	}

	private static int encontrarPadre(int nodo, int[] padres){
		return (nodo == padres[nodo] ? nodo : encontrarPadre(padres[nodo], padres));
	}
}
