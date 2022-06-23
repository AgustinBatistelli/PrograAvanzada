package codigo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ArchivoElectrificacion {

	public static Grafo cargarEntrada(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		int cantDeNodos = sc.nextInt();
		int cantDeCentrales = sc.nextInt();
		List<Integer> listaCentrales = new LinkedList<>();
		
		if(cantDeNodos == 0 || cantDeCentrales ==0){
			sc.close();
			return new Grafo(0, null);
		}
		
		for (int i = 0; i < cantDeCentrales; i++) {
			listaCentrales.add(sc.nextInt() - 1);
		}

		Grafo grafo = new Grafo(cantDeNodos, listaCentrales);
		sc.nextInt();

		for (int i = 0; i < cantDeNodos; i++) {
			for (int j = 0; j < i; j++) {
				grafo.setValor(i, j, sc.nextInt());
			}
			sc.nextLine();
		}

		sc.close();

		return grafo;
	}

	public static void escribirSalida(String path, SalidaElectrificacion salida) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(path));

		if (salida.getTendidos() == null) {
			pw.println(0);

		} else {

			pw.println(salida.getCosto());

			for (Arista a : salida.getTendidos()) {
				pw.println((a.getNodoOrigen() + 1) + " " + (a.getNodoDestino() + 1));
			}

		}
		pw.close();

	}
}
