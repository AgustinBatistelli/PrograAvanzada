import java.io.IOException;

//import Algoritmos.BFS; //Resuelto con DFS.
import Algoritmos.DFS;
import TiposGrafos.GrafoDP;

public class Main {

	public static void main(String[] args) throws IOException 
	{
		GrafoDP ejercicio = new GrafoDP("./in/ejercicio.in");
		/*GrafoDP ejercicio = new GrafoDP("./in/1caminos.in");
		GrafoDP ejercicio = new GrafoDP("./in/2caminos.in");
		GrafoDP ejercicio = new GrafoDP("./in/3caminos.in");*/
		DFS algoritmo = new DFS(ejercicio, 1);
		algoritmo.ejecutar();
	}

}
