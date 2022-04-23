package lab;

public class PackRegalo extends Pack {
		
	public PackRegalo(String nombrePack) {
		super(0, nombrePack);
	}
	
	@Override
	protected void agregarProducto(Producto prod) {	
		this.listaProductos.add(prod);
		this.precioFinal+= prod.precioFinal;
	}
	@Override
	protected void agregarProducto(Producto prod, boolean esGratis) {
		
		Producto agrego = new Producto(prod.precioFinal, prod.nombreArticulo);
		if ( ! esGratis ) {
			agrego.precioFinal = 0;
		}
		
		System.out.println("Hola soy gratis" + esGratis);
		
		
		this.listaProductos.add(agrego );
		this.precioFinal+= agrego.precioFinal;
	}
	
}