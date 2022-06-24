package OIARegalos;

import java.util.HashSet;

import Color.Coloreo;
import grafos.GrafoMatrizNoDirigido;

public class ProgramaProbador {
	public static boolean probarColoreo(GrafoMatrizNoDirigido grafo, Coloreo coloreo) {
		int VALOR_INF = 999;
		int []arrayColores = coloreo.getColoresAsignados();
		
		for(int i = 0; i < grafo.getCantNodos(); i++) {
			
			if(arrayColores[i] == 0) {
				System.out.println("El nodo " + i + " no está coloreado");
				return false;
			}
			
			HashSet<Integer> nodosAdyacentes = grafo.getNodosAdyacentes(i);
			///Chequeo que cada valor del coloreo no esté en los nodos adyacentes
			for(Integer nodoAdyacente: nodosAdyacentes) {
				
				if(arrayColores[i] == arrayColores[nodoAdyacente]) {
					System.out.println("Hay un color con nodos adyacentes incompatibles");
					return false;
					
				}		
			}
			
			
		}
		
		return true;
	}
}
