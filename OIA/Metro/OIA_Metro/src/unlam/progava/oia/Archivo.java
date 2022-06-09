package unlam.progava.oia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Grafos.GrafoNoDirigidoPonderado;

public class Archivo {

	public static Mapa leerArchivo(String pathArchivo) throws FileNotFoundException {

		try (Scanner reader = new Scanner(new FileReader(pathArchivo))) {
			
			ArrayList<Tunel> tuneles = new ArrayList<Tunel>();
			ArrayList<Puente> puentes = new ArrayList<Puente>();
			
			int cantidadIslas = reader.nextInt();
			int cantidadTuneles = reader.nextInt();
			int cantidadPuentes = reader.nextInt();
			
			for(int i = 0; i < cantidadTuneles; i++) {
				tuneles.add(new Tunel(i+1, reader.nextInt(), reader.nextInt()));
			}
			
			for(int i = 0; i < cantidadPuentes; i++) {
				puentes.add(new Puente(i+1, reader.nextInt(), reader.nextInt()));
			}
			
			int[][] matrizAdyacencia = new int[cantidadIslas][cantidadIslas];
			
			for(int i = 0; i < cantidadIslas; i++)//COMPLETA MATRIZ CON INFINITOS
				for(int j = 0; j < cantidadIslas; j++)
					matrizAdyacencia[i][j] = Integer.MAX_VALUE;
			
			//Completar matriz de adyacencia
			for(Tunel tunel : tuneles) {
				matrizAdyacencia[tunel.getOrigen() - 1][tunel.getDestino() - 1] = 0;
				matrizAdyacencia[tunel.getDestino() - 1][tunel.getOrigen() - 1] = 0;
			}
			
			for(Puente puente : puentes) {
				matrizAdyacencia[puente.getOrigen() - 1][puente.getDestino() - 1] = 1;
				matrizAdyacencia[puente.getDestino() - 1][puente.getOrigen() - 1] = 1;
			}
			
			GrafoNoDirigidoPonderado grafo = new GrafoNoDirigidoPonderado(matrizAdyacencia);
			
			return new Mapa(tuneles, puentes, grafo);
			}
		}
	
	
	public static void escribirArchivo(String pathArchivoSalida, int resultado) throws IOException {

			BufferedWriter buffer = new BufferedWriter(new FileWriter(new File(pathArchivoSalida)));
			buffer.write(Integer.toString(resultado));//VER TIPO DE DATO (VER INTEGER.toString(resultado)
			buffer.close();
	}

}
