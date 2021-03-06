import java.io.IOException;

public class EstacionamentoFactory {
	public Estacionamento getEstacionamento() throws IOException {
		
		Estacionamento e = new Estacionamento();
		
		String matrix[] = //manter sempre uma borda de espaços em branco
			{		 "          ",
					 " XVVVVVVX ",//1
					 " VhhhhxhE ",//2
					 " VtVVV^vX ",//3
					 " VtVVV^vX ",//4
					 " VqyyyyvX ",//5
					 " VttttxtX ",//6
					 " VtVVV^vX ",//7
					 " VtVVV^vX ",//8
					 " VqjjjjkS ",//9
					 " XVVVVVVX ",//10
					 "          "
			};
		
		// X Parede 
		// V Vaga
		// E Entrada do estacionamento
		// k baixo direita
		// y cima direita
		// x cima esquerda
		// t baixo esquerda
		// h cima baixo esquerda
		// j cima baixo direita
		// w cima esquerda direita
		// q baixo esquerda direita
		// S saída
		
		
		Posicao posicoes[][] = new Posicao[matrix.length][matrix[0].length()];
		
		EstacionamentoGUI gui = new EstacionamentoGUI(matrix.length-2,matrix[0].length()-2);
		e.setGui(gui);
		
		//Constrói matriz de posições
		for (int lin=1;lin<matrix.length;lin++) {
			for(int col=1;col<matrix[lin].length();col++) {
				switch (matrix[lin].charAt(col)) {
				case 'X': //parede
					posicoes[lin-1][col-1] = new Parede();
					break;
				case 'x': //via todos, exceto origem
					posicoes[lin-1][col-1] = new Via();
					break;
				case 'V': //vaga
					posicoes[lin-1][col-1] = new Vaga();
					break;
				case 'E': //entrada
					e.setEntrada(new Entrada());
					posicoes[lin-1][col-1] = e.getEntrada();
					break;
				case 'S': //saida
					posicoes[lin-1][col-1] = new Saida();
					break;	
				}
				
				if(posicoes[lin-1][col-1] != null) {
					IPosicao posicaoAtual = gui.getIPosicao(lin-1, col-1);
					posicaoAtual.setPosicao(posicoes[lin-1][col-1]);
					posicoes[lin-1][col-1].setIPosicao(posicaoAtual);
				}
			}
		}
		
		//Constrói relações entre as posições
		int dl=0; //descocamento de linha
		int dc=0; //descocamento de coluna
		String regexPosicaoValida = "kyxthjwq<v>^VS";
		for (int lin=1;lin<matrix.length;lin++) {
			for(int col=1;col<matrix[lin].length();col++) {
				switch (matrix[lin].charAt(col)) {
				case 'X': //parede
					break;
				case '<': //via esquerda
					dl= 0;
					dc=-1;
					if (regexPosicaoValida.contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					break;
				case 'v': //via baixo
					dl=+1;
					dc= 0;
					if (regexPosicaoValida.contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					break;
				case 'k': //baixo e direita
					dl= 0;
					dc=+1;
					if (regexPosicaoValida.contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					dl=+1;
					dc= 0;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					break;
				case 'y': //cima e direita
					dl= 0;
					dc=+1;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					dl=-1;
					dc= 0;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					break;
				case '>': //via direita
					dl= 0;
					dc=+1;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					break;
				case '^': //via cima
					dl=-1;
					dc= 0;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					break;
				case 'x': //para cima e para esquerda
					dl=-1;
					dc= 0;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					dl= 0;
					dc=-1;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					break;
				case 't': //para baixo e para esquerda
					dl=+1;
					dc= 0;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					dl= 0;
					dc=-1;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					break;
				case 'h': //para cima, para baixo e para esquerda
					dl=-1;
					dc= 0;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					dl=+1;
					dc= 0;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					dl= 0;
					dc=-1;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					break;
				case 'w': // w cima esquerda direita
					dl=-1;
					dc= 0;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					dl= 0;
					dc=-1;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					dl= 0;
					dc=+1;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					break;
				case 'q': // q baixo esquerda direita
					dl=+1;
					dc= 0;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					dl= 0;
					dc=-1;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					dl= 0;
					dc=+1;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					break;
				case 'j': //para cima, para baixo e para direita
					dl=-1;
					dc= 0;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					dl=+1;
					dc= 0;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					dl= 0;
					dc=+1;
					if ("kyxthjwq<v>^VS".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					break;
				case 'V': //vaga
				case 'E': //entrada
					//busca posição do tipo via à sua volta
					dl= 0;
					dc=+1;
					if ("kyxthjwq<v>^".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					dl= 0;
					dc=-1;
					if ("kyxthjwq<v>^".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					dl=-1;
					dc= 0;
					if ("kyxthjwq<v>^".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					dl=+1;
					dc= 0;
					if ("kyxthjwq<v>^".contains(""+matrix[lin+dl].charAt(col+dc))) {
						posicoes[lin-1][col-1].setDestino(posicoes[lin+dl-1][col+dc-1]);
					}
					break;
				case 'S': //saida
					break;	
				}
			}
		}
		
		e.setMatrix(posicoes);
		return e;
	}
}
