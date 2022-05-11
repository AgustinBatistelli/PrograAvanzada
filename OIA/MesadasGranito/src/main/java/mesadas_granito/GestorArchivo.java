package mesadas_granito;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GestorArchivo {

	public static Deposito leerArchivo(String path) throws Exception {
		
		Scanner sc = new Scanner(new FileReader(new File(path)));
		
		int cantMesadas = sc.nextInt();
				
		Deposito deposito = new Deposito(cantMesadas);
		
		while(sc.hasNext()) {
			deposito.agregarMesada(new Mesada(sc.nextInt(), sc.nextInt()));
		}
		
		sc.close();
		
		return deposito;
	}

	public static void escribirArchivo(String path, int cantPilasMin) throws IOException {
		FileWriter fw = new FileWriter(new File(path));
		PrintWriter pw = new PrintWriter(fw);

		pw.println(cantPilasMin);

		pw.close();
	}

}
