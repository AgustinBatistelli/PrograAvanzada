package item;

import java.util.List;

public abstract class Pack {
	
	protected List<Articulo> articulos;
	protected double precio;
	
	public boolean agregar(Articulo a) {
		return this.articulos.add(a);
	}
	
	public abstract double getPrecio();

}
