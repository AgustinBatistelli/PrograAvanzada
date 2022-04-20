package item;

public class PackFijo extends Pack {

	
	public PackFijo(double descuento) {
		
		for(Articulo a : this.articulos) {
			this.precio -= a.precio;
		}
		
	}

	@Override
	public double getPrecio() {
		return this.precio;
	}

}
