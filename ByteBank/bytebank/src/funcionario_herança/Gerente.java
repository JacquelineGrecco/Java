package funcionario_herança;

public class Gerente extends Funcionario implements Autenticavel {
	
	private int senha; 
	
	public double getBonus () {
			return super.getSalario();   
	}

	@Override
	public double getSalarioBonificiado() {
		return 0;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public boolean autentica(int senha) {
		if (this.senha == senha) {
			return true;
		} else {
			return false;
		}
	}
}
