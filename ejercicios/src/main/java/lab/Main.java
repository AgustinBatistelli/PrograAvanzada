package lab;

public class Main {

	public static void main(String[] args) {
		
		Producto p1 = new Producto(10,"CepilloDientes");
		Producto p2 = new Producto(5,"PastaDental");
		Producto p3 = new Producto(3,"Palta");
		Producto p4 = new Producto(7,"Nachos");
		Producto p5 = new Producto(14,"Queso");
		
		Pack fijo = new PackPrecioFijo(15,"PackCepilloYPasta"); 
		
		fijo.agregarProducto(p1);
		fijo.agregarProducto(p2);
		fijo.agregarProducto(p3);
		
		double precio = fijo.precioFinal;
		
		System.out.println( "Precio del fijo = " + precio);
			
		Pack descuento = new PackDescuento(10, "NachosYQueso");
	
		descuento.agregarProducto(p1);
		descuento.agregarProducto(p2);
		descuento.agregarProducto(p3);
		
		precio = descuento.precioFinal;
		
		System.out.println( "Precio del descuento = " + precio);
		
		Pack regalo = new PackRegalo("pasta y palta gratis");
		
//		regalo.agregarProducto(p1);
//		regalo.agregarProducto(p1, true) ;
		regalo.agregarProducto(p2);
		regalo.agregarProducto(p3, false);
		
		precio = regalo.precioFinal;
		
		System.out.println( "Precio del descuento = " + precio);
		
		Carrito carrito = new Carrito();
		
		carrito.agregar(p1);
		carrito.agregar(p2);
		carrito.agregar(p1);
		
		carrito.generarFactura();
		
		
		// darle formato y ver el encapsulamiento xq nos dejaba acceder a los atributos desde cualquier clase.
		
	}
}
