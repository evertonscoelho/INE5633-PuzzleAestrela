import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Fronteira {

    private int qntdMaxNodo;
    private List<Nodo> lista = new LinkedList<Nodo>();
    private List<String> listaRemovidos = new LinkedList<String>();
    
    
    public void adicionaNodos(List<Nodo> filhos) {
        for (Nodo nodo : filhos) {
            if(!listaRemovidos.contains(nodo.getTabuleiro().getIdentificador())){
                lista.add(nodo);
            }
        }
        if (lista.size() > qntdMaxNodo) {
            qntdMaxNodo = lista.size();
        }
    }

    public void removeNodo(Nodo nodoAtual) {
        listaRemovidos.add(nodoAtual.getTabuleiro().getIdentificador());
        lista.remove(nodoAtual);
    }

    public Nodo getProximoNodo() {
        if(!lista.isEmpty()){
        		return Collections.min(lista);
        }else{
        	return null;
        }
    }

    public int informaMaxNodo() {
        return qntdMaxNodo;
    }

}
