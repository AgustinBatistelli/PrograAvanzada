package Grafo;

public class Nodo {

	private int nroNodo;
	private boolean Dragon = false;
	
	public int getNroNodo() 
	{
		return nroNodo;
	}

	public void setNroNodo(int nroNodo) 
	{
		this.nroNodo = nroNodo;
	}

	public Nodo(int nodo) 
	{
		this.setNroNodo(nodo);
	}

	public boolean isDragon() {
		return Dragon;
	}

	public void setDragon(boolean Dragon) {
		this.Dragon = Dragon;
	}

}
