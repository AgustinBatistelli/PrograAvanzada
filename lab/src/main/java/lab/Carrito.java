package lab;

public class Carrito {
	private Producto[] arrayProductos;
	
	public Carrito(){
		
	}
	
	public double calcularTotal(){
		double suma = 0;
		for(int i = 0 ; i < arrayProductos.length ; i++){
			suma += arrayProductos[i].getPrecio();
		}
		return suma;
	}
}
