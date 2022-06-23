package OIAElectrificacion;

import java.util.ArrayList;

import grafos.GrafoMatrizAdyacencia.Arista;
import grafos.GrafoMatrizNoDirigido;

public class Pais {
	private int cantCiudades;
	private int cantCentralesElectricas;
	private ArrayList<Integer> arrayCentrales;
	private GrafoMatrizNoDirigido grafoCiudades;
	private ArrayList<Arista> tendido;
	
	public Pais(int cantCiudades, int cantCentralesElectricas) {
		this.cantCiudades = cantCiudades;
		this.cantCentralesElectricas = cantCentralesElectricas;
		grafoCiudades = new GrafoMatrizNoDirigido(cantCiudades);
		arrayCentrales = new ArrayList<Integer>();
		tendido = new ArrayList<Arista>();
	}
	
	public void agregarTendido(int origen, int destino, double largo) {
		grafoCiudades.setArista(origen, destino, largo);
	}
	
	public void agregarCentral(int ciudad) {
		cantCentralesElectricas++;
		arrayCentrales.add(ciudad);
	}
	
	public void tendidoMinimo() {
		double[][] resultado = grafoCiudades.floyd();
		
		///recorro la matriz y cargo los cables entre ciudades en un array)
		for(int i = 0; i < cantCiudades; i++) {
			int indiceMinimo = indiceMinimoDeArray(resultado[i]);
			if(indiceMinimo != -1 && !arrayCentrales.contains(i)) {
				tendido.add(new Arista(i, indiceMinimo, resultado[i][indiceMinimo]));
			}
		}
		
		
		//recorro el array recien cargado y obtengo el origen y destino de cada tendido asi como el peso
		double largoTendido = 0;
		for(Arista unionCiudad: tendido) {
			largoTendido += unionCiudad.getPeso();
			System.out.println(unionCiudad.getOrigen() + " - " + unionCiudad.getDestino());	
		}
		System.out.println("El largo del tendido es: " + largoTendido);
		
	}
	
	private int indiceMinimoDeArray(double[] array) {
		final double VALOR_INF = 999;
		double min = VALOR_INF;
		int indice = -1;
		for(int i = 0; i < array.length; i++) {
			if(array[i] <= min && array[i] != 0) {
				min = array[i];
				indice = i;
			}
		}
		return indice;
	}
	
	public static void main(String[] args) {
		String inputPath = "grafoOIAElectrificacion.txt";
		Pais pais = GestorDeArchivosElectrificacion.cargarPais(inputPath);
		
		pais.grafoCiudades.mostrarMatriz();
		pais.tendidoMinimo();
		
	}
	
}
