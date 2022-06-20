package mesadaGranito;

import java.util.Stack;

public class PilaDeMesadas {
	private Stack<Mesada> pila = new Stack<Mesada>();
	
	public PilaDeMesadas() {
		
	}
	
	public void apilar(Mesada mesada) {
		pila.push(mesada);
	}
	
	public Mesada mostrarTope() {
		return pila.peek();
	}
	
	public boolean pilaVacia() {
		return pila.empty();
	}
	
	public Mesada desapilar() {
		return pila.pop();
	}
}
