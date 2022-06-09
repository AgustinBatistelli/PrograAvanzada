package pateando.al.arco.oia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GestorArchivo {
	
	public static void escribirArchivo(String path, String resultado) throws IOException {
		
		FileWriter fw = new FileWriter(new File(path));
		PrintWriter pw = new PrintWriter(fw);
		
		pw.print(resultado);
				
		fw.close();
	}

	public static Robot leerArchivo(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		
		return new Robot(new Arco(new Coordenada(sc.nextInt(), sc.nextInt())));
	}

}
