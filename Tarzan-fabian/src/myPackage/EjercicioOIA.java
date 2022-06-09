package myPackage;

import java.io.IOException;

public class EjercicioOIA {

	private String path;
	
	public EjercicioOIA(String path) {
		this.setPath(path);
	}
	
	public void resolver() throws IOException {
		Tarzan t = new Tarzan("tarzan.in");
		t.dijkstra();
		t.escribirSolucion("tarzan.out");
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
