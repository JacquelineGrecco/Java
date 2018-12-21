package bytebank;
public class CriarConta {

    public static void main(String[] args) {
        Conta primeiraConta = new Conta(); 
        Conta segundaConta = new Conta();
        // primeiraConta.saldo = 200; 
       // System.out.println(primeiraConta.saldo);

        primeiraConta.saldo += 100;
        //System.out.println(primeiraConta.saldo);

        
        segundaConta.deposita(100.0); 
        segundaConta.deposita(100.0); 
        
        System.out.println(segundaConta.transfere(primeiraConta, 100)); 
 
       System.out.println("primeira conta tem " + primeiraConta.saldo);
       System.out.println("segunda conta tem " + segundaConta.saldo);
    }
}