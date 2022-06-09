package armando.moviles;

import java.util.Comparator;

public class ComparatorColgante implements Comparator<Colgante> {

	public int compare(Colgante o1, Colgante o2) {
		return o1.getPeso() - o2.getPeso();
	}

}
