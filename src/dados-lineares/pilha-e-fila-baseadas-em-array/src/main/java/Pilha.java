import java.util.NoSuchElementException;

public class Pilha {

    private int topo;
    private int[] pilha;

    public Pilha(int capacidade) {
        this.topo = -1;
        this.pilha = new int[capacidade];
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo + 1 == size();
    }

    // deve lançar exceção caso a pilha esteja cheia.
    public void push(int valor) {
        if(isFull()) throw new RuntimeException("Esta linha não pode ser executada.");
        this.pilha[++this.topo] = valor; 
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int pop() {
        if(isEmpty()) throw new NoSuchElementException("Esta linha não pode ser executada.");
        return this.pilha[this.topo--];
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int peek() {
        if(isEmpty()) throw new NoSuchElementException("Esta linha não pode ser executada.");
        return this.pilha[this.topo];
    }


    // deve retornar uma string representando a pilha. Veja os testes para a especificação
    // detalhada. Não é permitido iterar diretamente sobre o array ou criar arrays. Crie outra pilha, se preciso. Use as operações push, pop,
    // isEmpty etc. 
    public String toString() {
        String out = "";
        Pilha auxPilha = new Pilha(this.size());
        
        while(!isEmpty()) {
            int valor = this.pop();
            auxPilha.push(valor);
            if(out.equals("")) {
                out += valor;
            } else {
                out += ", " + valor;
            }
        }

        while(!auxPilha.isEmpty()) {
            this.push(auxPilha.pop());
        }

        return out;
    }
    
    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. Note que
    // o topo sempre está na primeira posição (0), abaixo do topo é a posição 1 etc. Não confunda
    // com os índices do array. Interprete os testes para a especificação mais detalhada.
    // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
    // isEmpty etc.
    public int indexOf(int valor) {
        Pilha auxPilha = new Pilha(this.size());
        int out = -1;

        while(!isEmpty()) {
            out++;
            if(this.pilha[this.topo] == valor) return out;
            int v = this.pop();
            auxPilha.push(valor);
        }

        while(!auxPilha.isEmpty()) {
            this.push(auxPilha.pop());
        }

        return out;
    }

    public int size() {
        return this.topo + 1;
    }

}
