package es.cip.yerayplasenciaramos.ut02;

/**
 * Cajero:
 * Clase principal del programa.
 * 
 * */

public class Cajero {

	public static void main(String[] args) throws InterruptedException{
		
		final int NUM_OPERACIONES = 10;
		final long denominaciones[] = {5, 20};
		long billetes[] = new long[ denominaciones.length ];
		
		Cuenta cuenta = new Cuenta (100);

		int cantidad = 0;
		
		Thread[] cliente1_ingresa  = new Thread[NUM_OPERACIONES];
		Thread[] cliente2_retira   = new Thread[NUM_OPERACIONES];
		Thread[] cliente3_retira   = new Thread[NUM_OPERACIONES];
		
		System.out.println("Saldo Cuenta Inicial: " + cuenta.getSaldo());
		
		 for (int i=0; i<NUM_OPERACIONES;i++){
			 
			 Cliente cliente1 = new Cliente (cuenta, 10);
			 cliente1_ingresa[i] = new Thread(cliente1);
			 cliente1_ingresa[i].start();
			 
			 System.out.println("Cliente 1 ingresa: " + cliente1.getCantidad());
			 
		     if(cuenta.sinSaldo()){
		    	 System.out.println("Operación OK");
		    	 System.out.println("Saldo Cuenta 1: " + cliente1.cuenta.getSaldo());
			 }else {
				 System.out.println("Operación KO");
				 System.out.println("Cuenta Bloqueada: " + cuenta.getSaldo());
				 System.exit(0);
			}
			 
		     cantidad = (int) (Math.random() * (20 + 1 - 5) + 5);
		     
			 Cliente cliente2 = new Cliente (cuenta, -cantidad);
			 cliente2_retira[i] = new Thread(cliente2);
			 cliente2_retira[i].start();
			 
			 System.out.println("Cliente 2 retira: " + Math.abs(cliente2.getCantidad()));
			 
		     if(cuenta.sinSaldo()){
				System.out.println("Operación OK");
				System.out.println("Saldo Cuenta: " + cuenta.getSaldo());
			 }else {
				System.out.println("Operación KO");
				System.out.println("Cuenta Bloqueada: " + cuenta.getSaldo());
				System.exit(0);
			 }
		     
		     cantidad = (int) (Math.random() * (20 + 1 - 5) + 5);
		     
		     Cliente cliente3 = new Cliente (cuenta, -cantidad);
			 cliente3_retira[i] = new Thread(cliente3);
			 cliente3_retira[i].start();
			 
			 System.out.println("Cliente 3 retira: " +  Math.abs(cliente3.getCantidad()));
			 
			 if(cuenta.sinSaldo()){
				System.out.println("Operación OK");
				System.out.println("Saldo Cuenta: " + cuenta.getSaldo());
			 }else {
				System.out.println("Operación KO");
				System.out.println("Cuenta Bloqueada: " + cuenta.getSaldo());
				System.exit(0);
			 }
		 }
	}
}
