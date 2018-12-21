package funcionario_herança;

public class ControleBonificacao {

		private double soma; 
		
		public void registra(Funcionario funcionario) {
			double bonificacao = funcionario.getSalarioBonificiado(); 
			this.soma = this.soma + bonificacao; 
		}
		
		public double getSoma() {
			return this.soma; 
			
		}
}
