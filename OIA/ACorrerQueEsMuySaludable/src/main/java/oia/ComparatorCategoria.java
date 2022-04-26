package oia;

import java.util.Comparator;

public class ComparatorCategoria implements Comparator<Corredor> {

	public int compare(Corredor c1, Corredor c2) {
		if (c1.getSexo() != c2.getSexo())
			return c1.getSexo() - c2.getSexo();
		
		return c1.getCategoria() - c2.getCategoria();
	}

}
