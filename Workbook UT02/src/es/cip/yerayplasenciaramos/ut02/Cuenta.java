package es.cip.yerayplasenciaramos.ut02;

/**
 * Cuenta
 * 
 * */

public class Cuenta {
	
	private int saldo;
	
	public Cuenta(int saldo){
		this.saldo = saldo;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	public synchronized void hacerMovimiento(int cantidad){
		if (saldo + cantidad >=0){
			System.out.println("Operación: " + cantidad);	
			this.saldo = this.saldo + cantidad;
		}else{
			System.out.println("Operación: " + cantidad + " >> AVISO: No hay dinero suficiente para retirar, indique otra cantidad, SALDO: " + getSaldo());
		}
	}
	
	public boolean conSaldo(){
	    if (this.saldo > 0) return true; //saldo mayor o igual a 0
	    return false;
	}

}
