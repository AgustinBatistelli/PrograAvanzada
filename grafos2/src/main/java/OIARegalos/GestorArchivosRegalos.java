package OIARegalos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GestorArchivosRegalos {
	public static MapaLocales cargarMapaLocales(String inputPath) {
		
		MapaLocales mapa = null;
		File f = null;
		Scanner sc = null;
		
		try {
			f = new File(inputPath);
			sc = new Scanner(f);
			
			int cantLocales = sc.nextInt();
			mapa = new MapaLocales(cantLocales);
			
			for(int i = 0; i < cantLocales; i++) {
				int numLocalInicio  = sc.nextInt();
				int numLocalConflicto  = sc.nextInt();
				while(numLocalConflicto != -1) {
					mapa.agregarLocalConflictivo(numLocalInicio - 1 , numLocalConflicto - 1);
					numLocalConflicto  = sc.nextInt();
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
		return mapa;
	}
}
