package mesada;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestionArchivo {

	public static Deposito leerArchivo(String rutaNombreArchivo) throws IOException {

		File archivo = new File(rutaNombreArchivo);// Referencia a File.
		FileReader fr = new FileReader(archivo); // Referencia a FileReader.
		Scanner entrada = new Scanner(fr);

		Deposito deposito = null;

		try {

			int valor = 0;
			if (entrada.hasNext())
				valor = entrada.nextInt(); // en este caso no hago nada con el valor de mesadas.. 

			Deposito depositoAux = new Deposito();

			while (entrada.hasNext()) {// Mientras existan datos en el archivo.
				int ancho = entrada.nextInt();
				int largo = entrada.nextInt();
				Mesada mesada = new Mesada(ancho, largo);
				depositoAux.agregarMesada(mesada);
			}
			deposito = depositoAux;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entrada.close();
		}

		return deposito;
		
	}

	public static void escribirArchivo(String path, Deposito deposito) throws IOException {

		File f  = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
				
		try {
			
			f = new File(path);
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
				
			bw.write(deposito.getPilasMin()+"");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			bw.close();
		}
		
	}

}
