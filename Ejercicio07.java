package main.java.ejercicios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/*
Consigna
1. Escribir un archivo de entre 10 mil y 20 mil números enteros aleatorios, en el rango de 0 a 12000. 
(La cantidad de números debe ser aleatoria)
2. Leer dicho archivo, buscando (a) máximo, (b) mínimo, (c) promedio.
3. Escribr un segundo archivo con una tabla de resultados.
 * */

public class Ejercicio07 {
	
	
	public void crearArchivo() {
		try {
			
			File f = new File("./archivos/archivoNrosRandoms.txt");
			//Verificar si existe el archivo.
			if (!f.exists()) {
				f.createNewFile();//Crear archivo.
			}
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			
			int cantNumeros = getRandom(10000, 20000);
			
			for(int i = 1; i < cantNumeros; i++) {
				int regRandom = getRandom(0, 12000);
				bw.write(regRandom + "\n");
			}
			bw.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int getRandom(int valMin, int valMax) {
	int randomNum = (int) (Math.random() * ( valMax - valMin ));
	return randomNum;
	}
	
	public void resolver() {
		
		try {
			//Abro el archivo generado y lo levanto en memoria con scanner..
			File fLeo = new File("./archivos/archivoNrosRandoms.txt");
			Scanner refArch = new Scanner(fLeo);		
			int []valores = calcularMinMaxProm(refArch);
			int min = 0;
			int max = 1;
			int prom = 2;
			
			//Genero archivo salida..
			File fEscrivo = new File("./archivos/archivoNrosRandomsSalida.txt");
			FileWriter fw = new FileWriter(fEscrivo);
			BufferedWriter escrituraSalida = new BufferedWriter(fw);
			
			escrituraSalida.write("+----------+-------+\n");
			escrituraSalida.write(String.format("| Máximo   | %5d |\n", valores[max]));
			escrituraSalida.write("+----------+-------+\n");
			escrituraSalida.write(String.format("| Mínimo   | %5d |\n", valores[min]));
			escrituraSalida.write("+----------+-------+\n");
			escrituraSalida.write(String.format("| Promedio | %5d |\n", valores[prom]));
			escrituraSalida.write("+----------+-------+");
			
			refArch.close();
			escrituraSalida.close();
			System.out.println("Archivo creado de tabla correctamente");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public int[] calcularMinMaxProm(Scanner refArch) {
		int []resultados = new int[3];
		int numRandom = refArch.nextInt();
		int max = numRandom,
			min = numRandom,
			suma = 0,
			cantNumeros = 0;

		while(refArch.hasNextInt()) {
			numRandom = refArch.nextInt();
			if(numRandom > max) {
				max = numRandom;
			}
			
			if(numRandom < min) {
				min = numRandom;
			}
			suma += numRandom;
			cantNumeros++;
		}
		resultados[0] = min;
		resultados[1] = max;
		resultados[2] = suma/cantNumeros;
		
		return resultados;
	}
	
	
	public static void main(String[] args) {
				
		Ejercicio07 eje = new Ejercicio07();
		
		eje.crearArchivo();
		eje.resolver();
		
	}

}
