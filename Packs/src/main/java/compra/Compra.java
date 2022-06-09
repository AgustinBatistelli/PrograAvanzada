package compra;

import java.util.ArrayList;
import java.util.List;

import item.Articulo;
import item.Pack;

public class Compra {

	private List<Articulo> articulos = new ArrayList<Articulo>();
	private List<Pack> packs = new ArrayList<Pack>();
	
	public void agregar(Articulo articulo) {
		this.articulos.add(articulo);
	}
	
	public void agregar(Pack pack) {
		this.packs.add(pack);
	}
	
	public int totalizar() {
		return 0;
	}
}
