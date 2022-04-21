package lab;

public class PackDescuento extends Pack{
	private double porcentajeDescuento;

	public PackDescuento(double descuento, String nombrePack) {
		super(0, nombrePack); // en primer momento no se cuanto vale el precio.
		this.porcentajeDescuento = descuento;
	}
	
	@Override
	protected void agregarProducto(Producto prod) {
		Producto agrego = new Producto(prod.precioFinal, prod.nombreArticulo);
		agrego.precioFinal *= (100 - this.porcentajeDescuento)/100; //primero corrijo el precio.
		this.listaProductos.add(agrego);
		this.precioFinal+= agrego.precioFinal; // voy guardando el precio final de a poco..
	}

}
