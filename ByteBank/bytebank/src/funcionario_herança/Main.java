package funcionario_herança;

public class Main {

	public static void main(String[] args) { 
			Gerente gerente = new Gerente(); 
			EditorVideo editor = new EditorVideo(); 
			ControleBonificacao controle = new ControleBonificacao(); 
			Administrator adm = new Administrator();
			SistemaInterno si = new SistemaInterno();
			 	
			gerente.setSalario(3000);
			gerente.setBonus(20);
		//	gerente.setSenha(2222);
			
			adm.setSenha(3333);
			si.autentica(gerente);
			
			si.autentica(adm);
			
			controle.registra(gerente);
			controle.registra(editor);
			
			System.out.println(controle.getSoma());

       }
	}
