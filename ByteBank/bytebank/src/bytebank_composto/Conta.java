package bytebank_composto;


public class Conta {

	private double saldo; 
    int agencia; 
    int numero;  
    Cliente titular = new Cliente();
    
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
    	
    	if (this.saldo >= valor) {
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
}
