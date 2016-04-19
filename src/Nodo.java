
public class Nodo implements Comparable<Nodo>{

	private Tabuleiro tabuleiro;
	private Nodo pai;
	private int custoAteAqui;
	private int heuristica;

	public Nodo(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		calculaHeuristica();
	}

	private void calculaHeuristica() {
		// TODO Auto-generated method stub
		
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
		if(this.getComparativo() > o.getComparativo()){
			return 1;
		}else if(this.getComparativo() < o.getComparativo()){
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
