package productos;

//import java.util.*;

public class Producto {
	protected double precioFinal; // valor 
	protected String nombreArticulo;
	
	public Producto(double precioFinal, String nombreArticulo){
		this.precioFinal = precioFinal;
		this.nombreArticulo = nombreArticulo;
	}
		
	public double getPrecio(){
		return precioFinal;
	}

	public String getNombreArticulo() {
		return nombreArticulo;
	}
	
}

