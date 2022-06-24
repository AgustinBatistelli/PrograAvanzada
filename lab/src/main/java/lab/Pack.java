package lab;

public class Pack extends Producto {
	private Producto[] arrProductos;

	public Pack(Producto[] arrProductos) {
		super(0, "pack X");
		this.arrProductos = arrProductos;
		this.precioFinal = this.calcularPrecio();
	}
	
	private double calcularPrecio(){
		double suma = 0;
		for(int i = 0 ; i < arrProductos.length ; i++){
			suma += arrProductos[i].precioFinal;
		}
		return suma;
	}
 
}