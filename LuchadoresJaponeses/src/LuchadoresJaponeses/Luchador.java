package LuchadoresJaponeses;

public class Luchador {
	private int peso;
	private int altura;
	
	public Luchador(int peso, int altura) {
		this.peso = peso;
		this.altura = altura;
	}
	
	public int dominar(Luchador otroLuchador) { 	
		int ganador;
		
		if ((this.altura > otroLuchador.altura && this.peso < otroLuchador.peso)||
			(this.altura < otroLuchador.altura && this.peso > otroLuchador.peso))
			ganador = 0; // TABLAS!!
		else {	
			if ((this.peso > otroLuchador.peso && this.altura > otroLuchador.altura) ||
				(this.peso == otroLuchador.peso && this.altura > otroLuchador.altura)|| 
				(this.peso > otroLuchador.peso && this.altura == otroLuchador.altura))
					ganador = 1; // GANA EL LUCHADOR LLAMADOR
			else
					ganador = -1; // GANA EL OTRO LUCHADOR
		}
		
		return ganador;
	}
}