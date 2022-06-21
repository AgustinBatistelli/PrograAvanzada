package grafos;

public class BFS {
//
//	public static void resolver(GrafoListaNoDirigido grafo, int nodoInicial) {
//		int cantVertices = grafo.getCantVertices();
//		int[] alturas = new int[cantVertices];
//		Queue<Integer> cola = new LinkedList<Integer>();
//
//		for (int i = 0; i < alturas.length; i++) {
//			alturas[i] = Integer.MAX_VALUE;
//		}
//
//		List<Adyacencia> adyacenciasNodo;
//		cola.add(nodoInicial);
//		alturas[nodoInicial] = 0;
//		while (!cola.isEmpty()) {
//			int topeDeCola = cola.remove();
//			adyacenciasNodo = grafo.getListaAdyacenciasNodo(topeDeCola);
//			int alturaActual = alturas[topeDeCola] + 1;
//			for (Adyacencia a : adyacenciasNodo) {
//				int destino = a.getDestino();
//				if (alturas[destino] == Integer.MAX_VALUE) {
//					cola.add(destino);
//					alturas[destino] = alturaActual;
//					System.out.println(destino + ", altura:" + alturaActual);
//				}
//			}
//		}
//	}

}
