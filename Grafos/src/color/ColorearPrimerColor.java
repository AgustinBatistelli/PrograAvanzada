package color;

import java.util.HashSet;

import grafos.Grafo;
import orden.Orden;

public class ColorearPrimerColor {
	
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
				
				for(int j = 0; j < grafo.getCantNodos(); j++) { 
					// comparo el nodo actual contra los demas
					// si no es adyacente y no fue coloreado (arrayColores[j] == 0) , lo voy a colorear
					if(!nodosAdyacentes.contains(j) && arrayColores[j] == 0) {
						arrayColores[j] = cantColores; // pones el color..
						nodosSinColorear.remove(j); //volas el nodo del hash de nodos adyacentes.
					}
				}
				cantColores++;
			}
			i++;
		}
		
		coloreo.setColoreo(arrayColores, cantColores);		
		return coloreo;
	}

}
