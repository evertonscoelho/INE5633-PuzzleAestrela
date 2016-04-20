import java.util.List;
import java.util.Stack;

public class Mito {

	private Fronteira fronteira = new Fronteira();
	int teste = 0;

	public void visitaNodo(Nodo nodoAtual) {
		if (ehObjetivo(nodoAtual)) {
			System.out.println("Quantidade Max. de nodos na fronteira: " + fronteira.informaMaxNodo());
			informaCaminhoEncontrado(nodoAtual);

		} else {
		    System.out.println();
		    System.out.println();
		    System.out.println();
			System.out.println("Jogada "+ teste);
			System.out.println();
			System.out.println();
			System.out.println();
			teste++;
			nodoAtual.calculaCusto();
			List<Nodo> filhos = geraFilhos(nodoAtual);
			fronteira.adicionaNodos(filhos);
			fronteira.removeNodo(nodoAtual);
			fronteira.imprime();
			nodoAtual = fronteira.getProximoNodo();
			if(nodoAtual != null){
				visitaNodo(nodoAtual);
			}else{
				System.out.println("Ops, parece que n�o encontramos nenhuma solu��o");
			}
		}
	}

	private List<Nodo> geraFilhos(Nodo nodoAtual) {
		Catra catra = new Catra();
		return catra.geraFilhos(nodoAtual);
	}

	private void informaCaminhoEncontrado(Nodo nodoFinal) {
		boolean acabouJessica = false;
		Stack<Nodo> stack = new Stack<>();
		Nodo aux;
		while (!acabouJessica) {
			stack.push(nodoFinal);
			if (nodoFinal.getPai() != null) {
				aux = nodoFinal.getPai();
				nodoFinal = aux;
			} else {
				acabouJessica = true;
			}
		}
		System.out.println("Quantidade de jogadas: " + (stack.size() - 1));
		for (int i = 0; i < stack.size(); i++) {
			aux = stack.pop();
			imprimeTabuleiro(aux.getTabuleiro(), i);
		}

	}

	public void imprimeTabuleiro(Tabuleiro tabuleiro, int i) {
		if (i == 0) {
			System.out.println("Tabuleiro inicial:");
		} else {
			System.out.println("Jogada: " + i);
		}
		int[][] pocisoes = tabuleiro.getPosicoes();
		System.out.println(pocisoes[0][0] + "|" + pocisoes[0][1] + "|" + pocisoes[0][2]);
		System.out.println("- - -");
		System.out.println(pocisoes[1][0] + "|" + pocisoes[1][1] + "|" + pocisoes[1][2]);
		System.out.println("- - -");
		System.out.println(pocisoes[2][0] + "|" + pocisoes[2][1] + "|" + pocisoes[2][2] + "\n \n");
	}

	private boolean ehObjetivo(Nodo nodoAtual) {
		return nodoAtual.getTabuleiro().getIdentificador() == 1238047651;
	}

}