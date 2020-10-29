package es.cip.yerayplasenciaramos.ut02;

/**
 * Cliente
 * 
 * */

public class Cliente implements Runnable{
	
	Cuenta cuenta;
    int cantidad;
    
    public Cliente (Cuenta cuenta, int cantidad) {
    	this.cuenta = cuenta;
    	this.cantidad = cantidad;
    }
    
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
    public void run() {
		cuenta.hacerMovimiento(cantidad);
    }
}
