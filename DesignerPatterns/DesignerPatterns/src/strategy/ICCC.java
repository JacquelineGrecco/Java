package strategy;

public class ICCC implements Imposto {

	public double calcula(Orcamento orcamento) {
		double valor = 0; 
		
		if (orcamento.getValor() < 1000) {
			valor =  orcamento.getValor() * 0.05;
		} else if ((orcamento.getValor() <= 3000)) {
			valor =  orcamento.getValor() * 0.07;
		} else 	{
			valor = (orcamento.getValor() * 0.08) + 30;
		}
		
		return valor; 
	}
}
