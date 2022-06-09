package Grafo;

public class Nodo {

	public int x;
	public int y;
	public int nroNodo;

	public Nodo(int x, int y, int nroNodo) 
	{
		this.x = x;
		this.y = y;
		this.nroNodo = nroNodo;
	}
	
	public Nodo(int nroNodo)
	{
		this.nroNodo = nroNodo;
	}
	
	private double calcularDistancia(Nodo n)
	{
		double primer = Math.pow((n.x-this.x),2);
		double segundo = Math.pow((n.y-this.y),2);
		double resultado = Math.sqrt(primer+segundo);
		return resultado;
	}
	
	public boolean esAdyacente(Nodo n)
	{
		return this.calcularDistancia(n)<=50;
	}

}
