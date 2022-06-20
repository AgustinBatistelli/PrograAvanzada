package monticulo;

import java.util.ArrayList;

public class Monticulo {
	private ArrayList<Integer> array = new ArrayList<Integer>();

	public Monticulo() {
		array.add(0, null);
	}

	public void insertar(int elemento) {

		array.add(elemento);

		int indiceElemNuevo = array.size() - 1; // -1 xq en la pos 0 esta el null.
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
		if (tamArray == 1) {
			System.out.println("No hay elementos para sacar del monticulo");
			return -1;
		}
		int elemSacar = array.get(1); // elemento que voy a sacar del monticulo.

		int indiceRaiz = 1; // posiciono el ult elem del array en la primer posicion (o sea es la nueva raiz).
		int valorRaiz = array.get(tamArray - 1);
		array.set(1, valorRaiz);

		array.remove(tamArray - 1); 		// saco el elemento del final
		tamArray--;

		int indiceHijoIzq = indiceRaiz * 2; // obtengo los indices.
		int indiceHijoDer = indiceRaiz * 2 + 1;

		while (indiceRaiz < tamArray && indiceHijoIzq < tamArray) { // si tengo un hijo al menos...
			// analizo si el valor de la raiz es mayor a algun hijo.
			Integer valorHijoIzq = tamArray > indiceHijoIzq ? array.get(indiceHijoIzq) : null; // obtengo el valor si
																								// existe..
			Integer valorHijoDer = tamArray > indiceHijoDer ? array.get(indiceHijoDer) : null;

			if (valorRaiz > valorHijoIzq || valorHijoDer != null && valorRaiz > valorHijoDer) {
				if (valorHijoIzq < valorRaiz || valorHijoDer == null) {
					array.set(indiceHijoIzq, valorRaiz); // elem tiene que intercambiar con el h izq
					array.set(indiceRaiz, valorHijoIzq);
					indiceRaiz = indiceRaiz * 2;
				} else {
					array.set(indiceHijoDer, valorRaiz); // tengo que intercambiar con el de la derecha..
					array.set(indiceRaiz, valorHijoDer);
					indiceRaiz = indiceRaiz * 2 + 1;
				}
			}
			indiceHijoIzq = indiceRaiz * 2; // obtengo los indices.
			indiceHijoDer = indiceRaiz * 2 + 1;
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
