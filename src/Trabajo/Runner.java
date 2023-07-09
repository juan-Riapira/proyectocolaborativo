package Trabajo;
import javax.swing.JOptionPane;
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
				+ "4 Numero Magico\n"
				+ "6 Fechas\n"
				+ "x salir";
	   char option ='0';
		do {
			 option =Character.toUpperCase(JOptionPane.showInputDialog(menu).charAt(0));
			switch(option) {
			   case '1' :
				   break;
			   case '2':
				   
				   break;
			   case '3' :
				   break;
				 
			   case '4' :
				   break;
			   case '5' :
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
	
	
	
	
}
