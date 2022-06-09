package main;

import java.util.Comparator;

public class DoubleComparator implements Comparator<Mesadas>{
	
	@Override
	public int compare(Mesadas m2, Mesadas m1) {
		int resultado = 0;
		resultado = m1.getA() - m2.getA();
		if(resultado == 0) {
			resultado = m1.getB() - m2.getB();
		}
		return resultado;
	}
}
