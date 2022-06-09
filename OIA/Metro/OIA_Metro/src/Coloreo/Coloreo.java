package Coloreo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Grafos.GrafoNoDirigidoPonderado;

public class Coloreo { ///Devuelve un conjunto de conjuntos de numeros de nodo, el size del conjunto general es la cantidad de colores
	
	public static ArrayList<ArrayList<Integer>> encontrarNroCromatico(int n, GrafoNoDirigidoPonderado grafo){
		ArrayList<ArrayList<Integer>> conjuntos = null;
		int[] nodos = new int[grafo.getMatrizAdyacencia().length];
		for(int i = 0; i < nodos.length; i++) {
			nodos[i] = i;
		}
		for(int i =0; i < n; i++) {
			List<Integer> listaAux = new ArrayList<Integer>();
			copiarALista(nodos, listaAux);
			Collections.shuffle(listaAux);
			copiarAVector(nodos, listaAux);
			ArrayList<ArrayList<Integer>> conjuntosAux = colorearGrafo(nodos, grafo);
			if(conjuntos == null) {
				conjuntos = conjuntosAux;
			} else if(conjuntos.size() > conjuntosAux.size()) {
					conjuntos = conjuntosAux;
			}
		}
		return conjuntos;
	}

	private static void copiarAVector(int[] nodos, List<Integer> listaAux) {
		for(int  j = 0; j < listaAux.size(); j++) {
			nodos[j] = listaAux.get(j);
		}
	}

	private static void copiarALista(int[] nodos, List<Integer> listaAux) {
		for(int j = 0; j < nodos.length; j++) {
			listaAux.add(nodos[j]);
		}
	}
	
	private static ArrayList<ArrayList<Integer>> colorearGrafo(int [] nodos, GrafoNoDirigidoPonderado grafo){
		ArrayList<ArrayList<Integer>> conjuntos = new ArrayList<ArrayList<Integer>>();
		boolean[] pintados = new boolean[nodos.length];
		for(int i = 0; i < nodos.length; i++) {
			int nodo = nodos[i];
			if(!pintados[nodo]) {
				ArrayList<Integer> conjunto = new ArrayList<Integer>();
				conjunto.add(nodo);
				for(int j = 0; j < grafo.getMatrizAdyacencia().length; j++) {
					if(!pintados[j] && !esAdyacente(j,conjunto, grafo) && nodo != j) {
						conjunto.add(j);
						pintados[j] = true;
					}
				}				
				conjuntos.add(conjunto);
			}
		}
		return conjuntos;
	}

	private static boolean esAdyacente(int nodoAux, ArrayList<Integer> conjunto, GrafoNoDirigidoPonderado grafo) {
		for(int i = 0; i < conjunto.size(); i++) {
			int nodo = conjunto.get(i);
			if(grafo.getMatrizAdyacencia()[nodo][nodoAux] != Integer.MAX_VALUE) {
				return true;
			}
		}
		return false;
	}

}
