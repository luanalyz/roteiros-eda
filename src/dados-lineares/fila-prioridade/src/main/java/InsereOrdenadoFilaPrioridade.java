public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {
		if(isEmpty()) 
            this.head = 0;
        
        this.last = (this.last + 1) % this.fila.length;
        this.fila[last] = new Pair(elemento, prioridade);
		
		for (int i = last; i != this.head; i = (i - 1) % this.fila.length) {
			if(this.fila[i].prioridade > this.fila[i-1].prioridade) {
				Pair aux = this.fila[i];
				this.fila[i] = this.fila[i-1];
				this.fila[i-1] = aux;
			} else {
				break;
			}
		}
	}

	private boolean isEmpty() {
		return this.last == -1 && this.head == -1;
	}

	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		String out = this.fila[this.head].elemento;
		this.head = (this.head + 1) % this.fila.length;
		return out;
	}

}
