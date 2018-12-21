package bytebank_heranca;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(int agencia, int numero) {
		super(agencia, numero);
		
	    
	}

	@Override
	public void deposita(double valor) {
		if (valor > 0) {
    		super.saldo += super.saldo + valor; 
    	} 
	}
}
