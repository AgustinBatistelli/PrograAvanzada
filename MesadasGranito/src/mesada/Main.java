package mesada;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
//		
//		Deposito dep = new Deposito();
//		
//		Mesada mesa1 = new Mesada(4, 5);
//		Mesada mesa2 = new Mesada(9, 3);
//		Mesada mesa3 = new Mesada(2, 2);
//		Mesada mesa4 = new Mesada(1, 2);
//		Mesada mesa5 = new Mesada(1, 12);
//		Mesada mesa6 = new Mesada(2, 7);
//		
//		dep.agregarMesada(mesa1);
//		dep.agregarMesada(mesa2);
//		dep.agregarMesada(mesa3);
//		dep.agregarMesada(mesa4);
//		dep.agregarMesada(mesa5);
//		dep.agregarMesada(mesa6);
//		
//		dep.mostrarArray();
//		dep.ordernaMesadas();
//		System.out.println();
//		dep.mostrarArray();
//		
//		System.out.println( "La cantidad de pilas minimas son: " + dep.calcularPilas());
		
		final String inputPath = ".\\input\\mesadas.in";
		final String outputPath = ".\\output\\mesadas.out";
		
		Deposito deposito;
		try {
			deposito = GestionArchivo.leerArchivo(inputPath);
			
			deposito.mostrarArray();
			deposito.ordernaMesadas();
			System.out.println();
			deposito.mostrarArray();
			deposito.calcularPilas();
			System.out.println(deposito.getPilasMin());
			GestionArchivo.escribirArchivo(outputPath, deposito);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

		
	}
	
	
	
}
