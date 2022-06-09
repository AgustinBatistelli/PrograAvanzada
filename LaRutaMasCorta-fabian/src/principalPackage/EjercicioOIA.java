package principalPackage;

import java.io.File;
import java.io.IOException;

public abstract class EjercicioOIA {

	protected File entrada;
	protected File salida;

	public EjercicioOIA(File entrada, File salida) {
		this.entrada = entrada;
		this.salida = salida;
	}

	public abstract void resolver() throws IOException;
}