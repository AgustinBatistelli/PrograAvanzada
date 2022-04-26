package productos;

import java.util.*; // preguntar xq necesito volve a llamar a la biblioteca.

public abstract class Pack extends Producto {
	protected LinkedList<Producto> listaProductos = new LinkedList<Producto>();
	
	public Pack(double precio, String nombreArticulo) {
		super(precio, nombreArticulo); // tiene que llamar a super.
	}
	
	
	
	public void agregarProducto(Producto prod) {};
	public void agregarProducto(Producto prod, boolean esGratis) {};
	
	
	
}
