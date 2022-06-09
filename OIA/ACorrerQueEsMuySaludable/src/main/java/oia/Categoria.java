package oia;

public class Categoria {

	private int minimo;
	private int maximo;
	private int numeroCategoria;
	private char sexo;

	public Categoria(int min, int max, int nroCat, char sexo) {
		minimo = min;
		maximo = max;
		numeroCategoria = nroCat;
		this.sexo = sexo;
	}

	public int getMinimo() {
		return minimo;
	}
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}
	public int getMaximo() {
		return maximo;
	}
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
	public int getNumeroCategoria() {
		return numeroCategoria;
	}
	public void setNumeroCategoria(int numeroCategoria) {
		this.numeroCategoria = numeroCategoria;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int obtenerNroCategoriaPorEdad(int edad) {
		
		int n = this.numeroCategoria;
		
		if(edad < this.minimo && edad > this.maximo)
			n = -1;
		
		return n;
	}
	
}
