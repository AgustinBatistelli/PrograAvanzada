package GestorGrafos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import grafos.Grafo;
import grafos.GrafoMatrizAdyacencia;

public class GestorArchivosGrafos {
	
	public static GrafoMatrizAdyacencia cargarGrafo(String inputPath) {
		
		File f = null;
		Scanner sc = null;
		GrafoMatrizAdyacencia grafo = null;
		
		try {
			f = new File(inputPath);
			sc = new Scanner(f);
			
			int cantNodos = sc.nextInt();
			int cantAristas = sc.nextInt();
			grafo = new GrafoMatrizAdyacencia(cantNodos);
			
			for(int i = 0; i < cantAristas; i++) {
				int nodoOrigen = sc.nextInt();
				int nodoDestino = sc.nextInt();
				int valorArista = sc.nextInt();
				
				
				grafo.setArista(nodoOrigen, nodoDestino, valorArista);
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally{
			if(sc != null) {
				sc.close();
			}
		}
		return grafo;
		
	}
}
