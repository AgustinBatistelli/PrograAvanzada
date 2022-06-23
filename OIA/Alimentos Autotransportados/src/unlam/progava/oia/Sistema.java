package unlam.progava.oia;

import java.util.ArrayList;
import java.util.Collections;
import Grafos.GrafoNoDirigidoPonderado;

public class Sistema {
	ArrayList<String> ciudades;
	GrafoNoDirigidoPonderado grafo;
	String resultado;

	
	
	public Sistema(ArrayList<String> ciudades, GrafoNoDirigidoPonderado grafo, String resultado) {
		this.ciudades = ciudades;
		this.grafo = grafo;
		this.resultado = resultado;
	}

	public Sistema() {
		this.ciudades = new ArrayList<String>();
	}

	public void resolver() {
		Integer res = grafo.realizarKruskal();
		resultado= res.toString();
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public GrafoNoDirigidoPonderado getGrafo() {
		return grafo;
	}

	public void setGrafo(GrafoNoDirigidoPonderado grafo) {
		this.grafo = grafo;
	}
	
	public static String formatearSalida(ArrayList<Integer> res) {
		Collections.reverse(res);
		String resultado = "";
		for (Integer integer : res) {
			resultado += integer.toString() + " ";
		}
		return resultado.trim();
	}

	public ArrayList<String> getCiudades() {
		return ciudades;
	}

	public void setCiudades(ArrayList<String> ciudades) {
		this.ciudades = ciudades;
	}
	
	
	
	
}
