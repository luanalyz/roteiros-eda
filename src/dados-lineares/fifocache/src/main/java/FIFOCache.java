import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;

public class FIFOCache {

    private int head;
    private int tail;
    private String[] fila;
    private int size;

    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public FIFOCache(int capacidade) {
        this.head = -1;
        this.tail = -1;
        this.fila = new String[capacidade];
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == -1 && this.tail == -1;
    }

    public boolean isFull() {
         return (this.tail + 1) % this.fila.length == this.head;
    }

    // deve sobrescerver o mais antigo caso a fila esteja cheia.
    public void addLast(String chave) {
        if(!isFull()) 
            this.size++;
        
        if(isFull())
            this.head = (this.head + 1) % this.fila.length;
        
        if(isEmpty()) 
            this.head = 0;
        
        this.tail = (this.tail + 1) % this.fila.length;
        this.fila[tail] = chave;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public String removeFirst() {
        if(isEmpty()) throw new NoSuchElementException();

        String value = this.fila[this.head];

        if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = (this.head + 1) % this.fila.length;
        }
        this.size--;   
        return value; 
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public String getFirst() {
        if(isEmpty()) throw new NoSuchElementException();
        return this.fila[this.head];
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public String getLast() {
        if(isEmpty()) throw new NoSuchElementException();
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
    
    public int size() {
        return this.size;
    }

    public boolean contains(String chave) {

        for (int i = head; i != this.tail; i = (i + 1) % this.fila.length) {
            if(this.fila[i].equals(chave)) return true;
        }

        if(!isEmpty() && this.fila[this.tail].equals(chave)) return true;

        return false;
    }

 }
