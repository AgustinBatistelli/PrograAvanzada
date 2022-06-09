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
		
		if(cantColgantes < 0 || cantColgantes > 1000)
			throw new Exception("Cantidad de colgantes invalidos");
		
		List<Colgante> listaColgantes = new ArrayList<Colgante>();
		
		for (int i = 0; i < cantColgantes; i++ ) {
			
			int peso = Integer.valueOf(sc.nextLine().trim());
			
			if(peso < 1 || peso > 100)
				throw new Exception("peso invalido de colgante");
			
			Colgante colgante = new Colgante(peso);
			
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
