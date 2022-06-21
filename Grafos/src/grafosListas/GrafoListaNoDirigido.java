package grafosListas;

public class GrafoListaNoDirigido extends GrafoLista {

	public GrafoListaNoDirigido(int size) {
		super(size);
	}

	@Override
	public void setArista(int from, int to, double cost) {
		setArista(from, to, cost);
		setArista(to, from, cost);
	}

	@Override
	public Double getArista(int from, int to) {
		if (graph[from].size() < graph[to].size()) {
			return getArista(from, to);
		}
		return getArista(to, from);
	}
}
