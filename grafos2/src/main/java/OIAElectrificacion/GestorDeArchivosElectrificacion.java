package OIAElectrificacion;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GestorDeArchivosElectrificacion {
	public static Pais cargarPais(String inputPath) {
		Pais pais = null;
		File f = null;
		Scanner sc = null;
		
		try {
			f = new File(inputPath);
			sc = new Scanner(f);
			
			int cantCiudades = sc.nextInt();
			int cantCentrales = sc.nextInt();
			
			pais = new Pais(cantCiudades, cantCentrales);
			
			
			for(int i = 0; i < cantCentrales; i++) {
				int central = sc.nextInt();
				pais.agregarCentral(central - 1);
			}
			for(int i = 0; i < cantCiudades; i++) {
				for(int j = 0; j < cantCiudades; j++) {
					int largoTendido = sc.nextInt();
					pais.agregarTendido(i, j, largoTendido);
				}
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
		
		return pais;
	}
}
