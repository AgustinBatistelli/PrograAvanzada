package pateando.al.arco.oia;

public class Robot {
	
	private String resultado;
	private Arco arco;
	
	public Robot(Arco c) {
		this.arco = c;
	}
	
	public void arco() {
		if(this.arco.esPaloOTravesanio())
			this.resultado = "PALO";
		else if(this.arco.esGol())
			this.resultado = "GOL";
		else
			this.resultado = "AFUERA";
	}

	public String getResultado() {
		return resultado;
	}

	public void resolver() {
		arco();
	}

}
