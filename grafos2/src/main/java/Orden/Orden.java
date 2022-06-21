package Orden;

public class Orden {
	
	private int[] orden;
	
	public Orden(int tam) {
		orden = new int[tam];
	}
	
	public int[] getOrden() {
		return orden;
	}
	
	public void setOrden(int[] orden) {
		this.orden = orden;
	}

}