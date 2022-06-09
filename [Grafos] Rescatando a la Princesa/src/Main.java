import java.io.IOException;
import java.util.ArrayList;

import Algoritmos.Dijkstra;
import TiposGrafos.GrafoNDP;

public class Main {

	public static void main(String[] args) throws IOException 
	{
		//Funciona siempre y cuando los dragones no permanezcan en el mismo nodo.
		GrafoNDP ejercicio = new GrafoNDP("./in/ejercicio.in");
		Dijkstra algoritmo = new Dijkstra(ejercicio, ejercicio.principe);
		algoritmo.ejecutar();
		//Intento de evitar un nodo con dragon.
		/* La idea seria la siguiente, llamar al ejecutar que el ejecutar se de cuenta
		 * que hay una posible intercepcion con un dragon, que intente evitar el nodo
		 * que tiene el dragon y devuelva que no puede llegar, entonces bueno
		 * mejor intentar llegar por una intercepcion
		 * o que devuelva otro camino y ese otro camino tambien habria que chequear si no tiene
		 * dragon y asi sucesivamente esta hecho el planteo de Dijkstra evitando un nodo.
		 * 
		 */
		System.out.println();
		GrafoNDP ejerciciox = new GrafoNDP("./in/ejercicio.in");
		Dijkstra algoritmox = new Dijkstra(ejerciciox, ejercicio.principe);
		ArrayList<Integer> nodosAEvitar = new ArrayList<Integer>();
		nodosAEvitar.add(3);
		algoritmox.ejecutarEvitando(nodosAEvitar);
	}

}
