package main;

import java.util.ArrayList;
import java.util.Collections;

public class Negocio {

	int cantpilas = 0;
	int cantMesadas;

	public int apilar(ArrayList<Mesadas> lista) {
		lista.sort(new DoubleComparator());//O(n*log(n))
		ArrayList<Mesadas> pila = new ArrayList<>(Collections.emptyList());//O(1)
		this.cantMesadas = lista.size();//O(1)
		int j = 0;//O(1)
		boolean apila = false;//O(1)
		while (!lista.isEmpty()) {//O(n)
			if (pila.isEmpty()) {//O(1)
				cantpilas++;//O(1)
				pila.add(lista.get(0));//O(1)
			}
			j = 0;//O(1)
			while (j < pila.size() && !apila) {//O(n)
				if (((pila.get(j).getA() >= lista.get(j).getA()) && (pila.get(j).getB() >= lista.get(0).getB()))
						|| ((pila.get(j).getA() >= lista.get(0).getB())
								&& (pila.get(j).getB() >= lista.get(0).getA()))) {//O(1)
					pila.set(0, lista.get(0));//O(1)
					lista.remove(0);//O(1)
					apila = true;//O(1)
				}
				j++;//O(1)
			}
			if (!apila) {
				cantpilas++;//O(1)
				pila.add(lista.get(0));//O(1)
			} else {
				apila = false;//O(1)
			}
		}
		return cantpilas;//O(1)
	}
	//Por regla de la suma se tienn las siguientes complejidades 
	
	//O(n*log(n))
}
