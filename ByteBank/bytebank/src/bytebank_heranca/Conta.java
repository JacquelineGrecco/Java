package bytebank_heranca;

public abstract class Conta {
	protected double saldo; 
    private int agencia; 
    private int numero;  
    private Cliente titular = new Cliente();
    private static int totalConta =0; 
    
    public abstract void deposita (double valor); 
    
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
