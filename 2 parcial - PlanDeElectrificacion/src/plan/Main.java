package plan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File entrada = new File("ciudades.in");
		File salida = new File("tendido.out");
		PlanElectrico pe = new PlanElectrico(entrada, salida);
		pe.resolver();

		// generarFatiga();
	}

	public static void generarFatiga() {
		int[][] matriz = new int[100][100];

		try {
			BufferedWriter buffer = new BufferedWriter(new FileWriter("preparacion de prueba/lote de prueba/entrada/08_Fatiga.in"));

			for (int i = 0; i < 100; i++) {
				if (i < 99) {
					matriz[i][i + 1] = 1;
					matriz[i + 1][i] = 1;
				}
				for (int j = i + 2; j < 100; j++) {
					matriz[i][j] = 100;
					matriz[j][i] = 100;
				}
			}

			buffer.write(100 + " " + 1);
			buffer.newLine();
			buffer.write(String.valueOf(1));
			buffer.newLine();

			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz.length; j++) {
					buffer.write(matriz[i][j] + " ");
				}
				buffer.newLine();
			}

			buffer.close();
		} catch (IOException e) {
			System.out.println("Error al generar caso de fatiga...");
		}
	}
}
