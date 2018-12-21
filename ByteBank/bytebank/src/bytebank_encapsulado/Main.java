package bytebank_encapsulado;

public class Main {
	public static void main(String[] args) {
		Conta conta = new Conta (1000, 6810); 
		Conta c     = new Conta (2000, 9900); 
		//conta.setAgencia(100);
		//conta.setNumero(6910);
		conta.deposita(100);
		conta.getTitular().setNome("Jacqueline");
		conta.getTitular().setCpf("444.676.775-99");
		conta.getTitular().setProfissao("Analista Júnior");
		c.deposita(100);
		System.out.println(conta.getAgencia());
		System.out.println(conta.getNumero()); 
		System.out.println(conta.getSaldo());
		System.out.println(conta.getTitular().getNome());
		System.out.println(conta.getTitular().getCpf());
		System.out.println(conta.getTitular().getProfissao());	
	}
}
