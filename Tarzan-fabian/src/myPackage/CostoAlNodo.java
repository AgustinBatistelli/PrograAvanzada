package myPackage;

import java.util.ArrayList;

public class CostoAlNodo implements Comparable<CostoAlNodo> {

	private int nodo;
	private double costoMinimo;
	private ArrayList<Integer> caminoMasCorto;
	private Vector vector;
	
	public CostoAlNodo(int nodo, double costoMinimo, Vector v) {
		this.nodo = nodo;
		this.costoMinimo = costoMinimo;
		this.caminoMasCorto = new ArrayList<Integer>();
		this.vector = v;
	}
	
	public Vector getVector() {
		return vector;
	}

	public void setVector(Vector vector) {
		this.vector = vector;
	}

	public int getNodo() {
		return nodo;
	}

	public void setNodo(int nodo) {
		this.nodo = nodo;
	}

	public double getCostoMinimo() {
		return costoMinimo;
	}

	public void setCostoMinimo(double costoMinimo) {
		this.costoMinimo = costoMinimo;
	}

	public ArrayList<Integer> getCaminoMasCorto() {
		return caminoMasCorto;
	}

	public void setCaminoMasCorto(ArrayList<Integer> caminoMasCorto) {
		this.caminoMasCorto = caminoMasCorto;
	}
	
	public void agregarNodoAlCamino(int nodo) {
		this.caminoMasCorto.add(nodo);
	}

	@Override
	public int compareTo(CostoAlNodo nodo) {
		return (int)(this.costoMinimo - nodo.getCostoMinimo());
	}
	
}
