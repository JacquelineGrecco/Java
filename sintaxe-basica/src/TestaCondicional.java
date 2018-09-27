
public class TestaCondicional {

	public static void main(String[] args) {
		System.out.println("Testando condicionais");
		int idade = 20; 
		int quantidadePessoas = 3; 
		
/*		if (idade >= 18) {
			System.out.println("Você possui mais de 18 anos");
			System.out.println("Seja bem vindo! :)");
		}else {
			if (quantidadePessoas >= 2) {
				System.out.println("Você não tem 18, mas pode entrar, pois está acompanhado");
			} else {
				System.out.println("Infelizmente você não pode entrar");	
			}
		}
	}	*/
		if (idade >= 18 || quantidadePessoas >= 2) {
			System.out.println("Seja bem vindo!");
		}else {
			System.out.println("Infelizmente você não pode entrar");
		}
		
	}
} 