package admin_archivos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import luchadores_japoneses.LuchadorJapones;
import torneo.Torneo;

public class GestorArchivos {

	public Torneo leerArchivo(String name) throws Exception {
		
		Scanner sc = new Scanner(new FileReader("luchadoresJaponeses.in"));
		
		Torneo torneo = new Torneo();
		
		while(sc.hasNext()) {
			
			int cantLuchadores = Integer.valueOf(sc.nextLine().trim());
			
			if (cantLuchadores < 1 || cantLuchadores > 100000)
				throw new Exception("Cantidad de luchadores no admitida.");
			
			LuchadorJapones[] luchadoresJaponeses = new LuchadorJapones[cantLuchadores];
			
			for(int i = 0; i < cantLuchadores; i++) {
				
				String linea = sc.nextLine();
				
				String[] datos = linea.split(" ");
				
				if(Integer.valueOf(datos[0]) < 0 || Integer.valueOf(datos[1]) > 1000000)
					throw new Exception("Peso o altura del luchador no admitidos.");
				
				luchadoresJaponeses[i] = new LuchadorJapones(Integer.valueOf(datos[0]), Integer.valueOf(datos[1]));
				
				torneo.getLuchadores().add(luchadoresJaponeses[i]);
			}
			
		}
		
		
		
		return torneo;
		
	}

	public int[] escribirArchivo(String nombreArch, int[] resultado) throws Exception {
		
		PrintWriter pw = null;
		
		try {
			
			pw = new PrintWriter(new FileWriter(nombreArch));
			
			for(int i = 0; i < resultado.length; i++) {
				pw.println(resultado[i]);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(pw != null)
				pw.close();
		}
		
		return resultado;
		
		
		
		
	}
	
}
