package unlam.progava.oia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Juego {
	private ArrayList<Persona> personas = new ArrayList<Persona>();
	private HashMap<String, Integer> mapaPersonas = new HashMap<String, Integer>();
	private TreeMap<String, Integer> mapaResultado = new TreeMap<String, Integer>();
	private int cantMaximos;
	
	public TreeMap<String, Integer> getMapaResultado() {
		
		TreeMap<String, Integer> mapaCopia = new TreeMap<String, Integer>();
		
		for(String nombre : mapaResultado.keySet()) {
			int cant = mapaResultado.get(nombre);
			mapaCopia.put(nombre, cant);
		}
		return mapaCopia;
	}

	
	
	public Juego(int cantMaximos) {
		this.cantMaximos = cantMaximos;
	}
	
	public void agregarPersona(Persona persona) {
		personas.add(persona);
	}
	
	 
	
	public void calcularNombresRepetidos(){
		
		for(Persona persona : personas) {
			String nombrePersona = persona.getNombre();
			
			if(!mapaPersonas.containsKey(nombrePersona)) {
				mapaPersonas.put(nombrePersona, 1);
			}
			else {
				int cantRepetidos = mapaPersonas.get(nombrePersona);
				cantRepetidos++;
				mapaPersonas.put(nombrePersona, cantRepetidos);
			}	
		}
		

		
		int tamanioMapa = mapaPersonas.size();

		int iteracionesMaximas = cantMaximos > tamanioMapa ? tamanioMapa : cantMaximos;
		
		for(int i = 0; i < iteracionesMaximas; i++) {
			int max = 0;
			String nombreMax = null;
			
			for(String nombre : mapaPersonas.keySet()) {
				int cant = mapaPersonas.get(nombre);
				
				if(cant > max) {
					max = cant;
					nombreMax = nombre;
				}

			}
			
			mapaResultado.put(nombreMax, max);
			
			mapaPersonas.remove(nombreMax);		
		}
				
	}


//	public static void main(String[] args) {
//		Juego juego = GestorDeArchivos.cargarJuego("src/unlam/progava/oia/in/01.in");
//		juego.calcularNombresRepetidos();
//		GestorDeArchivos.escribirSalida(juego, "src/unlam/progava/oia/out/00.out");
//		
//		
//		
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
