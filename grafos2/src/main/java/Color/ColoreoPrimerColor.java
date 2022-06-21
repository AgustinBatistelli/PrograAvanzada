package Color;

import java.util.HashSet;

import Orden.Orden;
import grafos.Grafo;

public class ColoreoPrimerColor {

	public Coloreo colorear(Grafo grafo, Orden orden) {
		Coloreo coloreo = new Coloreo();

		int cantColores = 0;
		int[] arrayColores = new int[grafo.getCantNodos()];
		int[] arrayOrden = orden.getOrden();
		HashSet<Integer> nodosSinColorear = grafo.getNodos(); 

		int i = 0;
		while(!nodosSinColorear.isEmpty()) {
			int nodoActual = arrayOrden[i];
			if(arrayColores[nodoActual] == 0) { //si el elemento actual no esta coloreado, me pongo a buscar 
				HashSet<Integer> nodosAdyacentes =  grafo.getNodosAdyacentes(nodoActual);
				cantColores++;
				for(int j = 0; j < grafo.getCantNodos(); j++) { ///comparo el nodo actual contra los demas
					if(!nodosAdyacentes.contains(j) && arrayColores[j] == 0) { //si no es adyacente y no fue coloreado, lo voy a colorear
						arrayColores[j] = cantColores;
						nodosSinColorear.remove(j);
					}
				}
			}
			i++;
		}
		
		coloreo.setColoreo(arrayColores, cantColores);		
		return coloreo;
	}
	
}