package Trabajo;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
				+ "1. Numero romano\n"
				+ "2. Factores Primos\n"
				+ "3. Borrar Espacios\n"
				+ "4. Numeros Egolotras\n"
				+ "5. Numero Magico\n"
				+ "6. Fechas\n"
				+ "x. salir";
	   char option ='0';
		do {
			 option =Character.toUpperCase(JOptionPane.showInputDialog(menu).charAt(0));
			switch(option) {
			   case '1' :
				   numeroRomano ();
				   break;
			   case '2':
				   PrimeFactors(); 
				   break;
			   case '3' :
				   eliminarEspacios ();
				   break;
				 
			   case '4' :
				   opcion4();
				   break;
			   case '5' :
				   numberMagic();
				   break;
			   case '6' :
				   generarFormatoDeFecha ();
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
	 
 public static void numeroRomano () {
			boolean salir = true;
			
			do {
			
			try {
			
			 String number =JOptionPane.showInputDialog(null,"Ingrese el numero en Romano:" );
			 number = number.toUpperCase();
			 int entero = romanToInt(number);
			 JOptionPane.showMessageDialog(null,"NUMERO ENTERO: "+entero );
			 salir = false;
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null,"--- Error ---\nIngrese un numero valido");
		      
			}
			
			}while(salir != false);
		}
			
			
			
			
			

		public static int romanToInt (String s) {
			
			int resultado = 0;
			int length = s.length();
			
			Map<Character,Integer> romanM = getRomaMap();
			
			for (int i = 0; i<length -1 ; i++) {
				
				int currentValue = romanM.get(s.charAt(i));
				
				if(currentValue < romanM.get (s.charAt(i +1))) {
					resultado-= currentValue;
					
				}else {
					resultado+=currentValue;
				}
				
			}
			
			return resultado +romanM.get(s.charAt(length-1));
			
			}

		public static Map<Character,Integer> getRomaMap(){
			
			Map<Character,Integer> roman = new HashMap<Character, Integer>();
			roman.put('I', 1);
			roman.put('V', 5);
			roman.put('X', 10);
			roman.put('L', 50);
			roman.put('C', 100);
			roman.put('D', 500);
			roman.put('M', 1000);
			
			return roman;
			
			
		}
	 
	 
	 
	 
	 
	 private static void opcion4() {
		 
		 Scanner sc = new Scanner (System.in);
			
			int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el numero que desea comprobar"));
			
			 if (Egolatra.esEgolatra(numero)==true)  {
				JOptionPane.showMessageDialog(null," El numero es egolatra\n"+ numero);
				

			 }else {
				 JOptionPane.showMessageDialog(null,"El numero no es egolatra\n "+ numero);
				 
			 }

				do {
			 	int num =Integer.parseInt(JOptionPane.showInputDialog("Digite el valor a evaluar"));
				
			 	if (Egolatra.esEgolatra(num)==true)  {
			 		JOptionPane.showMessageDialog(null, "El numero es egolatra");
				 
			 	}else {
			 		JOptionPane.showMessageDialog(null,  "El numero no es egolatra");
			 	}
			 	 int optionOne=JOptionPane.showConfirmDialog(null, "ingresar otro numero","salir o repetir ",JOptionPane.YES_NO_CANCEL_OPTION);
				   
				   if(optionOne != JOptionPane.YES_OPTION) {
					   break; 
					   
				   }
	   }while(true);

		

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
	
	
	private static  void generarFormatoDeFecha () {     
		 int dia,mes,año;
		         int op =0 ,salir = 0;
		      
		         
		        String  m [] = {"Enero" ,"Febrero" , "Marzo" , "Abril" , "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre","Diciembre"};
		         
		         Scanner entrada = new Scanner(System.in);
		         JOptionPane.showMessageDialog(null,"<<<<< BIENVENIDO >>>>>\n\nPrograma para ingresar fecha y mostra en formado\n dd de mes del aaaa");
		                 
		        
		         do{
		         
		         try{
		           int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"     MENU      \n\n1.Ingresar fecha \n2.Finalizar\n\n ingrese opcion:" ) );
		
		      switch (opcion)   {
		         case 1:
		         
		         
		         dia = Integer.parseInt(JOptionPane.showInputDialog(null," ACONTINUACION INGRESE LA FECHA\n\nIngrese el dia en # :" ) );
		        
		         mes = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el mes en # :" ) );
		        
		         año = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el Años en # :" ) );
		         
		         do{
		         
		         if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
		             
		             if (dia > 31){
		              JOptionPane.showMessageDialog(null,"--- Error ---:");
		              
		              dia =   Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el dia VALIDO:" ) );
		             }else {
		                JOptionPane.showMessageDialog(null,"--- Exito ---\nFecha correcta:");
		             
		                op = 1; 
		                 
		             }
		             
		         }else {
		             if( mes == 4 || mes == 6 || mes == 9 || mes ==11){
		                 
		               if (dia > 30){
		              JOptionPane.showMessageDialog(null,"--- Error ---:");
		              
		              dia = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el dia VALIDO:" ) ); 
		             }else {
		              JOptionPane.showMessageDialog(null,"--- Exito ---\nFecha correcta:");
		            
		                op = 1; 
		                 
		             }
		                 
		                 
		             }else {
		                 if(mes == 2){
		                     
		              if (dia > 28){
		              JOptionPane.showMessageDialog(null,"--- Error ---");
		               
		                dia =  Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el dia VALIDO:" ) );
		               }else {
		                 JOptionPane.showMessageDialog(null,"--- Exito ---\nFecha correcta:");
		              
		                op = 1; 
		                 
		                   }
		            
		               }else {
		                    
		                    JOptionPane.showMessageDialog(null,"--- Error ---");
		                     mes = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un mes VALIDO:" ) );
		                     
		                 }
		             }
		             
		         }
		        
		       }while (op != 1);
		      
		      
		         JOptionPane.showMessageDialog(null,"fecha ingresada: "+ dia +"/"+mes+"/"+año);
		        
		         JOptionPane.showMessageDialog(null,"fecha de Salida: "+ dia +" de "+m[mes-1]+" del "+año);
		       
		         
		           break;
		          case 2:
		             JOptionPane.showMessageDialog(null,"----FIN DEL PROGRAMA-----");
		             
		              salir = 1;
		              break;
		              
		          default:
		              JOptionPane.showMessageDialog(null,"--- Error ---\nIngrese una Opcion valida");
		              break;
		              
		              
		        }
		       }
		         catch(Exception e){
		             
		             JOptionPane.showMessageDialog(null,"--- Error ---\nIngrese OPCION VALIDA");
		                 
		                 
		                 
		                 }
		         }while(salir != 1);
		         
		        

		}
	
	private static void eliminarEspacios () {
		 
        JOptionPane.showMessageDialog(null,"-----PROGRAMA PARA ELIMINAR ESPACIOS EN UNA CADENA DE TEXTO-----");      

        int opcion = 1 ;
        
        do {
         try {
         opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"     MENU      \n\n1.Iniciar la ejecución \n2.Salir del programa\n\n ingrese opcion:" ) );
   
        if ( opcion == 1 || opcion == 2){
           
       switch (opcion){
           case 1:
        String cadena  =  JOptionPane.showInputDialog(null,"Ingrese Cadena con espacios: " );
        cadena = cadena.replaceAll ("\\s+","");
        JOptionPane.showMessageDialog(null,"Cadena sin espacios : \n " +cadena+ "\nLongitud de la cadena: "+cadena.length());
               
               break ;
           case 2:
               JOptionPane.showMessageDialog(null,"<<< Ha finalizado la ejecucion >>>");
             break ;
             
       }
        }else {
            JOptionPane.showMessageDialog(null,"!!!! Ingrese una opcion valida !!!!>");
        }
        
         }catch (Exception e){
             JOptionPane.showMessageDialog(null,"--- Error ---\nIngrese OPCION VALIDA");
         }
           
     }while( opcion != 2);
           
}


	
}	
