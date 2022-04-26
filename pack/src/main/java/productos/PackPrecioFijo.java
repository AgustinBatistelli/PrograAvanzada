package productos;

public class PackPrecioFijo extends Pack {
	
	public PackPrecioFijo(double precioFijo, String nombrePack) {
		super(precioFijo, nombrePack);
	}
	
	@Override
	public void agregarProducto(Producto prod) {
		this.listaProductos.add(prod);
	}
}
