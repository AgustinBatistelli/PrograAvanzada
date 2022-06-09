package myPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Probador extends EjercicioOIAPP {

	private Map<Object, Integer> map;

	private String baldosas;
	private String pintadas;

	private int[] cantColores;

	public Probador(File entrada, File salida) {
		super(entrada, salida);
		this.map = new HashMap<Object, Integer>();
		map.put('R', 0);
		map.put('V', 1);
		map.put('A', 2);
		this.cantColores = new int[3];
		try {
			Scanner scan = new Scanner(entrada);
			this.baldosas = scan.nextLine();
			scan.close();
			scan = new Scanner(salida);
			this.pintadas = scan.nextLine();
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean probar() {
		char colorAnt = 'X';
		char color;
		int i = 0;
		int cantPorColor = this.baldosas.length() / 3;

		do {
			color = this.baldosas.charAt(i);
			i++;
		} while (color == '*');

		if (this.pintadas.charAt(i - 1) != color)
			return false;

		i = 0;
		do {
			color = this.pintadas.charAt(i);
			if (color != 'R' && color != 'V' && color != 'A')
				return false;
			if (color == colorAnt)
				return false;
			this.cantColores[this.map.get(color)]++;
			colorAnt = color;
			i++;
		} while (i < this.pintadas.length());

		for (int j : this.cantColores) {
			if (j != cantPorColor)
				return false;
		}

		return true;
	}

}
