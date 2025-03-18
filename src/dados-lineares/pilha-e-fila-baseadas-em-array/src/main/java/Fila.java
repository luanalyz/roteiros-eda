import java.util.NoSuchElementException;

public class Fila {

    private int head;
    private int tail;
    private int[] fila;
    private int size;
    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public Fila(int capacidade) {
        this.head = -1;
        this.tail = -1;
        this.size = 0;
        this.fila = new int[capacidade];
    }

    public boolean isEmpty() {
       return this.head == -1 && this.tail == -1;
    }

    public boolean isFull() {
        if(isEmpty()) return false;
        return (this.tail + 1) % this.fila.length == this.head;
    }

    // deve lançar exceção caso a fila esteja cheia.
    public void addLast(int valor) {
        if (isFull()) throw new NoSuchElementException("Esta linha não pode ser executada.");
        
        this.size++;

        if(isEmpty()) 
            this.head = 0;
        
        this.tail = (this.tail + 1) % this.fila.length;
        this.fila[tail] = valor;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Esta linha não pode ser executada.");
        
        int value = this.fila[this.head];

        if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = (this.head + 1) % this.fila.length;
        }
        this.size -= 1;   
        return value; 
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public int getFirst() {
        if (isEmpty()) throw new NoSuchElementException("Esta linha não pode ser executada.");
        return this.fila[this.head];
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public int getLast() {
        if (isEmpty()) throw new NoSuchElementException("Esta linha não pode ser executada.");
        return this.fila[this.tail];
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        String out = "";
        for (int i = head; i != this.tail; i = (i + 1) % this.fila.length) {
            out += this.fila[i] + " ";
        }
        if(!isEmpty())
            out += this.fila[this.tail];
        return out;
    }
    
    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. 
    public int indexOf(int valor) {
        for (int i = head; i != this.tail; i = (i + 1) % this.fila.length) {
            if(this.fila[i] == valor) return i;
        }
        if(!isEmpty())
            if(this.fila[this.tail] == valor) return this.tail;
        return -1;
    }

    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        int out = -1;
        for (int i = head; i != this.tail; i = (i + 1) % this.fila.length) {
            if(this.fila[i] == valor) 
                out = i;
        }
        if(!isEmpty())
            if(this.fila[this.tail] == valor)
                out = this.tail;
        return out;
    }
    
    public int size() {
        return this.size;
    }

}
