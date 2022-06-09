package myPackage;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		EjercicioOIA oia = new EjercicioOIA("tarzan.in");
		try {
			oia.resolver();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
