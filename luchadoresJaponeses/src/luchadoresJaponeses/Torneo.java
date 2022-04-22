package luchadoresJaponeses;

import java.util.ArrayList;

public class Torneo {
	
	private ArrayList<Luchador> arrayLuchadores = new ArrayList<Luchador>();
	private int[] arrayDomina; //  Conozco la cant de luchadores.
//	private ArrayList<Integer> arrayDomina = new ArrayList<Integer>(); 
	
	public Torneo(int cantLuchadores) {
		arrayDomina = new int[cantLuchadores];
	}
	
	public int[] getArrayDomina() {
		
		int [] nuevoArray = new int[this.arrayDomina.length];
		for (int i = 0; i < arrayDomina.length; i++) {
			nuevoArray[i] = arrayDomina[i];
		}
		return nuevoArray;
	}
	
	public void agregarLuchador(Luchador luchador) {
		arrayLuchadores.add(luchador);	
	}
	
	public void calcularDuelos() {
		
		for( int i = 0; i < arrayLuchadores.size(); i++) {
			
			Luchador luchadorActual = new Luchador(arrayLuchadores.get(i));
			
			for ( int j = i+1; j < arrayLuchadores.size(); j++) {
				
				if (luchadorActual.dominaA(arrayLuchadores.get(j)) )
					arrayDomina[i]++;
				else if ( arrayLuchadores.get(j).dominaA(luchadorActual) )
					arrayDomina[j]++;
			}
		}	
		
	}
	
	public void mostrarArrayDomina() {
		System.out.println("Array de domina:");
		
		for (int i = 0; i< arrayDomina.length; i++) {
			System.out.println(arrayDomina[i]);
		}
		
	}
	
	
}

