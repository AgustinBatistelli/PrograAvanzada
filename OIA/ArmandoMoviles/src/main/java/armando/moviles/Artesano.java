package armando.moviles;

import java.util.List;

public class Artesano {
	
	private List<Colgante> listaColgantes;
	private String resultado;
	
	public Artesano(List<Colgante> listaColgantes) {
		this.listaColgantes = listaColgantes;
		this.resultado = "";
	}

	public void resolver() {
		
		int sumaPesos = 0;
		int cantPesosAUsar = 0;
		
		for(int i = 0; i < listaColgantes.size(); i++) {
			
			for(int j = i+1; j < listaColgantes.size(); j++) {
				
				if(listaColgantes.get(i).getPeso() == listaColgantes.get(j).getPeso()) {
					sumaPesos += listaColgantes.get(i).getPeso() + listaColgantes.get(j).getPeso();
					cantPesosAUsar++;
				}
					
				
			}
			
		}
		
		if(sumaPesos != 0 || cantPesosAUsar != 0)
			this.resultado = "" + sumaPesos + " " + cantPesosAUsar;
		
		else
			this.resultado = "no se puede";
		
	}
	
	public String getResultado() {
		return this.resultado;
	}

}
