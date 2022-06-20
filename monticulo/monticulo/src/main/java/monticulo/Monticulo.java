package monticulo;

import java.util.ArrayList;

public class Monticulo {
	private ArrayList<Integer> array = new ArrayList<Integer>();

	public Monticulo() {
		array.add(0, null);
	}

	public void insertar(int elemento) {

		array.add(elemento);

		int indiceElemNuevo = array.size() - 1;
		int indicePadre = indiceElemNuevo / 2;
		
		
		while (indiceElemNuevo > 1 && array.get(indiceElemNuevo) < array.get(indicePadre)) {
			int aux = array.get(indiceElemNuevo);
			array.set(indiceElemNuevo, array.get(indicePadre));
			array.set(indicePadre, aux);

			indiceElemNuevo = indicePadre;
			indicePadre = indiceElemNuevo / 2;
		}
	}
	
	public int sacar() {
		
		int tamArray = array.size();
		if(tamArray == 1) {
			System.out.println("No hay elementos para sacar del monticulo");
			return -1;
		}
		
		int elemSacar = array.get(1);
		
		///piso la raiz
		int indiceNuevaRaiz = 1;
		int valorNuevaRaiz = array.get(tamArray - 1);
		array.set(1, valorNuevaRaiz);
		
		
		///saco el elemento del final
		
		array.remove(tamArray - 1);
		tamArray--;
		
		///empiezo a bajar la nueva raiz segun sea necesario
		
		int indiceHijoIzq;
		while(indiceNuevaRaiz < tamArray && (indiceHijoIzq = indiceNuevaRaiz * 2) < tamArray) {
			
			Integer	valorHijoIzq = array.get(indiceHijoIzq);
			
			int indiceHijoDer = indiceNuevaRaiz * 2 + 1;
			Integer valorHijoDer = indiceHijoDer < tamArray ? array.get(indiceHijoDer) : null;

			///pregunto si la raiz es mayor a alguno de sus hijos, y en caso de que sea asi, los intercambio
			if(valorNuevaRaiz >= valorHijoIzq || (valorHijoDer != null && valorNuevaRaiz >= valorHijoDer)) {
				
				if(valorHijoDer == null || valorHijoIzq < valorHijoDer) {
					///intercambio la raiz con el hijo izq
					Integer aux = valorNuevaRaiz;
					array.set(indiceNuevaRaiz, array.get(indiceHijoIzq));
					array.set(indiceHijoIzq, aux);

					indiceNuevaRaiz *= 2;
				}
				else {
					///intercambio la raiz con el hijo izq
					Integer aux = valorNuevaRaiz;
					array.set(indiceNuevaRaiz, array.get(indiceHijoDer));
					array.set(indiceHijoDer, aux);

					indiceNuevaRaiz *= 2 + 1;
				}
			}
			
			valorNuevaRaiz = array.get(indiceNuevaRaiz);
			
			
		}
		
		
		return elemSacar;
	}

	public void mostrarMonticulo() {
		for (int i = 1; i < array.size(); i++) {
			System.out.println(array.get(i));
		}

	}

	public static void main(String[] args) {

		Monticulo mont = new Monticulo();
		mont.insertar(100);
		mont.insertar(120);
		mont.insertar(150);
		mont.insertar(150);
		mont.insertar(180);
		mont.insertar(200);
		mont.insertar(300);
		mont.insertar(40);


		mont.mostrarMonticulo();
		System.out.println("\n");
		mont.sacar();
		mont.mostrarMonticulo();
	}

}
