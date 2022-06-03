package unlam.progava.oia;

import java.util.ArrayList;

import Grafos.GrafoNoDirigidoPonderado;

public class Mapa {
	
	private ArrayList<Tunel> tuneles;
	private ArrayList<Puente> puentes;
	
	GrafoNoDirigidoPonderado grafo;
	
	private int resultado;
	
	public Mapa(ArrayList<Tunel> tuneles,ArrayList<Puente> puentes,GrafoNoDirigidoPonderado grafo) {
		this.tuneles = tuneles;
		this.puentes = puentes;
		this.grafo = grafo;
		this.resultado = 0;
	}

	public ArrayList<Tunel> getTuneles() {
		return tuneles;
	}

	public void setTuneles(ArrayList<Tunel> tuneles) {
		this.tuneles = tuneles;
	}

	public ArrayList<Puente> getPuentes() {
		return puentes;
	}

	public void setPuentes(ArrayList<Puente> puentes) {
		this.puentes = puentes;
	}

	public GrafoNoDirigidoPonderado getGrafo() {
		return grafo;
	}

	public void setGrafo(GrafoNoDirigidoPonderado grafo) {
		this.grafo = grafo;
	}
	
	public int getResultado() {
		return this.resultado;
	}
	
	public void resolver() {
			
		this.resultado = grafo.realizarKruskal();;
		
	}
	
}
