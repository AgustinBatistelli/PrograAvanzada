package oia;

import java.util.ArrayList;

public class Carrera {

	private ArrayList<Corredor> listaCorredores;
	private ArrayList<Corredor> finalizaron;
	private ArrayList<Categoria> listaCategorias;
	private String resultado;

	public Carrera(ArrayList<Categoria> categorias, ArrayList<Corredor> corredores, ArrayList<Corredor> finalizaron) {
		this.listaCorredores = corredores;
		this.finalizaron = finalizaron;
		this.listaCategorias = categorias;
		this.resultado = "";
	}

	public void resolver() throws Exception {

		ArrayList<Corredor> finalizaronAux = new ArrayList<Corredor>();
		
		for(Corredor corredor : finalizaron) {
			
			for(Categoria categoria : listaCategorias) {
				
				if (perteneceACategoria(corredor, categoria)) {
					
					corredor.setCategoria(categoria.getNumeroCategoria());
					finalizaronAux.add(corredor);
					
				}

			}
		}
		
		finalizaron.clear();
		finalizaron = finalizaronAux;
		finalizaron.sort(new ComparatorCategoria());
		
		int cont = 0;
		
		for(Categoria categoria : listaCategorias) {
			
			resultado += String.valueOf(categoria.getNumeroCategoria());
			
			for(int x = 0; x < 3; x++) {

				if(cont < finalizaron.size() 
						&& finalizaron.get(cont).getCategoria() == categoria.getNumeroCategoria()) {
					resultado += " " + finalizaron.get(cont).getNroCorredor();
					cont++;
				} else
					resultado += " 0";
				
			}
			
			resultado += "\n";				
			
		}
		
		System.out.println(resultado);
	}

	private boolean perteneceACategoria(Corredor corredor, Categoria categoria) {
		return corredor.getCategoria() == 0 
				&& corredor.getEdad() >= categoria.getMinimo()
				&& corredor.getEdad() <= categoria.getMaximo()
				&& corredor.getSexo() == categoria.getSexo();
	}

	public ArrayList<Corredor> getListaCorredores() {
		return listaCorredores;
	}

	public void setListaCorredores(ArrayList<Corredor> listaCorredores) {
		this.listaCorredores = listaCorredores;
	}

	public ArrayList<Corredor> getListaCorredoresQueFinalizaronLaCarrera() {
		return finalizaron;
	}

	public void setListaCorredoresQueFinalizaronLaCarrera(ArrayList<Corredor> finalizaron) {
		this.finalizaron = finalizaron;
	}

	public ArrayList<Categoria> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(ArrayList<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}
