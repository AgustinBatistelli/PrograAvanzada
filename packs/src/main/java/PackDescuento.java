package lab;

public class PackDescuento extends Pack{
	private double porcentajeDescuento;

	public PackDescuento(Producto[] arrProductos, double porcentajeDescuento) {
		super(arrProductos);
		this.porcentajeDescuento = porcentajeDescuento;
		this.precioFinal -=  porcentajeDescuento;
	}
	
	
}
