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

	public static Sistema leerArchivo(String pathArchivo) throws FileNotFoundException {
		
		
		try (Scanner reader = new Scanner(new FileReader(pathArchivo))) {
			
			int nCiudades=reader.nextInt();
			int nCiudadescs=reader.nextInt();
			int nRutas=reader.nextInt();
			
			ArrayList<Integer> ciudadesConectadas = new ArrayList<Integer>();
			
			Sistema sistema = new Sistema();
			for(int i=0;i<nCiudades;i++) {
				sistema.getCiudades().add(reader.next());
			}
			
			int[][] matrizAdyacencia = new int [nCiudades][nCiudades];
			
			for(int i = 0; i < nCiudades; i++)//COMPLETA MATRIZ CON INFINITOS
				for(int j = 0; j < nCiudades; j++)
					matrizAdyacencia[i][j] = Integer.MAX_VALUE;
			
			for(int i=0;i<nCiudadescs;i++) {
				ciudadesConectadas.add(reader.nextInt());
			}
			for (Integer ciudconec : ciudadesConectadas) {
				for (Integer ciudconec2 : ciudadesConectadas) {
					if(ciudconec!=ciudconec2) {
						matrizAdyacencia[ciudconec-1][ciudconec2-1]=0;
						matrizAdyacencia[ciudconec2-1][ciudconec-1]=0;
					}
				}
			}
			
			for(int i=0;i<nRutas;i++) {
				int index1= sistema.getCiudades().indexOf(reader.next());
				int index2= sistema.getCiudades().indexOf(reader.next());
				int peso = reader.nextInt();
				matrizAdyacencia[index1][index2]=peso;
				matrizAdyacencia[index2][index1]=peso;
			}
			GrafoNoDirigidoPonderado grafo= new GrafoNoDirigidoPonderado(matrizAdyacencia);
			sistema.setGrafo(grafo);
			return sistema;
			}
		}
	
	
	public static void escribirArchivo(String pathArchivoSalida, String resultado) throws IOException {

			BufferedWriter buffer = new BufferedWriter(new FileWriter(new File(pathArchivoSalida)));
			buffer.write(resultado);
			buffer.close();
	}

}
