
public class Fatorial {

	public static void main(String[] args) {
		int fatorial = 1;
		int numero = 1;
		int cont = 1;
		for (int contador = 1; contador <= 10; contador++) {
			while (cont < numero) {
				fatorial = fatorial * numero;
				cont++;
			}
			System.out.println("Número: " + numero);
			System.out.println("Fatorial: " + fatorial);
			numero++;
		}
	}
}