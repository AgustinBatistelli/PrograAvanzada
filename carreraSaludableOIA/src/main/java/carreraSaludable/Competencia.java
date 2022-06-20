package carreraSaludable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Competencia {
	HashMap<Integer, Competidor> competidores = new HashMap<Integer, Competidor>();
	ArrayList<Integer> nroCompetidoresFinalizados  = new ArrayList<Integer>();
	ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	
	public void agregarCompetidor(Competidor competidor) {
		competidores.put(competidor.getNroCompetidor(), competidor);
	}
	
	public void agregarCompetidorFinalizado(int nroCompetidor) {
		nroCompetidoresFinalizados.add(nroCompetidor);
	}
	
	public void agregarCategoria(Categoria categoria) {
		categorias.add(categoria);
	}
	
	public ArrayList<Categoria> getCategorias(){
		return categorias;
	}
	
	public void calcularResultados() {
		for(Integer nroCompetidor: nroCompetidoresFinalizados) {
			Competidor comp = competidores.get(nroCompetidor);
			
			Categoria cat = comp.obtenerCategoria(categorias);
			if(cat != null) {
				cat.insertarEnTop(comp);
			}
		}


	}
	
	public static void main(String[] args) {
		Competencia comp = GestorArchivos.cargarCompetencia();

		comp.calcularResultados();
		
		try {
			GestorArchivos.escribirSalida(comp);			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
