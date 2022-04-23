
public class Test {
	boolean esMultiplicacionNula(int[][] matriz) {
		  boolean flag = true;
		  int fila = 0,col;

		  while (fila < matriz.length && flag) {
		    col = 0;
		    while (col < matriz[fila].length && flag) {
		      if (matriz[fila][col] == 0)
		        flag = false;
		      col++;
		    }
		    fila++;
		  }

		  return flag;
		}
	
	public static void main (String[] args) {
		int[][] m = {{1,2,3}, {1,2,3}, {1,2,0}};
		
		Test test = new Test();
		
		System.out.print(test.esMultiplicacionNula(m));
 	}
}