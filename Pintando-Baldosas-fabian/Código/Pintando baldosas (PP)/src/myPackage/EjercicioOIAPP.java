package myPackage;

import java.io.File;

public abstract class EjercicioOIAPP {

	protected File entrada;
	protected File salida;

	public EjercicioOIAPP(File entrada, File salida) {
		this.entrada = entrada;
		this.salida = salida;
	}
	
	public abstract boolean probar();
	
}