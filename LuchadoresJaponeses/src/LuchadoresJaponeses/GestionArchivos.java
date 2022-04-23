package LuchadoresJaponeses;

import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;

public class GestionArchivos {
		
		static public int[] crearTorneo(String ruta) {
			try {
				Scanner file = new Scanner(new File(ruta));

				Torneo torneo = new Torneo(file.nextInt());
				
				while(file.hasNext()) {
					Luchador luchador = new Luchador(file.nextInt(), file.nextInt());
					torneo.agregarLuchador(luchador);					
				}
				
				int[] dominados = torneo.calcularDuelos();
				
				for (int i = 0; i < dominados.length; i++) {
					System.out.println(dominados[i]);
				}
				
				file.close();
				return dominados;
				
				
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}			
		}
		
		
		static public void escribirSalida(String path, int[]resultados) {
			FileWriter archivo = null;
			PrintWriter pw = null;
			try {
				archivo = new FileWriter(path);
				pw = new PrintWriter(archivo);
				
				for(int resultado : resultados) 
					pw.println(resultado);
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if (null != archivo) 					
						archivo.close();
				}
				catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
		
}
