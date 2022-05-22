package unlam.progava.oia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class GestorDeArchivos {
	
	
	
	public static Juego cargarJuego(String pathInput) {
		
		Juego juego = null;
		File f = null;
		Scanner sc = null;
		
		try {
			f = new File(pathInput);
			sc = new Scanner(f);
			
			 int cantNombres,
			 	 cantMaximosRepetidos;
			 
			 
			 cantNombres = sc.nextInt();
			 cantMaximosRepetidos = sc.nextInt();
			 
			 juego = new Juego(cantMaximosRepetidos);
			 
			 
			 while(sc.hasNext()) {
				 String nombrePersona = sc.next();
				 
				 nombrePersona = nombrePersona.substring(0, 1).toUpperCase() + nombrePersona.substring(1).toLowerCase();
				 juego.agregarPersona(new Persona(nombrePersona)); 
			 }
			 
	
		}
		catch(IOException e){
			e.printStackTrace();
			e.getMessage();
			
		}
		finally {
			if(sc != null) {
				sc.close();
			}
		}
	
		return juego;
	
	
	}
	
	public static void escribirSalida(Juego juego, String pathOutput) {
		
		File f = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			f = new File(pathOutput);
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			
			TreeMap<String, Integer> mapaResultados = juego.getMapaResultado();
			
		
			for(String nombre : mapaResultados.keySet()) {
				
				int cant = mapaResultados.get(nombre);
				
				bw.write(nombre +  " " + cant + "\n");

			}
			
			System.out.println("Archivo creado exitosamente");
			
		}
		catch(IOException e) {
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
