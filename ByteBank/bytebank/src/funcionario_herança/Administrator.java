package funcionario_herança;

public class Administrator extends Funcionario implements Autenticavel {
	private int senha;

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public boolean autentica(int senha) {
        if(this.senha == senha) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getSalarioBonificiado() {
        return 50;
    }

}
