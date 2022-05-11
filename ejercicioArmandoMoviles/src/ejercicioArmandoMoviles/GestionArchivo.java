package ejercicioArmandoMoviles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestionArchivo {

	public static Colgante leerArchivo(String rutaNombreArchivo) throws IOException {

		File archivo = new File(rutaNombreArchivo);// Referencia a File.
		FileReader fr = new FileReader(archivo); // Referencia a FileReader.
		Scanner entrada = new Scanner(fr);

		Colgante colgante = null;

		try {

			int valor = 0;
			if (entrada.hasNext())
				valor = entrada.nextInt();

			Colgante colganteAux = new Colgante(valor);

			while (entrada.hasNext()) {// Mientras existan datos en el archivo.
				int peso = entrada.nextInt();
				colganteAux.agregarColgante(peso);
			}
			colgante = colganteAux;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entrada.close();
		}

		return colgante;

	}

	public static void escribirArchivo(String path, Artesano artesano) throws IOException {

		File f  = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
				
		try {
			
			f = new File(path);
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			
			int pesoTotal = artesano.getPesoTotalColgantes();
			int cantidadVarillas = artesano.getVarillasNecesarias();
				
			bw.write( pesoTotal + " " + cantidadVarillas + "\n");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			bw.close();
		}
		
	}

}
