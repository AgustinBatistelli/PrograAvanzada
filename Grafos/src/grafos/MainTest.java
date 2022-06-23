package grafos;

import gestorArchivos.GestorDeArchivos;

public class MainTest {
	public static void main(String[] args) {
		
//		GrafoMatrizNoDirigido grafoMatriz = new GrafoMatrizNoDirigido(5);
//		grafoMatriz.setArista(0, 1, 10);
//		grafoMatriz.setArista(0, 3, 5);
//		grafoMatriz.setArista(1, 2, 12);
//		grafoMatriz.setArista(2, 0, 15);
//		grafoMatriz.setArista(2, 4, 11);
//		grafoMatriz.setArista(3, 4, 1);
//		grafoMatriz.setArista(4, 0, 3);
//		grafoMatriz.setArista(0, 4, 1);
//
		//Grafo disjunto ...
//		grafoMatriz.setArista(0, 1, 10);
//		grafoMatriz.setArista(0, 3, 5);
//		grafoMatriz.setArista(1, 2, 12);
//		grafoMatriz.setArista(2, 0, 15);
//		grafoMatriz.setArista(3, 4, 100);
//		
//		grafoMatriz.mostrarMatriz();
//		grafoMatriz.mostrarGrafoBFS(3);
//		grafoMatriz.mostrarGrafoDFS(3);
//		
//		grafoMatriz.Prim();
//		System.out.println();
//		grafoMatriz.primMIO();
		
		
		
		
//		GrafoMatrizNoDirigido grafo2 = new GrafoMatrizNoDirigido(4);
//		GrafoMatrizAdyacencia grafo2 = new GrafoMatrizAdyacencia(4);
//		
//		grafo2.setArista(0, 1, 7);
//		grafo2.setArista(0, 2, 3);
//		grafo2.setArista(1, 3, 2);
//		grafo2.setArista(2, 1, 2);
//		grafo2.setArista(2, 3, 8);
//		
//		grafo2.mostrarMatriz();
//		grafo2.dijkstra(0);
		
		GrafoMatrizAdyacencia grafoFloyd = new GrafoMatrizAdyacencia(4);
		
		grafoFloyd.setArista(0, 1, 2);
		grafoFloyd.setArista(0, 2, 5);
		grafoFloyd.setArista(0, 3, 9);
		grafoFloyd.setArista(1, 3, 4);
		grafoFloyd.setArista(2, 0, 5);
		grafoFloyd.setArista(2, 1, 1);
		grafoFloyd.setArista(3, 2, 5);
		
		grafoFloyd.floyd();
		
		System.out.println();
		
		GrafoMatrizAdyacencia grafoWarshall = new GrafoMatrizAdyacencia(4);
		
		grafoWarshall.setArista(0, 1, 2);
		grafoWarshall.setArista(0, 2, 5);
		grafoWarshall.setArista(0, 3, 9);
		grafoWarshall.setArista(1, 3, 4);
		grafoWarshall.setArista(2, 0, 5);
		grafoWarshall.setArista(2, 1, 1);
		grafoWarshall.setArista(3, 2, 5);
		
		grafoWarshall.warshall();
		
		
//		GrafoMatrizNoDirigido grafo3 = new GrafoMatrizNoDirigido(6);
//		GrafoMatrizAdyacencia grafo3 = GestorDeArchivos.cargarGrafo("grafoTest.txt");
//		
//		grafo3.mostrarMatriz();
		
//		grafo3.setArista(0, 3, 1);
//		grafo3.setArista(0, 5, 1);
//		grafo3.setArista(1, 3, 1);
//		grafo3.setArista(1, 4, 1);
//		grafo3.setArista(2, 3, 1);
//		grafo3.setArista(2, 5, 1);
//		grafo3.setArista(3, 0, 1);
//		grafo3.setArista(3, 1, 1);
//		grafo3.setArista(3, 2, 1);
//		grafo3.setArista(4, 1, 1);
//		grafo3.setArista(4, 3, 1);
//		grafo3.setArista(5, 0, 1);
//		grafo3.setArista(5, 2, 1);
//	

//		Orden orden = new OrdenAleatorio().generarOrden(grafo3);
//		Coloreo coloreoMinimo = new ColoreoPrimerColor().colorear(grafo3, orden);
//		
//		for(int i = 0; i < 10000; i++) {
//			Orden ordenNuevo = new OrdenAleatorio().generarOrden(grafo3);
//			Coloreo coloreoNuevo = new ColoreoPrimerColor().colorear(grafo3, ordenNuevo);
//			if(coloreoNuevo.getCantColores() < coloreoMinimo.getCantColores()) {
//				coloreoMinimo = coloreoNuevo;
//			}
//		}
//		coloreoMinimo.imprimirColores();
//		
		
		
	}
}
