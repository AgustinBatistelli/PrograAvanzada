package mainTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import mesadaGranito.Mesada;
import mesadaGranito.PilaDeMesadas;

public class MainTest {

	
	public static void main(String[] args) {
			
		Mesada m1 = new Mesada(4, 5);
		Mesada m2 = new Mesada(9, 3);
		Mesada m3 = new Mesada(2, 2);
		Mesada m4 = new Mesada(1, 2);
		Mesada m5 = new Mesada(1, 12);
		Mesada m6 = new Mesada(2, 7);
		
		ArrayList<Mesada> arrayMesadas = new ArrayList<Mesada>();
		
		arrayMesadas.add(m1);
		arrayMesadas.add(m2);
		arrayMesadas.add(m3);
		arrayMesadas.add(m4);
		arrayMesadas.add(m5);
		arrayMesadas.add(m6);
		
		Collections.sort(arrayMesadas, new Comparator<Mesada>() {
	        public int compare(Mesada m1, Mesada m2) {
	            return (int) (m2.getAncho() * m2.getLargo() - m1.getAncho() * m1.getLargo());
	        }
		});
		
//		for(int i = 0; i < arrayMesadas.size(); i++) {
//			System.out.println("ancho " + arrayMesadas.get(i).getAncho() + " alto " + arrayMesadas.get(i).getLargo());			
//		}
		
		
		/*
		 * 
		 * Lo que hago es ordenar el arrayList segun el área de las mesadas, de mayor a menor.
		 * Luego, voy recorriendo ese arrayList y voy poniendo en una pila las mesadas que pueden ser apilas.
		 * Una vez que terminé de recorrer el arraylist y apilé las mesadas, las borro del arrayList para que no
		 * puedan ser utilizas para otras pilas.
		 * 
		 * Repito ese proceso hasta vaciar la cantidad de mesadas en el arrayList
		 * 
		 * 
		 * 
		 */
		
		PilaDeMesadas pila = new PilaDeMesadas();
		int contadorPilas = 0;
		
		while(!arrayMesadas.isEmpty()) {
			
			pila.apilar(arrayMesadas.get(0));
			
			
			for(int i = 1; i < arrayMesadas.size(); i++) {
				Mesada mesada = arrayMesadas.get(i);
				if(mesada.esApilable(pila.mostrarTope()) ) {
					pila.apilar(mesada);
				}
			}
			
			while(!pila.pilaVacia()) {
				arrayMesadas.remove(pila.desapilar());
			}
			contadorPilas++;
		}
		
		System.out.println(contadorPilas);
		
	}
}
