package grafos;

import java.util.ArrayList;

import Color.Coloreo;
import Color.ColoreoPrimerColor;
import GestorGrafos.GestorArchivosGrafos;
import Orden.Orden;
import Orden.OrdenAleatorio;
import grafos.GrafoMatrizAdyacencia.Arista;

public class MainTest {
	public static void main(String[] args) {
		
		GrafoMatrizNoDirigido grafoMatriz = new GrafoMatrizNoDirigido(5);
		grafoMatriz.setArista(0, 1, 10);
		grafoMatriz.setArista(0, 3, 5);
		grafoMatriz.setArista(1, 2, 12);
		grafoMatriz.setArista(2, 0, 15);
		grafoMatriz.setArista(2, 4, 11);
		grafoMatriz.setArista(3, 4, 1);
		grafoMatriz.setArista(4, 0, 3);
		
		ArrayList<Arista> solucionKruskal= grafoMatriz.kruskal();
		
		double costo = 0;
		for(Arista arista: solucionKruskal) {
			costo += arista.getPeso();
		}
		System.out.println("El costo total es: " + costo);
		
//		grafoMatriz.mostrarMatriz();
//		grafoMatriz.mostrarGrafoBFS(3);
//		grafoMatriz.mostrarGrafoDFS(3);
		
//		GrafoMatrizNoDirigido grafo2 = new GrafoMatrizNoDirigido(4);
//		
//		grafo2.setArista(0, 1, 7);
//		grafo2.setArista(0, 2, 3);
//		grafo2.setArista(1, 3, 2);
//		grafo2.setArista(2, 1, 2);
//		grafo2.setArista(2, 3, 8);
//		
//		grafo2.mostrarMatriz();
//		grafo2.dijkstra(0);
		
		
//		GrafoMatrizNoDirigido grafo3 = new GrafoMatrizNoDirigido(6);
//		GrafoMatrizAdyacencia grafo3 = GestorArchivosGrafos.cargarGrafo("grafoTest.txt");
//		
//		grafo3.mostrarMatriz();
//		
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
		GrafoMatrizNoDirigido grafoKruskal = new GrafoMatrizNoDirigido(6);
		grafoKruskal.setArista(0, 1, 6);
		grafoKruskal.setArista(0, 2, 1);
		grafoKruskal.setArista(0, 3, 5);
		grafoKruskal.setArista(1, 0, 6);
		grafoKruskal.setArista(1, 2, 5);
		grafoKruskal.setArista(1, 4, 3);
		grafoKruskal.setArista(2, 0, 1);
		grafoKruskal.setArista(2, 1, 5);
		grafoKruskal.setArista(2, 3, 5);
		grafoKruskal.setArista(2, 4, 8);
		grafoKruskal.setArista(2, 5, 4);
		grafoKruskal.setArista(3, 0, 5);
		grafoKruskal.setArista(3, 2, 5);
		grafoKruskal.setArista(3, 5, 2);
		grafoKruskal.setArista(4, 1, 3);
		grafoKruskal.setArista(4, 2, 8);
		grafoKruskal.setArista(4, 5, 6);
		grafoKruskal.setArista(5, 2, 4);
		grafoKruskal.setArista(5, 3, 2);
		grafoKruskal.setArista(5, 4, 6);
		
//		grafoKruskal.kruskal();
		
	}
}
