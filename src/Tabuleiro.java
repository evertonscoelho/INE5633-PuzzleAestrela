

public class Tabuleiro {

	private int[][] posicoes = new int[3][3];

	public Tabuleiro(int[][] posicoes){
		this.posicoes = posicoes;
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

	
	
	
	
	
		
	
	

}
