package carreraSaludable;

import java.util.ArrayList;

public class Competidor {
	private int nroCompetidor,
				edad;
	private String sexo;
	
	static int cantCompetidores = 0;
	
	
	public Competidor(int edad, String sexo){
		cantCompetidores++;
		this.edad = edad;
		this.sexo = sexo;
		nroCompetidor = cantCompetidores;
	}
	
	public int getNroCompetidor() {
		return nroCompetidor;
	}

	@Override
	public String toString() {
		return "Competidor [nroCompetidor=" + nroCompetidor + ", edad=" + edad + ", sexo=" + sexo + "]";
	}
	
	public Categoria obtenerCategoria(ArrayList<Categoria> listaCategorias) {
		Categoria catObtenida = null;
		for(Categoria categoria : listaCategorias) {
			if(edad >= categoria.getEdadMin() && edad <= categoria.getEdadMax() && sexo.equals(categoria.getSexo()) ) {
				catObtenida = categoria;
			}
		}
		
		return catObtenida;
		
	}
	
	
}
