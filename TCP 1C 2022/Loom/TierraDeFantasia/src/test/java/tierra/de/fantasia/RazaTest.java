package tierra.de.fantasia;

import static org.junit.Assert.*;

import org.junit.Test;

import raza.Raza;
import raza.RazaMaguin;
import raza.TipoRaza;

public class RazaTest {

	@Test
	public void ataqueBasico() {
		TipoRaza r1 = new RazaMaguin();
		TipoRaza r2 = new RazaMaguin();
		r1.atacar(r2);
		assertEquals(69, r2.getVida());
		assertEquals(132, r1.getVida());
	}
	
	@Test
	public void curar() {
		TipoRaza r1 = new RazaMaguin();
		TipoRaza r2 = new RazaMaguin();
				
		r1.atacar(r2);
		r2.atacar(r1);
		assertEquals(48, r1.getVida());
		assertEquals(109, r2.getVida());
	}
	
	@Test
	public void atacarDespuesDeDescansar() {
		TipoRaza r1 = new RazaMaguin();
		TipoRaza r2 = new RazaMaguin();
				
		r1.descansar();
		r1.atacar(r2);
		
		assertEquals(-57, r2.getVida());
	}
	
	@Test
	public void atacarFueraRango() {
		TipoRaza r1 = new RazaMaguin();
		TipoRaza r2 = new RazaMaguin();
				
		r1.mover(10);
		r1.mover(10);
		r1.mover(10);
		r1.mover(10);
		r1.mover(10);
		
		r1.atacar(r2);
		
		assertEquals(132, r2.getVida());
	}
	
	@Test
	public void pruebaMovimiento() {
		TipoRaza r1 = new RazaMaguin();
		TipoRaza r2 = new RazaMaguin();
		
		r1.mover(10);
		r2.mover(5);
		
		assertEquals(10, r1.getPosicion());
		assertEquals(5, r2.getPosicion());
		
		r1.mover(20);
		r2.mover(-5);
		
		assertEquals(10, r1.getPosicion());
		assertEquals(0, r2.getPosicion());
		
	}	

}
