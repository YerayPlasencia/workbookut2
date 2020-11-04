package es.cip.yerayplasenciaramos.ut02;

/**
 * Cliente
 * 
 * */

public class Cliente extends Thread{
	
	Cuenta cuenta;

    public Cliente (Cuenta cuenta) {
    	this.cuenta = cuenta;
    }
    
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
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
	    	 cantidad = (int) (Math.random()*(100 + 1 - 5) + 5);
	    	 if(esMultiplo(cantidad)){
		         valido = true;
		     }
	     }
		return cantidad;
	}
	
	@Override
    public void run() {
		while (cuenta.conSaldo()){
			if(!Thread.currentThread().getName().equals("Cliente1")) {
				cuenta.hacerMovimiento(-cantidadValida());
			}else {
				int cantidad = 10;
				cuenta.hacerMovimiento(cantidad);
			}		
			try {     
				sleep(1);   
			} catch ( InterruptedException e ) {     
				//TODO Excepcion    } 
			}
		}
		if(!cuenta.conSaldo()) {
			System.out.println("Cuenta Bloqueada, SALDO: " + cuenta.getSaldo());
			System.exit(0);
		}
    }
}
