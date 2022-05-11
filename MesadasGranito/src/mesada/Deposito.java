package mesada;

import java.util.ArrayList;

public class Deposito {
	
	private ArrayList<Mesada> arrayMesadas = new ArrayList<Mesada>();
	private int pilasMin;
	
	public Deposito() {
	}
	
	public void agregarMesada(Mesada mesada) {
		arrayMesadas.add(mesada);
	}
	
	public int calcularPilas() {
		
		if(arrayMesadas.size() == 0)
			return 0;
		
		int cantPilas = 1;
		
		for(int i = 0; i < arrayMesadas.size()-1 ; i++) {
			
			if( !arrayMesadas.get(i).menorIgual(arrayMesadas.get(i+1)) ) {
				cantPilas++;
			}
		}
		pilasMin = cantPilas;
		return cantPilas;		
	}
	
	public int getPilasMin() {
		return pilasMin;
	}

	public void ordernaMesadas() {
		quicksort(arrayMesadas, 0,arrayMesadas.size()-1);
	}
	
	public ArrayList<Mesada> quicksort(ArrayList<Mesada> arrayMesadas, int izq, int der) {
	    
		if (izq >= der) {
	        return arrayMesadas;
	    }
	    int i = izq, d = der;
	    if (izq != der) {
	        
	    	int pivote;
	        Mesada aux;
	        
	        pivote = izq;
	        while (izq != der) {
	            while ( (arrayMesadas.get(der).getAncho() >= arrayMesadas.get(pivote).getAncho() ) && izq < der) {
	                der--;
	            }
	            while (arrayMesadas.get(izq).getAncho() < arrayMesadas.get(pivote).getAncho() && izq < der) {
	                izq++;
	            }
	            if (der != izq) {
	                aux = new Mesada(arrayMesadas.get(der)); 
	                arrayMesadas.get(der).setMesada(arrayMesadas.get(izq));
	                arrayMesadas.get(izq).setMesada(aux);
	            }
	        }
	        if (izq == der) {
	            quicksort(arrayMesadas, i, izq - 1);
	            quicksort(arrayMesadas, izq + 1, d);
	        }
	    } else {
	        return arrayMesadas;
	    }
	    return arrayMesadas;
	}
	
	public void mostrarArray() {
		
		for(Mesada mesada: arrayMesadas) {
			System.out.println(mesada.toString());			
		}
		
	}

	public ArrayList<Mesada> getArrayMesadas() {
		return arrayMesadas;
	}

	
	
}
