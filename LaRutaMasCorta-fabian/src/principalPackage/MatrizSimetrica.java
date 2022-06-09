package principalPackage;

public class MatrizSimetrica {

	private boolean[] matrizSimetrica;
	private int ordenMatriz;
	private int dimensionVector;

	public MatrizSimetrica(int n) {
		this.ordenMatriz = n;
		this.dimensionVector = (n * n - n) / 2;
		matrizSimetrica = new boolean[this.dimensionVector];

		for (int i = 0; i < n - 1; i++)
			matrizSimetrica[i] = false;
	}

	public void ponerArista(int indice) {
		matrizSimetrica[indice] = true;
	}

	public boolean hayArista(int indice) {
		return matrizSimetrica[indice];
	}

	public int getIndice(int fil, int col) {
		return (int) (fil * this.ordenMatriz + col - (Math.pow(fil, 2) + 3 * fil + 2) / 2);
	}

	public void setIndice(int fil, int col) {
		matrizSimetrica[fil * this.ordenMatriz + col - (fil * fil + 3 * fil + 2) / 2] = true;
	}

	public int getOrdenMatriz() {
		return this.ordenMatriz;
	}

	public int getDimension() {
		return this.dimensionVector;
	}
}
