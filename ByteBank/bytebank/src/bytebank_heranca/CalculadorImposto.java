package bytebank_heranca;

public class CalculadorImposto{
	
	private double total; 

	public void registra(Tributos tributo) {
		double valor = tributo.getValorTributação(); 
		this.setTotal(+ valor); 
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
