import java.util.HashMap;

public class Nodo implements Comparable<Nodo> {

	private Tabuleiro tabuleiro;
	private Nodo pai;
	private int custoAteAqui;
	private int heuristica;
	private String hash;

	public Nodo(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		calculaHeuristica();
	}

	private void calculaHeuristica() {
		heuristica = 0;
		HashMap<String, Integer> posicoesCruzadas = new HashMap<String, Integer>();
		int[][] posFinais = { { 1, 2, 3 }, { 8, 0, 4 }, { 7, 6, 5 } };
		Tabuleiro tabuleiroFinal = new Tabuleiro(posFinais);
		int valor = 0, coluna = 0, linha = 0;
		int[] posValorAtual;
		int[] posValorFinal;
		for (int i = 0; i < 9; i++) {
			posValorFinal = tabuleiroFinal.getPosValor(valor);
			posValorAtual = tabuleiro.getPosValor(valor);
			coluna = posValorFinal[0] - posValorAtual[0];
			linha = posValorFinal[1] - posValorAtual[1];
			
			if (linha == 0 && coluna != 0) {
				if (coluna > 0) {
					addHash(posicoesCruzadas, "C_D");
				} else if (coluna < 0) {
					addHash(posicoesCruzadas, "C_E");
				}
			} else if (linha != 0 && coluna == 0) {
				if (linha > 0) {
					addHash(posicoesCruzadas, "L_B");
				} else if (linha < 0) {
					addHash(posicoesCruzadas, "L_C");
				}
			}
			valor++;
			heuristica += Math.abs(coluna) + Math.abs(linha);
		}
		if (posicoesCruzadas.containsKey("C_D") && posicoesCruzadas.containsKey("C_E")) {
			heuristica += posicoesCruzadas.get("C_D")+ posicoesCruzadas.get("C_E");
		}
		if (posicoesCruzadas.containsKey("L_B") && posicoesCruzadas.containsKey("L_C")) {
			heuristica += posicoesCruzadas.get("L_B")+ posicoesCruzadas.get("L_C");
		}
	}

	private void addHash(HashMap<String, Integer> posicoesCruzadas, String key) {
		if (posicoesCruzadas.containsKey(key)) {
			posicoesCruzadas.put(key, 2);
		} else {
			posicoesCruzadas.put(key, 1);
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

	public void setPai(Nodo nodo) {
		this.pai = nodo;

	}

	@Override
	public boolean equals(Object obj) {
		Nodo nodo = (Nodo) obj;
		return this.getTabuleiro().getIdentificador().equals(nodo.getTabuleiro().getIdentificador());
	}

}
