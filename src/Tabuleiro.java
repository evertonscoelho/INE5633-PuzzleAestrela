
public class Tabuleiro {

	private int[][] posicoes = new int[3][3];
	private String identificador;

	public Tabuleiro(int[][] posicoes) {
		this.posicoes = posicoes;
		geraIdentificador();
	}

	public int[][] getPosicoes() {
		return posicoes;
	}

	public void setPosicao(int valor, int linha, int coluna) {
		posicoes[linha][coluna] = valor;
	}

	public int getValor(int linha, int coluna) {
		return posicoes[linha][coluna];
	}

	public int[] getPosValor(int valor) {
		int[] resposta = new int[2];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (posicoes[i][j] == valor) {
					resposta[0] = i;
					resposta[1] = j;
					return resposta;
				}
			}
		}
		return resposta;
	}

	private void geraIdentificador() {
		String idetificadorString = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				idetificadorString += posicoes[i][j] + "";
			}
		}

		identificador = idetificadorString;
	}

	public String getIdentificador() {
		return identificador;
	}

}
