package oia;

public class Corredor {
	
	private int edad;
	private char sexo;
	private int nroCorredor;
	private int categoria = 0;
	
	public Corredor(int edad, char sexo, int nroCorredor) {
		this.edad = edad;
		this.sexo = sexo;
		this.nroCorredor = nroCorredor;
	}
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public int getNroCorredor() {
		return nroCorredor;
	}
	public void setNroCorredor(int nroCorredor) {
		this.nroCorredor = nroCorredor;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

}
