package es.cip.yerayplasenciaramos.ut02;


/**
 * Cajero:
 * Clase principal del programa.
 * 
 * */

public class Cajero {

	public static void main(String[] args) throws InterruptedException{
		
		Cuenta cuenta = new Cuenta (100);
		
		System.out.println("Saldo Cuenta Inicial: " + cuenta.getSaldo());
		
		 Cliente cliente1 = new Cliente (cuenta);
		 Cliente cliente2 = new Cliente (cuenta);
		 Cliente cliente3 = new Cliente (cuenta);
		 
		 cliente1.setName("Cliente1");
		 cliente2.setName("Cliente2");
		 cliente3.setName("Cliente3");
		 		 
		 cliente1.start();
		 cliente2.start();
		 cliente3.start();
		 
		 try { 
			 cliente1.join();
			 cliente2.join();
			 cliente3.join();
		 } catch (InterruptedException e) { } //TODO exception   
	}
}
