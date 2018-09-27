
public class AliquotaIf {

	public static void main(String[] args) {
		double salario = 3300.0;
		double IR = 0;
		double desconto = 0;

		if ((salario >= 1900.0) && (salario <= 2800.0)) {
			IR = 7.5;
			desconto = 142;
		} else if ((salario >= 2800.01) && (salario <= 3751.0)) {
			IR = 15.0;
			desconto = 350;
		} else if ((salario >= 3751.01) && (salario <= 4664.00)) {
			IR = 22.5;
			desconto = 636;
		}

		salario = salario - desconto;
		System.out.println(
				"O salario é de:" + salario + " " + "e o desconto foi de:" + desconto + " " + "e o IR foi de:" + IR);
	}
}
