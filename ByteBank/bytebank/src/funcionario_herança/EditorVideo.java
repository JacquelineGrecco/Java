package funcionario_herança;

public class EditorVideo extends Funcionario {
	
	public double getBonificacao() {
		return 150; 
	}

	@Override
	public double getSalarioBonificiado() {
		return 0;
	}

}
