package mesadas_granito;

import java.util.ArrayList;
import java.util.List;

public class NegocioVenta {

	private List<Mesada> listaMesadas;
	private String resultado;

	public NegocioVenta() {
		this.listaMesadas = new ArrayList<Mesada>();
	}

	public NegocioVenta(List<Mesada> listaMesadas) {
		this.listaMesadas = listaMesadas;
	}

//	public static void main(String[] args) {
//
//		NegocioVenta negocioVenta = new NegocioVenta();
//		try {
//			negocioVenta = negocioVenta.leerArchivo("mesada.in");
//			negocioVenta.resolver();
//			negocioVenta.escribirArchivo("mesada.out");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	public void resolver() {

		int cantMesadasApilables = 0;
		int cantMesadasApilablesMax = 0;

		for(int i = 0; i < this.listaMesadas.size(); i++) {

			for(int j = i+1; j < this.listaMesadas.size(); j++) {

				if(this.listaMesadas.get(j).getAncho() <= this.listaMesadas.get(i).getAncho() &&
						this.listaMesadas.get(j).getLargo() <= this.listaMesadas.get(i).getLargo()) {
					
					cantMesadasApilables++;

				} else {
					
					if(this.listaMesadas.get(j).getLargo() <= this.listaMesadas.get(i).getAncho() &&
							this.listaMesadas.get(j).getAncho() <= this.listaMesadas.get(i).getLargo())

						cantMesadasApilables++;
					
				}
			}

			if(cantMesadasApilables > cantMesadasApilablesMax)
				cantMesadasApilablesMax = cantMesadasApilables;

			cantMesadasApilables = 0;

		}

		resultado = "" + cantMesadasApilablesMax;

	}

	public String getResultado() {
		return resultado;
	}




}
