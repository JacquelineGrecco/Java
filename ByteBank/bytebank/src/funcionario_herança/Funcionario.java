package funcionario_herança;

public abstract class Funcionario {
	
	private String nome; 
	private String cpf; 
	protected double salario; 
	private double bonus; 
	

	public abstract double getSalarioBonificiado();
	
	public double getBonus () {
		return this.bonus; 
	}
	
    
	public void setBonus(double bonus) {
		this.bonus = bonus; 
	}
	
	public double getSalario () {
		return this.salario; 
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	 
	public String getNome() {
		return this.nome; 
	}
	
	public void setNome(String nome) {
		this.nome = nome; 
	}
	
	public String getCPF() {
		return this.cpf; 
	}
	
	public void setCPF(String cpf) {
		this.cpf = cpf; 
	}
	
}
