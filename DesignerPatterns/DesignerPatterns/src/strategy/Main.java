package strategy;

public class Main {

	public static void main(String[] args) {
		Imposto iss = new ISS(); 
		Imposto icms = new ICMS(); 
		Imposto iccc = new ICCC(); 
		
		Orcamento orcamento = new Orcamento(500); 
		
		CalculadorDeImposto calculador = new CalculadorDeImposto(); 
		
		calculador.realizaCalculo(orcamento, iss);
		calculador.
		calculador.realizaCalculo(orcamento, iccc);
 	}

}
