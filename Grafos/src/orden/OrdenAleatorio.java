package orden;

import grafos.Grafo;

public class OrdenAleatorio implements MetodoOrdenamiento {

	public Orden generarOrden(Grafo grafo) {
		Orden orden = new Orden(grafo.getCantNodos());
		
		///carga de orden secuencial 
		for(int i = 0; i < grafo.getCantNodos(); i++) {
			orden.getOrden()[i] = i;
		}
		
		for(int i = 0; i < grafo.getCantNodos() * 10; i++) {
			int indiceRandom1 = (int) Math.floor(Math.random() * grafo.getCantNodos()); // floor redondea para abajo.
			int indiceRandom2 = (int) Math.floor(Math.random() * grafo.getCantNodos());
			
			int aux = orden.getOrden()[indiceRandom1];
			orden.getOrden()[indiceRandom1] = orden.getOrden()[indiceRandom2];
			orden.getOrden()[indiceRandom2] = aux;
		}
		
		return orden;
	}

}
