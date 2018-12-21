package strategy;
//Classe para a regra de negocio ou que altere a regra de negocio.. Ou notificar um objeto do valor modificado


public class CalculadorDeImposto {

	public void realizaCalculo (Orcamento orcamento, Imposto imposto) {
		double icms = imposto.calcula(orcamento); 
		System.out.println(icms);
	} 
	
	public void calculaISS (Orcamento orcamento) {
		double iss = new ISS().calcula(orcamento); 
		System.out.println(iss);
	}
	
	public void calculaICCC(Orcamento orcamento) {
		double iccc = new ICCC().calcula(orcamento);
		System.out.println(iccc);
	}
	
}
