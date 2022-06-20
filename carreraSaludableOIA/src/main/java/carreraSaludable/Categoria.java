package carreraSaludable;

import java.util.ArrayList;

public class Categoria {
	static int cantCategoriasMasculino = 0;
	static int cantCategoriasFemenino = 0;
	
	
	
	private int nroCategoria;
	private int edadMin,
				edadMax;
	private String sexo;
	ArrayList<Competidor> topCompetidores = new ArrayList<Competidor>();
	
	public Categoria(int edadMin, int edadMax, String sexo) {
		
		if(sexo.equals("M")) {
			cantCategoriasMasculino++;
			this.nroCategoria = cantCategoriasMasculino;
		}
		else {
			cantCategoriasFemenino++;
			this.nroCategoria = cantCategoriasFemenino;
		}
		
		this.edadMin = edadMin;
		this.edadMax = edadMax;
		this.sexo = sexo;
	}

	public void insertarEnTop(Competidor competidor) {
		if(topLleno())
			return;
		topCompetidores.add(competidor);
				
	}
	
	private boolean topLleno() {
		return topCompetidores.size() >= 3;
	}
	
	@Override
	public String toString() {
		return "Categoria [edadMin=" + edadMin + ", edadMax=" + edadMax + ", sexo=" + sexo + "]";
	}

	public int getEdadMin() {
		return edadMin;
	}

	public int getEdadMax() {
		return edadMax;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public String getTop() {
		String linea = "" + nroCategoria + " ";

		for(Competidor comp : topCompetidores) {
			linea += comp.getNroCompetidor() + " ";
		}
		
		int competidoresFaltantes = 3 - topCompetidores.size();
		
		for(int i = 0; i < competidoresFaltantes; i++) {
			linea += "0 ";
			
		}
		
		linea += "\n";
		
		return linea;
	}
	
}
