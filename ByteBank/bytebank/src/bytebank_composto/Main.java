package bytebank_composto;

public class Main {

	public static void main(String[] args) {
		Conta conta = new Conta (); 
		conta.titular.nome = "Marcela"; 
		conta.deposita(200);
		System.out.println(conta.titular.nome);
		System.out.println(conta.getSaldo());
	}	

}
