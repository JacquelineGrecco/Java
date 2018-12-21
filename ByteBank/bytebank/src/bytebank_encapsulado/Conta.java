package bytebank_encapsulado;

public class Conta {
	private double saldo; 
    private int agencia; 
    private int numero;  
    private Cliente titular = new Cliente();
    private static int totalConta =0; 
    
    public Conta(int agencia, int numero) {
    	if (agencia > 0 && numero > 0 ) {
    		this.agencia = agencia; 
    		this.numero  = numero; 
    		this.saldo   = 0.0; 
    		Conta.totalConta++; 
    	} 
    }
    
    public int getTotal() {
    	return Conta.totalConta; 
    }
       
    public double getSaldo() {
    	return this.saldo;  
    }
    
    public void deposita (double valor) {
    	if (valor > 0) {
    		this.saldo += this.saldo + valor; 
    	} 
    }
    
    public boolean saque(double valor) { 
    	boolean retorno = false; 
    	
    	if (this.saldo >= valor && valor > 0) {
    		this.saldo = this.saldo - valor; 
    		retorno = true;
    	}
    	
    	return retorno; 
    }
    
    public boolean transfere(Conta conta, double valor) {
    	boolean retorno = false;
    	if (this.saldo >= valor) {
    		this.saldo -= valor; 
    		conta.deposita(valor);
    		retorno = true; 
    	}
    	return retorno; 
    }
    
    public int getNumero() {
    	return this.numero; 
    }
    
    public void setNumero(int numero) {
    	if (numero > 0)
    		this.numero = numero;
    	else return; 
    }
    
    public void setAgencia(int agencia) {
    	if (agencia > 0)
    		this.agencia = agencia; 
    	else return; 
    }
    
    public int getAgencia() {
    	return this.agencia; 
    }
    
    public Cliente getTitular() {
    	return this.titular;  
    }
    
    public void setTitular (Cliente titular) {
    	this.titular = titular; 
    }
}
