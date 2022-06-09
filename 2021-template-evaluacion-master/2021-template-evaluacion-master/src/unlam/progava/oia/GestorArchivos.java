package unlam.progava.oia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestorArchivos {
	public static JuegoPreguntas cargarJuegoPreguntas(String pathInput) {
		
		JuegoPreguntas juego = null;
		File f = null;
		Scanner sc = null;
		
		try {
			f = new File(pathInput);
			sc = new Scanner(f);
			
			int cantPreguntas = sc.nextInt();
			int cantColaboradores = sc.nextInt();
			juego = new JuegoPreguntas(cantPreguntas, cantColaboradores);
			
			while(sc.hasNext()) {
				String respuesta = sc.next();
				juego.agregarRespuesta(respuesta);
			}
			
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
			e.getMessage();
		}
		finally{
			if(sc != null) {
				sc.close();
			}
		}
		
		
		return juego;
	}
	
	public static void escribirSalida(JuegoPreguntas juego, String pathOutput) {
		
		File f = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			f = new File(pathOutput);
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			
			String respuestaMax = juego.getRespuestaMax();
			int puntajeMax = juego.getPuntajeMax();
			
			bw.write(puntajeMax + "\n");
			bw.write(respuestaMax);

			
		}
		catch(IOException e ) {
			e.printStackTrace();
			e.getMessage();
		}
		finally {
			if(bw != null) {
				try {
					bw.close();
				}
				catch(IOException e) {
					e.printStackTrace();
					e.getMessage();
				}
			}
		}
		
	}
}
