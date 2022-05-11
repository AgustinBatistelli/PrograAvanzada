package mesadas_granito;

public class Deposito {

	private Mesada[] mesadas;
	private int cantidadMesadas;

	public Deposito(int _cantidadMesadas) {
		this.cantidadMesadas = _cantidadMesadas;
		this.mesadas = new Mesada[cantidadMesadas];
	}

	public void agregarMesada(Mesada mesada) {
		boolean bandera = true;
		for (int i = 0; i < mesadas.length & bandera; i++) {
			if(mesadas[i] == null) {
				mesadas[i] = mesada;
				bandera = false;
			}
		}
	}

    public int resolver() {
		int acum = 0;
		boolean huboCambio = false;

		ordenarLargo();
		ordenarAnchoYLargo();

		for (int i = 0; i < mesadas.length; i++) {
			huboCambio=false;
			if (mesadas[i] != null) {
				Mesada pivote = mesadas[i];

				for (int j =0; j < mesadas.length; j++) {

					if (mesadas[j] != null) {
						if (mesadas[j].sePuedeApilar(pivote)) {
							pivote = mesadas[j];
							mesadas[j] = null;
							huboCambio=true;
						}
					}
				}			
				if (huboCambio)
					acum++;
			}
		}
		return acum;
    }

	private void ordenarAnchoYLargo() {
		Mesada aux;
		for (int i = 0; i < this.mesadas.length -1; i++) {
			for (int j = 0; j < this.mesadas.length -1; j++) {
				if(this.mesadas[j].getLargo() == this.mesadas[j+1].getLargo() &&
						(this.mesadas[j].getAncho() < this.mesadas[j+1].getAncho())) {
					aux = this.mesadas[j];
					this.mesadas[j] = this.mesadas[j+1];
					this.mesadas[j+1] = aux;
				}
			}			
		}
	}

	private void ordenarLargo() {
		Mesada aux;
		for (int i = 0; i < this.mesadas.length -1; i++) {
			for (int j = 0; j < this.mesadas.length -1; j++) {
				if(this.mesadas[j].getLargo() < this.mesadas[j+1].getLargo()) {
					aux = this.mesadas[j];
					this.mesadas[j] = this.mesadas[j+1];
					this.mesadas[j+1] = aux;
				}
			}			
		}
	}

	




}
