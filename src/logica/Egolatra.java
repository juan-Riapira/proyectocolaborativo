package logica;

public class Egolatra {
	
	public static int potencia(int base, int potencia ) {		
		int acumulador = 1;		
		for (int pot = 0;  pot < potencia;  pot++) {		
			acumulador = base*acumulador;		
		}
		return acumulador;
	}
	
	public static boolean esEgolatra(int numero) {	
		String numer = Integer.toString(numero);
		int acumulador = 0; 
		 for (int posicion = 0; posicion < numer.length(); posicion++ ) {
			 int num = Integer.parseInt(""+ numer.charAt(posicion));
			 int elevador = Egolatra.potencia(num, numer.length());
			 acumulador = elevador + acumulador;
		 }
		 			 
		 return acumulador == numero;
	}
}
