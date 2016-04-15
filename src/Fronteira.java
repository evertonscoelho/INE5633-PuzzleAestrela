import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Fronteira {

	private int qntdMaxNodo;
	private List<Nodo> lista = new LinkedList<Nodo>();

	public void adicionaNodos(List<Nodo> filhos) {
		for(Nodo nodo: filhos){
			lista.add(nodo);
		}
		if(lista.size() > qntdMaxNodo){
			qntdMaxNodo = lista.size();
		}
	}

	public void removeNodo(Nodo nodoAtual) {
		lista.remove(nodoAtual);
	}

	public Nodo getProximoNodo() {
		return Collections.min(lista);
	}

	public int informaMaxNodo() {
		return qntdMaxNodo;
	}

}
