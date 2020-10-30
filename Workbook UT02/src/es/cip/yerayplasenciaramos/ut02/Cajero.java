package es.cip.yerayplasenciaramos.ut02;

/**
 * Cajero:
 * Clase principal del programa.
 * 
 * */

public class Cajero {
	
	private static boolean esMultiplo(int cantidad) {
		if (cantidad % 5 == 0){
            return true;
        }else{
            return false;
        }
	}
	
	private static int cantidadValida() {
		int cantidad = 0;
		boolean valido = false;
		
	     while (valido!=true) {
	    	 cantidad = (int) (Math.random()*(50 + 1 - 5) + 5);
	    	 if(esMultiplo(cantidad)){
		         valido = true;
		     }
	     }
		return cantidad;
	}
	
	public static void main(String[] args) throws InterruptedException{
		
		final int NUM_OPERACIONES = 10;
		
		Cuenta cuenta = new Cuenta (100);
		
		System.out.println("Saldo Cuenta Inicial: " + cuenta.getSaldo());
		
		 for (int i=0; i<NUM_OPERACIONES;i++){
			 
			 if(!cuenta.conSaldo()) {
				 System.out.println("Operación KO");
				 System.out.println("Cuenta Bloqueada: " + cuenta.getSaldo());
				 System.exit(0);
			 }
			 
			 Cliente cliente1 = new Cliente (cuenta, 10);
			 cliente1.start();
			 
			 System.out.println("Cliente 1 ingresa: " + cliente1.getCantidad());
			 
			 Cliente cliente2 = new Cliente (cuenta, -cantidadValida());
			 cliente2.start();
			 
			 System.out.println("Cliente 2 retira: " + Math.abs(cliente2.getCantidad()));
			 
		     Cliente cliente3 = new Cliente (cuenta, -cantidadValida());
		     cliente3.start();
			 
			 System.out.println("Cliente 3 retira: " +  Math.abs(cliente3.getCantidad()));
		 }
	}
}
