package OIARegalos;

import java.util.HashMap;

import Color.Coloreo;
import Color.ColoreoPrimerColor;
import Orden.Orden;
import Orden.OrdenAleatorio;
import grafos.GrafoMatrizNoDirigido;

public class MapaLocales {
	private int cantLocales;
	private GrafoMatrizNoDirigido grafoConflictosLocales;
	
	public MapaLocales(int cantLocales) {
		this.cantLocales = cantLocales;
		grafoConflictosLocales = new GrafoMatrizNoDirigido(cantLocales);
	}
	
	
	public void agregarLocalConflictivo(int localActual, int localConflicto) {
		grafoConflictosLocales.setArista(localActual, localConflicto, 1);
	}
	
	public void obtenerMaximoDeLocalesSinConflicto() {
		Orden orden = new OrdenAleatorio().generarOrden(grafoConflictosLocales);
		Coloreo coloreoMinimo = new ColoreoPrimerColor().colorear(grafoConflictosLocales, orden);
		
		for(int i = 0; i < 10000; i++) {
			orden = new OrdenAleatorio().generarOrden(grafoConflictosLocales);
			Coloreo coloreoNuevo = new ColoreoPrimerColor().colorear(grafoConflictosLocales, orden);
			if(coloreoNuevo.getCantColores() < coloreoMinimo.getCantColores()) {
				coloreoMinimo = coloreoNuevo;
			}
		}
		
		
		HashMap<Integer, Integer>  mapaApariciones = new HashMap<Integer, Integer>();
		int[] arrayColor = coloreoMinimo.getColoresAsignados();
		
		
		for(int i = 0 ; i < cantLocales; i++) {
			if(!mapaApariciones.containsKey(arrayColor[i])) {
				mapaApariciones.put(arrayColor[i], 1);
			}
			else {
				int valor = mapaApariciones.get(arrayColor[i]);
				valor++;
				mapaApariciones.put(arrayColor[i], valor);
			}
		}
		
		int max = 0;
		int colorMax = 0;
		for(Integer clave : mapaApariciones.keySet()) {
			if(mapaApariciones.get(clave) > max) {
				max = mapaApariciones.get(clave);
				colorMax = clave;
			}
		}
		
		System.out.println("Cantidad maxima de locales sin conflicto: " + max);

		for(int i = 0; i < cantLocales; i++) {
			if(arrayColor[i] == colorMax) {
				System.out.print(i + 1  + " ");
			}
		}
		
		
		System.out.println(ProgramaProbador.probarColoreo(grafoConflictosLocales, coloreoMinimo));
	}
	
	public static void main(String[] args) {
		String pathInput = "grafoOIARegalo.txt";
		MapaLocales mapa = GestorArchivosRegalos.cargarMapaLocales(pathInput);
		
		mapa.grafoConflictosLocales.mostrarMatriz();
		mapa.obtenerMaximoDeLocalesSinConflicto();
		
		
	}
}
