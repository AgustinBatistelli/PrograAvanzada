package main;

import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ManejadorArchivos {

	static final String NOMBRE_ARCHIVO_ENTRADA = "mesadas.in";
	static final String NOMBRE_ARCHIVO_SALIDA = "mesadas.out";

	public ArrayList<Mesadas> leerArchivoDeMesadas() throws FileNotFoundException {
		Scanner s = new Scanner(new FileReader(NOMBRE_ARCHIVO_ENTRADA));
		int cantidadMesadas = s.nextInt();
		ArrayList<Mesadas> lista = new ArrayList<>(Collections.emptyList());
		for (int i = 0; i < cantidadMesadas; i++) {
			int tamanioMayor = s.nextInt();
			int tamanioMenor = s.nextInt();
			int aux;
			if (tamanioMenor > tamanioMayor) {
				aux = tamanioMayor;
				tamanioMayor = tamanioMenor;
				tamanioMenor = aux;
			}
			lista.add(new Mesadas(tamanioMayor, tamanioMenor));
		}
		return lista;
	}

	public void escribirResultado(int resultado) throws IOException {

		FileWriter fileWriter = new FileWriter(new File(NOMBRE_ARCHIVO_SALIDA));
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write("" + resultado);
		bufferedWriter.close();
	}
}