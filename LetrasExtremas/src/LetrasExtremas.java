import java.text.Normalizer;
import java.util.ArrayList;

public class LetrasExtremas {
	
	private int cantPalabras;
	private char letraMaxVeces;
	private ArrayList<String> palabrasDondeApareceLetraMaxVeces;
	private ArrayList<String> listaPalabras;
	
	public LetrasExtremas(ArrayList<String> _listaPalabras) {
		this.listaPalabras = _listaPalabras;
	}
	
	public LetrasExtremas() {
		
	}
	
	public char getLetraMaxVeces() {
		return letraMaxVeces;
	}

	public void setLetraMaxVeces(char letraMaxVeces) {
		this.letraMaxVeces = letraMaxVeces;
	}

	public ArrayList<String> getPalabrasDondeApareceLetraMaxVeces() {
		return palabrasDondeApareceLetraMaxVeces;
	}

	public void setPalabrasDondeApareceLetraMaxVeces(ArrayList<String> palabrasDondeApareceLetraMaxVeces) {
		this.palabrasDondeApareceLetraMaxVeces = palabrasDondeApareceLetraMaxVeces;
	}

	public int getCantPalabras() {
		return cantPalabras;
	}

	public void setCantPalabras(int cantPalabras) {
		this.cantPalabras = cantPalabras;
	}

	public ArrayList<String> getListaPalabras() {
		return listaPalabras;
	}

	public void setListaPalabras(ArrayList<String> listaPalabras) {
		this.listaPalabras = listaPalabras;
	}

	public static void main(String[] args) {
		LetrasExtremas lE = new LetrasExtremas();
		lE.resolve();
	}

	private void resolve() {
		int cantPalabras = 6;
		ArrayList<String> palabras = new ArrayList<String>();
		int letraIniApariciones;
		int letraFinApariciones;
		int letraVecesMax = 0;
		char letraQueAparecioMasVeces = '/';
		palabras.add("arbol");
		palabras.add("orden");
		palabras.add("susana");
		palabras.add("otro");
		palabras.add("listo");
		palabras.add("nexos");
		
		this.cantPalabras = cantPalabras;
		this.listaPalabras = palabras;
		
		int j = 0;
		
		for(int i = 0; i < palabras.size(); i++) {
			
			j = i;
			
			letraIniApariciones = 0;
			letraFinApariciones = 0;
			
			while(j < palabras.size()) {
				
				if(!palabras.get(i).isEmpty()) {
					
					letraIniApariciones += contarApariciones(palabras.get(j), 
							palabras.get(i).charAt(0));
					
					letraFinApariciones += contarApariciones(palabras.get(j), 
							palabras.get(i).charAt(palabras.get(i).length() - 1));
				}

				j++;
				
			}

			if(letraIniApariciones > letraFinApariciones) {
				if(letraIniApariciones > letraVecesMax) {
					letraVecesMax = letraIniApariciones;
					letraQueAparecioMasVeces = (char) palabras.get(i).charAt(0);
				}
					
			} else {
				if(letraFinApariciones > letraVecesMax) {
					letraVecesMax = letraFinApariciones;
					letraQueAparecioMasVeces = (char) (palabras.get(i).charAt(palabras.get(i).length() - 1));
				}
			}
		}
		
		this.letraMaxVeces = letraQueAparecioMasVeces;
		palabrasDondeApareceLetraMaxVeces = buscarListaPalabrasDeLetraQueMasSeRepitio(palabras, letraQueAparecioMasVeces);
		this.setPalabrasDondeApareceLetraMaxVeces(palabrasDondeApareceLetraMaxVeces);
		imprimirResultado(letraQueAparecioMasVeces, palabrasDondeApareceLetraMaxVeces);
	}
	
	private void imprimirResultado(char letraQueAparecioMasVeces,
			ArrayList<String> list) {
		
		System.out.println(letraQueAparecioMasVeces);
		for(String p : list) {
			System.out.println(p);
		}
	}

	public String eliminarAcentos(String s) 
	{
	    s = Normalizer.normalize(s, Normalizer.Form.NFD);
	    s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
	    return s;
	}
	
	public ArrayList<String> buscarListaPalabrasDeLetraQueMasSeRepitio(ArrayList<String> palabras, char c) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		for(String p : palabras) {
			
			if(!p.isEmpty()) {
				if(p.charAt(0) == c || p.charAt(p.length() - 1) == c)
					list.add(p);
			}
				
		}
		
		return list;
	}

	public int contarApariciones(String palabra, char c) {
		int count = 0;
		
		palabra = eliminarAcentos(palabra);

	    for(int i = 0; i < palabra.length(); i++)
	    {    
	    	if(palabra.charAt(i) == c)
	            count++;
	    }

	    return count;
	}
}
