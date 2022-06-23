package OIAs.OIAMetro;

import java.util.ArrayList;

import grafos.GrafoMatrizNoDirigido;
import grafos.GrafoMatrizAdyacencia.Arista;

public class Ciudad {
	private static double PESO_TUNEL = 1;
	private static double PESO_PUENTE = 5;
	
	
	private int cantIslas;
	private GrafoMatrizNoDirigido grafoIslas;
	
	public Ciudad(int cantIslas) {
		this.cantIslas = cantIslas;
		grafoIslas = new GrafoMatrizNoDirigido(cantIslas);
	}
	
	public int cantidadMinimaTuneles() {
		ArrayList<Arista> conexionesIslas = grafoIslas.kruskal();
		
		int cantPuentes = 0;
		for(Arista conexionIsla: conexionesIslas) {
			if(conexionIsla.getPeso() == PESO_PUENTE) {
				cantPuentes++;
			}
		}
		return cantPuentes;
		
	}
	
	public void agregarTunel(int origen, int destino) {
		grafoIslas.setArista(origen, destino, PESO_TUNEL);
	}
	
	public void agregarPuente(int origen, int destino) {
		grafoIslas.setArista(origen, destino, PESO_PUENTE);
	}
	
	public static void main(String[] args) {
		String pathInput = "./grafoOIAMetro.txt";
		Ciudad ciudad = GestorDeArchivosMetro.cargarCiudad(pathInput);
		
		int cantMinPuentes = ciudad.cantidadMinimaTuneles();
		System.out.println("La cantidad minima de puentes es: " + cantMinPuentes);
		
	}
	
}
