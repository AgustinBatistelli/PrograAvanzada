package Grafo;

public class Arista {

	private int nodo1;
	private int nodo2;

	public Arista(int nodo1, int nodo2) 
	{
		this.setNodo1(nodo1);
		this.setNodo2(nodo2);
	}

	public int getNodo1() 
	{
		return nodo1;
	}

	public void setNodo1(int nodo1) 
	{
		this.nodo1 = nodo1;
	}

	public int getNodo2() 
	{
		return nodo2;
	}

	public void setNodo2(int nodo2) 
	{
		this.nodo2 = nodo2;
	}

	public void mostrar() 
	{
		System.out.println(this.nodo1 + " " + this.nodo2);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nodo1;
		result = prime * result + nodo2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arista other = (Arista) obj;
		if (nodo1 != other.nodo1)
			return false;
		if (nodo2 != other.nodo2)
			return false;
		return true;
	}

}
