package packs;

import static org.junit.Assert.*;

import org.junit.Test;

import compra.Compra;
import item.Articulo;
import item.Pack;
import item.PackDescuento;
import item.PackFijo;

public class CompraTest {

	@Test
	public void test() {
		Compra compra = new Compra();
		
		Articulo a1 = new Articulo("banana", new Double(10));
		
		Pack packDescuento = new PackDescuento(30);
		
		Pack packFijo = new PackFijo(10);
		
		Articulo a2 = new Articulo("pera", new Double(30));
		
		compra.agregar(a1);
		compra.agregar(packDescuento);
		compra.agregar(packFijo);
		compra.agregar(a2);
	}

}
