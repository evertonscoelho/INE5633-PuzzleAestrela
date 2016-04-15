import java.lang.reflect.Array;
import java.util.Collections;

public class Vish {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] posicoes = setPosicoesIniciais();
		Tabuleiro tabuleiro = new Tabuleiro(posicoes);
		Mito mito = new Mito();
		
		Nodo nodo = new Nodo(tabuleiro);
		mito.visitaNodo(nodo);
	}
	
	public static int[][] setPosicoesIniciais(){
		int[][] posicoes = new int[3][3];
		posicoes[0][0] = 7;
		posicoes[0][1] = 1;
		posicoes[0][2] = 3;
		posicoes[1][2] = 0;
		posicoes[1][1] = 6;
		posicoes[1][0] = 2;
		posicoes[2][2] = 8;
		posicoes[2][1] = 4;
		posicoes[2][0] = 5;
		return posicoes;
	}
}
