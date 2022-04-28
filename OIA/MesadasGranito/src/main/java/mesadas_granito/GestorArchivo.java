package mesadas_granito;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorArchivo {

	public static NegocioVenta leerArchivo(String path) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileReader(new File(path)));
		
		int cantMesadas = Integer.valueOf(sc.nextLine().trim());
		
		List<Mesada> listaMesadas = new ArrayList<Mesada>();
		
		for(int i = 0; i < cantMesadas; i++) {
			
			String linea = sc.nextLine().trim();
			
			String[] datos = linea.split(" ");
			
			Mesada mesada = new Mesada(Integer.valueOf(datos[0]), Integer.valueOf(datos[1]));
			
			listaMesadas.add(mesada);
		}
		
		NegocioVenta nv = new NegocioVenta(listaMesadas);
		
		return nv;
	}

	public static void escribirArchivo(String path, String resultado) throws IOException {
		FileWriter fw = new FileWriter(new File(path));
		fw.write(resultado);
		fw.close();
	}

}
