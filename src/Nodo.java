	
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

	public Nodo() {
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		//Se tu maior retorna 1, se outro maior retorna -1, se igual retorna 0
		return 0;
	}
	
	

}
