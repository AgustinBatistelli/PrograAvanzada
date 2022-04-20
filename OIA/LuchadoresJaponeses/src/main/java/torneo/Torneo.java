package torneo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import admin_archivos.GestorArchivos;
import luchadores_japoneses.LuchadorJapones;

public class Torneo {

	private List<LuchadorJapones> luchadores = new ArrayList<LuchadorJapones>();

	public List<LuchadorJapones> getLuchadores() {
		return luchadores;
	}

	public void setLuchadores(List<LuchadorJapones> luchadores) {
		this.luchadores = luchadores;
	}

	public int[] resolver() throws FileNotFoundException {

		GestorArchivos gestor = new GestorArchivos();

		Torneo torneo = gestor.leerArchivo("luchadoresJaponeses.in");

		List<LuchadorJapones> luchadores = torneo.getLuchadores();

		int[] resultado = new int[luchadores.size()];

		for(int i = 0; i < luchadores.size(); i++) {

			for(int j = i+1; j < luchadores.size(); j++) {

				if(luchadores.get(i).domina(luchadores.get(j))) {
					resultado = agregarDominaciones(i, resultado, luchadores);
					
				}else {
					if(luchadores.get(j).domina(luchadores.get(i))) {
						resultado = agregarDominaciones(j, resultado, luchadores);
					}
				}
					
			}

		}
		
		return resultado;
	}

	private int[] agregarDominaciones(int nroLuchador, int[] resultado, List<LuchadorJapones> luchadores) {
		resultado[nroLuchador] = luchadores.get(nroLuchador).getDominaciones() + 1;
		luchadores.get(nroLuchador).setDominaciones(resultado[nroLuchador]);
		
		return resultado;
	}
}
