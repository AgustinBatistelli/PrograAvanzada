package lab;

public class PackPrecioFijo extends Pack {
	
	public PackPrecioFijo(double precioFijo, String nombrePack) {
		super(precioFijo, nombrePack);
	}
	
	@Override
	protected void agregarProducto(Producto prod) {
		this.listaProductos.add(prod);
	}
}
