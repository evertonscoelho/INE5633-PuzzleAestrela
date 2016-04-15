import java.util.List;
import java.util.Stack;

public class Mito {

	private Fronteira fronteira = new Fronteira();

	public void visitaNodo(Nodo nodoAtual) {
		nodoAtual.calculaCusto();
		if (ehObjetivo(nodoAtual)) {
			System.out.println("Quantidade Max. de nodos na fronteira: " + fronteira.informaMaxNodo());
			informaCaminhoEncontrado(nodoAtual);

		} else {
			List<Nodo> filhos = geraFilhos(nodoAtual);
			fronteira.adicionaNodos(filhos);
			fronteira.removeNodo(nodoAtual);
			nodoAtual = fronteira.getProximoNodo();
			visitaNodo(nodoAtual);
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
			if(nodoFinal.getPai() != null){
				aux = nodoFinal.getPai();
				nodoFinal = aux;
			}else{
				acabouJessica = true;
			}
		}
		System.out.println("Quantidade de jogadas: " + (stack.size()-1));
		for(int i = 0; i < stack.size(); i++){
			aux = stack.pop();
			imprimeTabuleiro(aux.getTabuleiro(), i);
		}

	}

	private void imprimeTabuleiro(Tabuleiro tabuleiro, int i) {
		// TODO Auto-generated method stub
	}

	private boolean ehObjetivo(Nodo nodoAtual) {
		int[][] t = nodoAtual.getTabuleiro().getPosicoes();
		int[][]t1 = {{1, 2, 3}, {8, 0, 4}, {7, 6, 5}};
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(!(t[i][j] == t1 [i][j])){
					return false;
				}
			}
		}
		return true;
	}

}