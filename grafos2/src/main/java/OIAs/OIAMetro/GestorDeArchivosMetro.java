package OIAs.OIAMetro;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GestorDeArchivosMetro {
	public static Ciudad cargarCiudad(String inputPath) {
		Ciudad ciudad = null;
		File f = null;
		Scanner sc = null;
		
		try {
			f = new File(inputPath);
			sc = new Scanner(f);
			
			int cantIslas = sc.nextInt();
			int cantTuneles = sc.nextInt();
			int cantPuentes = sc.nextInt();
			
			ciudad = new Ciudad(cantIslas);
			
			System.out.println("islas: " + cantIslas);
			System.out.println("cantTuneles: " + cantTuneles);
			System.out.println("cantPuentes: " + cantPuentes);
			
			for(int i = 0; i < cantTuneles; i++) {
				int origen = sc.nextInt();
				int destino = sc.nextInt();				
				ciudad.agregarTunel(origen - 1, destino - 1);
			}
			
			for(int i = 0; i < cantPuentes; i++) {
				int origen = sc.nextInt();
				int destino = sc.nextInt();				
				ciudad.agregarPuente(origen - 1, destino - 1);
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(sc != null) {
				sc.close();
			}
		}
		
		return ciudad;
	}
}
