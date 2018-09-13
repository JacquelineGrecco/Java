
public class TestaConversao {

	public static void main(String[] args) {
		double salario, total, valor1,valor2;
		long numeroGrande; 
		short numeroPequeno; 
		byte b; 
		int valor; 
		
		salario = 1270.50; 
		valor = (int) salario; 
		System.out.println(valor);
		
		numeroGrande = 32432423523L; 
		System.out.println(numeroGrande);
		
		numeroPequeno = 2131; 
		System.out.println(numeroPequeno);
		
		b = 127; 
		System.out.println(b);
		
		valor1 = 0.2; 
		valor2 = 0.1; 
		total  = valor1 + valor2; 
		System.out.println(total);
	}
}
