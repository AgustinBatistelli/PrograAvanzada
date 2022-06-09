package item;

public class PackDescuento extends Pack {

	public PackDescuento(double descuento) {
		
		for(Articulo a : this.articulos) {
			this.precio += a.precio;
		}
		
		this.precio *= (descuento / 100);
	}

	@Override
	public double getPrecio() {
		return this.precio;
	}
}
