package Trabajo;
import java.util.Scanner;
import java.util.Arrays;

import javax.swing.JOptionPane;
import logica.Egolatra;
public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		menu();

	}

	
	

	// menu
	
	
	private static void menu() {
		String menu = " ----menu----\n"
				+ "1 Numero romano\n"
				+ "2 Factores Primos\n"
				+ "3 Borrar Espacios\n"
				+ "4 Numeros Egolotras\n"
				+ "5 Numero Magico\n"
				+ "6 Fechas\n"
				+ "x salir";
	   char option ='0';
		do {
			 option =Character.toUpperCase(JOptionPane.showInputDialog(menu).charAt(0));
			switch(option) {
			   case '1' :
				   break;
			   case '2':
				   PrimeFactors(); 
				   break;
			   case '3' :
				   break;
				 
			   case '4' :
				   Runner.opcion4();
				   break;
			   case '5' :
				   numberMagic();
				   break;
			   case '6' :
				   break;
			   case 'X' :
				
				   exitRun();
				   break;
			
			}
			
		}while(option != '1' || option != '2'|| option != '3'|| option != '4'|| option != '5'|| option != '6'|| option != 'x' );

	}
	
	
	 private static void exitRun() {
	        int option = JOptionPane.showConfirmDialog(null,"Esta Segur@","Salir",JOptionPane.YES_NO_OPTION);
	        if( option == JOptionPane.YES_OPTION ){
	            System.exit( 0 );
	        }
	 }
	 
	 private static void opcion4() {
		 Scanner sc = new Scanner (System.in);
			System.out.println("Digite el numero que desea comprobar");
			
			int numero = sc.nextInt();
			
			 if (Egolatra.esEgolatra(numero)==true)  {
				 System.out.printf(" El numero %d es egolatra \n",numero);

			 }else {
				 System.out.printf(" El numero %d no es egolatra \n ",numero);
			 }
	 }
	 
	 // numero magico
	 private static void numberMagic() {
		   do {
			    int numeroUno =Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor"));
		   if (numberMagic(numeroUno)==false) {
			   JOptionPane.showMessageDialog(null,   "El numero no es magico");
		   }else {
			   JOptionPane.showMessageDialog(null,   "El numero es magico ");
		   }
		   
		   int optionOne=JOptionPane.showConfirmDialog(null, "ingresar otro numero","salir o repetir ",JOptionPane.YES_NO_CANCEL_OPTION);
		   
		   if(optionOne != JOptionPane.YES_OPTION) {
			   break; 
		   }
		   
		   }while(true);
		  
	    }
		// numeros magicos
		
		public static boolean numberMagic(int number ) {
			
			// obtener digitos 
			String  convertir =Integer.toString(number);
			int longitudNumero =convertir.length();
			
			int [] digitos = new int[longitudNumero];
			
		
			for (int i=0;i<longitudNumero;i++) {
				digitos[i]=Integer.parseInt(String.valueOf(convertir.charAt(i)));
				
			}
			
			// ordenar ascendente 
			
			int [] ascendente =Arrays.copyOf(digitos, digitos.length);
			Arrays.sort(ascendente);
			
			int numero = 0;

			    for (int i = 0; i < digitos.length; i++) {
			        numero = numero * 10 + ascendente[i];
			    }
			
			
			
			// ordenar decendente
			
	        int [] descendente =Arrays.copyOf(ascendente, digitos.length);
	      

	        for (int i = 0; i < descendente.length / 2; i++) {
	            int temp = descendente[i];
	            descendente[i] = descendente[descendente.length - 1 - i];
	            descendente[descendente.length - 1 - i] = temp;
	        }

			int numero1 = 0;

		    for (int i = 0; i < descendente.length; i++) {
		        numero1 = numero1 * 10 + descendente[i];
		    }  		
			return  (numero1-numero)==number;
		}
		
	
	 // factores primos
		
 private static void PrimeFactors() {
		 
		 do {
			  int numero =Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor"));
		   JOptionPane.showMessageDialog(null, primeFactors(numero));
		   
              int optionOne=JOptionPane.showConfirmDialog(null, "ingresar otro numero","salir o repetir",JOptionPane.YES_NO_CANCEL_OPTION);
		   
		   if(optionOne != JOptionPane.YES_OPTION) {
			   break; 
		   }
		   
		 }while(true);
		
	       
	    }
 
 
 // factores primos
	public  static String primeFactors(int numero) {
		  
		StringBuilder exponen = new StringBuilder();
      
       for (int factor = 2; factor <= numero; factor++) {
       	
       	int exponente=0;
 
              while (numero % factor == 0) {
           	  exponente++;
                   numero =numero/ factor;
                   
               }
              
              if (exponente > 0) {
           	   exponen.append(factor);  
               
              if (exponente>1){
           	   exponen.append("^").append(exponente);
              }
              
              exponen.append(" * ");
           }
        }
       
       if (exponen.length() > 0) {
           exponen.delete(exponen.length() - 3, exponen.length());
      }

       return exponen.toString();
  }
	
	
}	
