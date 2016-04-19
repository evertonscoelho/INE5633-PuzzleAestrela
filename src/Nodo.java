
public class Nodo implements Comparable<Nodo> {

	private Tabuleiro tabuleiro;
	private Nodo pai;
	private int custoAteAqui;
	private int heuristica;

	public Nodo(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		calculaHeuristica();
	}

	private void calculaHeuristica() {
		heuristica = 0;
		int[][] posFinais = { { 1, 2, 3 }, { 8, 0, 4 }, { 7, 6, 5 } };
		Tabuleiro tabuleiroFinal = new Tabuleiro(posFinais);
		int valor = 0;
		int[] posValorAtual;
		int[] posValorFinal;
		for (int i = 0; i < 9; i++) {
			posValorFinal = tabuleiroFinal.getPosValor(valor);
			posValorAtual = tabuleiro.getPosValor(valor);
			heuristica += Math.abs(posValorFinal[0] - posValorAtual[0]);
			heuristica += Math.abs(posValorFinal[1] - posValorAtual[1]);

			if (posValorAtual[0] < 2) {
				if (tabuleiroFinal.getPosicoes()[posValorAtual[0]][posValorAtual[1]] == tabuleiro
						.getPosicoes()[(posValorAtual[0] + 1)][posValorAtual[1]]
						&& tabuleiro.getPosicoes()[posValorAtual[0]][posValorAtual[1]] == tabuleiroFinal
								.getPosicoes()[(posValorAtual[0] + 1)][posValorAtual[1]])
					heuristica += 2;
			}
			if (posValorAtual[0] > 0) {
				if (tabuleiroFinal.getPosicoes()[posValorAtual[0]][posValorAtual[1]] == tabuleiro
						.getPosicoes()[(posValorAtual[0] - 1)][posValorAtual[1]]
						&& tabuleiro.getPosicoes()[posValorAtual[0]][posValorAtual[1]] == tabuleiroFinal
								.getPosicoes()[(posValorAtual[0] - 1)][posValorAtual[1]])
					heuristica += 2;
			}
			if (posValorAtual[1] > 0) {
				if (tabuleiroFinal.getPosicoes()[posValorAtual[0]][posValorAtual[1]] == tabuleiro
						.getPosicoes()[posValorAtual[0]][(posValorAtual[1] - 1)]
						&& tabuleiro.getPosicoes()[posValorAtual[0]][posValorAtual[1]] == tabuleiroFinal
								.getPosicoes()[posValorAtual[0]][(posValorAtual[1] - 1)])
					heuristica += 2;
			}
			if (posValorAtual[1] < 2) {
				if (tabuleiroFinal.getPosicoes()[posValorAtual[0]][posValorAtual[1]] == tabuleiro
						.getPosicoes()[posValorAtual[0]][(posValorAtual[1] + 1)]
						&& tabuleiro.getPosicoes()[posValorAtual[0]][posValorAtual[1]] == tabuleiroFinal
								.getPosicoes()[posValorAtual[0]][(posValorAtual[1] + 1)])
					heuristica += 2;
			}

			System.out.println(heuristica);

			valor++;
		}

	}

	public Nodo getPai() {
		return pai;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void calculaCusto() {
		if (pai != null)
			custoAteAqui = pai.custoAteAqui + 1;
		else
			custoAteAqui = 1;
	}

	@Override
	public int compareTo(Nodo o) {
		if (this.getComparativo() > o.getComparativo()) {
			return 1;
		} else if (this.getComparativo() < o.getComparativo()) {
			return -1;
		}
		return 0;
	}

	private int getComparativo() {
		return pai.getCustoAteAqui() + this.heuristica;
	}

	public int getCustoAteAqui() {
		return custoAteAqui;
	}

}
