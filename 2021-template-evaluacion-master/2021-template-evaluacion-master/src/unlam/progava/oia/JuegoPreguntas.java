package unlam.progava.oia;

import java.util.ArrayList;
import java.util.HashMap;

public class JuegoPreguntas {
	private ArrayList<String> respuestas = new ArrayList<String>();
	private HashMap<String, Integer> mapaCombinaciones = new HashMap<String, Integer>();
	private String respuestaMax;

	private int puntajeMax;
	private int cantPreguntas,
				cantColaboradores;
	
	public JuegoPreguntas(int cantPreguntas, int cantColaboradores) {
		this.cantPreguntas = cantPreguntas;
		this.cantColaboradores = cantColaboradores;
	}
	
	public String getRespuestaMax() {
		return respuestaMax;
	}
	
	public int getPuntajeMax() {
		return puntajeMax;
	}
	
	public void agregarRespuesta(String respuesta) {
		respuestas.add(respuesta);
	}
	
	public void calcularEquipos() {
		
		///cargo el mapa con la cantidad de coincidencias para cada substring distinta
		for(int i = 0; i < cantPreguntas; i++) {
			
			for(String respuesta : respuestas) {
				String respuestaCortada = respuesta.substring(0, i + 1);
				
				if(!mapaCombinaciones.containsKey(respuestaCortada)) {
					mapaCombinaciones.put(respuestaCortada, 1);
				}
				else {
					int cant = mapaCombinaciones.get(respuestaCortada);
					cant++;
					mapaCombinaciones.put(respuestaCortada, cant);
				}
			}
		}
		
		///recorro el mapa y multiplico por el peso de cada substring
		String respuestaMax = null;
		int maxPuntaje = 0;
		
		for(String respuesta : mapaCombinaciones.keySet()) {
			int cant = mapaCombinaciones.get(respuesta);
			int puntaje = cant * respuesta.length() * respuesta.length();
						
			if(puntaje > maxPuntaje) {
				maxPuntaje = puntaje;
				respuestaMax = respuesta;
			}
			
		}
		
		this.respuestaMax = respuestaMax;
		this.puntajeMax = maxPuntaje;
		System.out.println("Respuesta max: " + this.respuestaMax);
		System.out.println("Puntaje max: " + this.puntajeMax);
		
//		
////		System.out.println("Mostrando mapa");
////		for(String respuesta : mapaCombinaciones.keySet()) {
////			int cant = mapaCombinaciones.get(respuesta);
////			System.out.println(respuesta + ": " + cant);
////		}
////		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
