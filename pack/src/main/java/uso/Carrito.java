package uso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import productos.Producto;


public class Carrito {
	private LinkedList<Producto> listaItems = new LinkedList<Producto>();

	public Carrito() {
	}

	public void agregar(Producto prod) {
		listaItems.add(prod);
	}

	public double calcularTotal() {
		double suma = 0;
		for (int i = 0; i < listaItems.size(); i++) {
			suma += listaItems.get(i).getPrecio();
		}

		return suma;
	}

	public void generarFactura() {
		
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		System.out.println("**************************************************");
		System.out.printf("%28s\n", "SHOP NAME");
		System.out.printf("%36s\n", "Adress: lorem , " + date.format(formatter));
		System.out.printf("%30s\n", "Telp: 11223344");
		System.out.println("**************************************************");
		System.out.printf("%28s\n", "Cash Receipt");
		System.out.println("**************************************************");
		
		for (int i = 0; i < listaItems.size(); i++) {
			System.out.printf( "%-30.20s %19.2f \n",listaItems.get(i).getNombreArticulo(),listaItems.get(i).getPrecio());
		}
		System.out.printf("%-44.20s %.2f\n", "Total",calcularTotal() );
	}

}
