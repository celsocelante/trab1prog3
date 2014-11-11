import java.util.*;
public class PilhaArray<T> {
	
	private T[] itens;
	private int tamanho;
	private int topo;

	public PilhaArray(int tamanho){
		itens = (T[]) new Object[tamanho];
		this.tamanho = tamanho;
		topo--;
	}

	public void push(T info) throws PilhaCheiaException {
		if(topo+1 > tamanho) {
			throw new PilhaCheiaException();
		} else {
			topo++;
			itens[topo] = info;
		}
	}

	public T pop() throws PilhaVaziaException {
		if(topo < 0) {
			throw new PilhaVaziaException();
		} else {
			topo--;
			return itens[topo+1];
		}
	}

	public int tamanho(){
		return tamanho;
	}

	public boolean vazia(){
		return topo > 0;
	}

}
	
	
