package tests;

import java.io.FileNotFoundException;

import org.junit.Test;

import codigo.ArchivoElectrificacion;
import codigo.Grafo;

public class ElectrificacionTests {

	@Test
	public void testCasoEnunciado() {
		try {
			Grafo grafo = ArchivoElectrificacion.cargarEntrada("tests/lotes/in/01_CasoEnunciado.in");
			ArchivoElectrificacion.escribirSalida("tests/lotes/out/01_CasoEnunciado.out", grafo.resolver());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUnaCiudadNecesitaElectricidad() {
		try {
			Grafo grafo = ArchivoElectrificacion.cargarEntrada("tests/lotes/in/02_UnaCiudadNecesitaElectricidad.in");
			ArchivoElectrificacion.escribirSalida("tests/lotes/out/02_UnaCiudadNecesitaElectricidad.out", grafo.resolver());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testProfe0() {
		try {
			Grafo grafo = ArchivoElectrificacion.cargarEntrada("tests/lotes/in/0.in");
			ArchivoElectrificacion.escribirSalida("tests/lotes/out/0.out", grafo.resolver());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testProfe1() {
		try {
			Grafo grafo = ArchivoElectrificacion.cargarEntrada("tests/lotes/in/1.in");
			ArchivoElectrificacion.escribirSalida("tests/lotes/out/1.out", grafo.resolver());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testProfe2() {
		try {
			Grafo grafo = ArchivoElectrificacion.cargarEntrada("tests/lotes/in/2.in");
			ArchivoElectrificacion.escribirSalida("tests/lotes/out/2.out", grafo.resolver());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testProfe3() {
		try {
			Grafo grafo = ArchivoElectrificacion.cargarEntrada("tests/lotes/in/3.in");
			ArchivoElectrificacion.escribirSalida("tests/lotes/out/3.out", grafo.resolver());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testProfe4() {
		try {
			Grafo grafo = ArchivoElectrificacion.cargarEntrada("tests/lotes/in/4.in");
			ArchivoElectrificacion.escribirSalida("tests/lotes/out/4.out", grafo.resolver());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testProfe5() {
		try {
			Grafo grafo = ArchivoElectrificacion.cargarEntrada("tests/lotes/in/5.in");
			ArchivoElectrificacion.escribirSalida("tests/lotes/out/5.out", grafo.resolver());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testProfe6() {
		try {
			Grafo grafo = ArchivoElectrificacion.cargarEntrada("tests/lotes/in/6.in");
			ArchivoElectrificacion.escribirSalida("tests/lotes/out/6.out", grafo.resolver());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testProfeX() {
		try {
			Grafo grafo = ArchivoElectrificacion.cargarEntrada("tests/lotes/in/X.in");
			ArchivoElectrificacion.escribirSalida("tests/lotes/out/X.out", grafo.resolver());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
