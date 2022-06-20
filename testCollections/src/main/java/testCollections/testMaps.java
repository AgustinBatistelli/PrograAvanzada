package testCollections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import testCollections.Persona;

public class testMaps {
	public static void main(String[] args) {
		TreeMap<String, Integer> mapaPalabras = new TreeMap<String, Integer>();
//		LinkedHashMap<String, Integer> mapaPalabras = new LinkedHashMap<String, Integer>();
		
		String texto = "hola este es mi texto, diria hola de nuevo pero estoy con mi perro y no quiere";
				
		String[] arrPalabras = texto.split(" ");	
				
		for(String palabra : arrPalabras) {
			if(mapaPalabras.containsKey(palabra)) {
				int cantRepes = mapaPalabras.get(palabra); 
				mapaPalabras.put(palabra, cantRepes + 1);
			}
			else {
				mapaPalabras.put(palabra, 1);
			}
		}
				
		
		for(String palabra : mapaPalabras.keySet()) {
			System.out.println(palabra + ": " +  mapaPalabras.get(palabra));
		}			
		
	}
}
