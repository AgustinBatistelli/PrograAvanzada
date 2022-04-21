package lab;

import java.util.LinkedList;

public class Carrito {
	private LinkedList<Producto> listaItems = new LinkedList<>();

	public Carrito() {
	}

	public void agregar(Producto prod) {
		listaItems.add(prod);
	}

	public double calcularTotal() {
		double suma = 0;
		for (int i = 0; i < listaItems.size(); i++) {
			suma += listaItems.get(i).precioFinal;
		}

		return suma;
	}

	public void generarFactura() {

		for (int i = 0; i < listaItems.size(); i++) {
			System.out.println("Nombre producto: " + listaItems.get(i).nombreArticulo + "--------------------" + listaItems.get(i).precioFinal);
		}
		System.out.println("Total ----------------" + calcularTotal() );
	}

}