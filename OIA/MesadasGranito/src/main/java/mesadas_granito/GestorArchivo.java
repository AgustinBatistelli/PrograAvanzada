package mesadas_granito;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorArchivo {

	public static NegocioVenta leerArchivo(String path) throws Exception {
		
		Scanner sc = new Scanner(new FileReader(new File(path)));
		
		int cantMesadas = Integer.valueOf(sc.nextLine().trim());
		
		if(cantMesadas > 200000 || cantMesadas < 1)
			throw new Exception("Cantidad de mesas invalidas debido a que son: " + cantMesadas);
		
		List<Mesada> listaMesadas = new ArrayList<Mesada>();
		
		for(int i = 0; i < cantMesadas; i++) {
			
			String linea = sc.nextLine().trim();
			
			String[] datos = linea.split(" ");
			
			if(Integer.valueOf(datos[0]) < 0 || Integer.valueOf(datos[1]) > 1000000)
				throw new Exception("Ancho o largo invalidos");
			
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
