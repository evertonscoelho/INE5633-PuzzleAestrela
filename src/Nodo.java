
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
		int valor = 0;
		int[] posValorAtual;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				posValorAtual = tabuleiro.getPosValor(valor);
				heuristica += Math.abs(i - posValorAtual[0]);
				heuristica += Math.abs(j - posValorAtual[1]);
				if (posFinais[posValorAtual[0]][posValorAtual[1]] == posFinais[(posValorAtual[0]
						+ 1)][posValorAtual[1]])
					heuristica += 2;

				if (posFinais[posValorAtual[0]][posValorAtual[1]] == posFinais[(posValorAtual[0]
						- 1)][posValorAtual[1]])
					heuristica += 2;

				if (posFinais[posValorAtual[0]][posValorAtual[1]] == posFinais[posValorAtual[0]][(posValorAtual[1]
						- 1)])
					heuristica += 2;

				if (posFinais[posValorAtual[0]][posValorAtual[1]] == posFinais[posValorAtual[0]][(posValorAtual[1]
						+ 1)])
					heuristica += 2;
				valor++;
			}
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
