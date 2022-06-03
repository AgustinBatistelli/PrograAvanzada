package Recorridos;

import java.util.ArrayList;

import Grafos.GrafoNoDirigidoPonderado;

public class AnchuraBFS {
	
	private static int [] distancia;
	private static int [] padres;
	
	public static int[] recorrerEnAnchura (int nodoIni, GrafoNoDirigidoPonderado grafo) {
		int recorrido[] = new int[grafo.getMatrizAdyacencia().length];
		int indiceRecorrido = 0;
		
		distancia = new int[grafo.getMatrizAdyacencia().length];
		padres = new int [grafo.getMatrizAdyacencia().length];
		llenarVectores();
		ArrayList<Integer> cola = new ArrayList<Integer>();
		distancia[nodoIni]=0;
		padres[nodoIni] = nodoIni;
		cola.add(nodoIni);
		while(cola.size()!= 0) {
			int nodoActual = cola.remove(0);
			recorrido[indiceRecorrido] = nodoActual;
			indiceRecorrido++;
			//System.out.println(nodoActual);
			for(int j = 0; j < grafo.getMatrizAdyacencia().length; j++) {
				if(grafo.getMatrizAdyacencia()[nodoActual][j]!= Integer.MAX_VALUE && distancia[j] == Integer.MAX_VALUE) {

					padres[j]= nodoActual;
						distancia[j] = distancia[nodoActual] + 1;
						cola.add(j);
					
				}
			}
		}
		return recorrido;
	}

	private static void llenarVectores() {
		for(int i = 0; i < distancia.length; i++) {
			distancia[i]=padres[i]=Integer.MAX_VALUE;
			
		}
	}

	public static int[] getDistancia() {
		return distancia;
	}

	public void setDistancia(int[] distancia) {
		AnchuraBFS.distancia = distancia;
	}

	public int[] getPadres() {
		return padres;
	}

	public void setPadres(int[] padres) {
		AnchuraBFS.padres = padres;
	}
	
	

}
