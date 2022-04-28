package armando.moviles;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorArchivos {

	public static Artesano leerArchivo(String path) throws Exception {

		Scanner sc = new Scanner(new FileReader(new File(path)));
		
		int cantColgantes = Integer.valueOf(sc.nextLine().trim());
		
		List<Colgante> listaColgantes = new ArrayList<Colgante>();
		
		for (int i = 0; i < cantColgantes; i++ ) {
			
			Colgante colgante = new Colgante(Integer.valueOf(sc.nextLine().trim()));
			
			listaColgantes.add(colgante);
			
		}
		
		Artesano artesano = new Artesano(listaColgantes);
		
		return artesano;
	}

	public static void escribirArchivo(String path, String resultado) throws Exception {
		FileWriter fw = new FileWriter(new File(path));
		fw.write(resultado);
		fw.close();
	}

}
