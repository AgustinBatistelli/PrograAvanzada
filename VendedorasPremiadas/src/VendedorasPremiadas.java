import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class VendedorasPremiadas {
	
	int cantidadVentas = 0;
	int acumuladorVentas = 0;

	public static void main(String[] args) {
		VendedorasPremiadas vp = new VendedorasPremiadas();
		try {
			vp.resolve();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void resolve() throws Exception {

		try {
			File myObj = new File("premio.in");
			Scanner myReader = new Scanner(myObj);

			String path = myObj.getAbsolutePath();
			
			ArrayList<Integer> list = new ArrayList<Integer>();

			while (myReader.hasNextLine()) {
				list.add(Integer.parseInt(myReader.nextLine()));
			}

			int nroVendedoras = list.get(0);

			myReader.close();

		} catch (FileNotFoundException e) {
			throw new Exception("Ocurrio un error al leer el archivo de texto.");
		}
	}

}
