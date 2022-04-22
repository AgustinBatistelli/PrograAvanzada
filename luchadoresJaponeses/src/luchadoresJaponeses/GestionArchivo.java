package luchadoresJaponeses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestionArchivo {

	public static Torneo leerArchivo(String rutaNombreArchivo) throws IOException {

		File archivo = new File(rutaNombreArchivo);// Referencia a File.
		FileReader fr = new FileReader(archivo); // Referencia a FileReader.
		Scanner entrada = new Scanner(fr);

		Torneo torneo = null;

		try {

			int valor = 0;
			if (entrada.hasNext())
				valor = entrada.nextInt();

			Torneo torneoAux = new Torneo(valor);

			while (entrada.hasNext()) {// Mientras existan datos en el archivo.
				int peso = entrada.nextInt();
				int altura = entrada.nextInt();
				Luchador luchador = new Luchador(peso, altura);
				torneoAux.agregarLuchador(luchador);
			}
			torneo = torneoAux;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entrada.close();
		}

		return torneo;

	}

	public static void escribirArchivo(String path, Torneo torneo) throws IOException {

		File f  = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
				
		try {
			
			f = new File(path);
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			
			int []array = torneo.getArrayDomina();
			
			for (int i = 0; i< array.length  ; i++) {
				
				bw.write( array[i] + "\n");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			bw.close();
		}
		
	}

}
