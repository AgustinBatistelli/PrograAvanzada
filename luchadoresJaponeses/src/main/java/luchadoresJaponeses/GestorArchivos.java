package luchadoresJaponeses;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestorArchivos {
	
	public GestorArchivos() {
		
	}
	
	public static void escribirArchivo(Torneo torneo, String pathSalida) throws IOException{
		File f = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			f = new File(pathSalida);
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			
			for(int i  = 0; i < torneo.arrDomina.length; i++) {
				bw.write(torneo.arrDomina[i] + "\n");
			}
			
			bw.close();
			System.out.println("Archivo de salida creado correctamente");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Torneo leerArchivo(String path) throws IOException {
		
		File f = null;
		Scanner sc = null;
		Torneo torneo = null;
		
		try {
			f = new File(path);
			sc = new Scanner(f);	
			
			int cantLuchadores = sc.nextInt();
			Torneo torneoAux = new Torneo(cantLuchadores);
			
			
			for(int i = 0; i < cantLuchadores; i++) {
				Luchador luchador = new Luchador(sc.nextInt(), sc.nextInt());
				torneoAux.agregarLuchador(luchador);
			}
			
			torneo = torneoAux;
			sc.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return torneo;
	}
	
}
