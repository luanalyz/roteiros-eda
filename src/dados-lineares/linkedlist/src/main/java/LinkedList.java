import java.util.NoSuchElementException;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
   
    public boolean isEmpty() {
        if(this.head == null && this.tail == null) return true;
        return false;
    }

    public void addFirst(int valor) {
        Node novo = new Node(valor);
        if(isEmpty()) {
            this.head = novo;
            this.tail = novo;
        } else {
            novo.next = this.head;
            this.head.prev = novo;
            this.head = novo;
        }
        this.size++;
    }

    public void addLast(int valor) {
        Node novo = new Node(valor);
        if(isEmpty()) {
            this.head = novo;
            this.tail = novo;
        } else {
            novo.prev = this.tail;
            this.tail.next = novo;
            this.tail = novo;
        }
        this.size++;
    }

    // adiciona um valor na posição passada como parâmetro
    public void add(int index, int valor) {
        if(index < 0 || index > this.size) throw new IndexOutOfBoundsException("Esta linha não pode ser executada.");

        if(index == 0) {
            this.addFirst(valor);
        } else if(index == size) {
            this.addLast(valor);
        } else {
            
            Node novo = new Node(valor);
            Node aux = this.head;
            
            for(int i = 0; i < index - 1; i++) {
                aux = aux.next;
            }

            novo.prev = aux;
            novo.next = aux.next;
            aux.next = novo;
            novo.next.prev = novo;

            this.size++;   
        }
    }

    public int getFirst() {
        if(isEmpty()) throw new NoSuchElementException("Esta linha não pode ser executada.");
        return this.head.value;
    }

    public int getLast() {
        if(isEmpty()) throw new NoSuchElementException("Esta linha não pode ser executada.");
        return this.tail.value;
    }

    // retorna o elemento na posição  passada como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        if(index < 0 || index >= this.size) throw new IndexOutOfBoundsException("Esta linha não pode ser executada.");

        Node aux = this.head;
        for(int i = 0; i < index; i++) {
            aux = aux.next;
        }

        return aux.value;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if(isEmpty()) throw new NoSuchElementException("Esta linha não pode ser executada.");

        int out = this.head.value;

        if(this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        
        this.size--;
        return out;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeLast() {
        if(isEmpty()) throw new NoSuchElementException("Esta linha não pode ser executada.");

        int out = this.tail.value;

        if(this.tail.prev == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;
        return out;
    }

    // remove o valor no índice passado como parâmetro. retorna o valor removido.
    // lançar exceção se o índice não for válido.
    public int remove(int index) {
        if(index < 0 || index > this.size) throw new IndexOutOfBoundsException("Esta linha não pode ser executada.");

        Node aux = this.head;
        
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();

        for(int i = 0; i < index; i++) {
            aux = aux.next;
        }
        
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;

        this.size--;
        return aux.value;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeByValue(int value) {
        if(isEmpty()) return false;

        Node aux = this.head;
        for(int i = 0; i < size; i++) {
            if(aux.value == value) {
                this.remove(i);
                return true;
            }
            aux = aux.next;
        }  
        return false;
    }

    // retorna a posição da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        Node aux = this.head;
        int out = -1;
        for(int i = 0; i < size; i++) {
            if(aux.value == value) {
                out = i;
                break;
            }
            aux = aux.next;
        }  
        return out;
    }

    public boolean contain(int v) {
        return this.indexOf(v) != -1;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        Node aux = this.head;
        int out = -1;
        for(int i = 0; i < size; i++) {
            if(aux.value == valor) {
                out = i;
            }
            aux = aux.next;
        }  
        return out;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        if (isEmpty()) return "";

        Node aux = this.head;
        String out = "";
        while (aux != null) {
            out += aux.value + ", ";
            aux = aux.next;
        }
        return out.substring(0, out.length() - 2);
    }
    
    public int size() {
        return this.size;
    }
}

class Node {

    int value;
    Node prev;
    Node next;

    Node(int v) {
        this.value = v;
        this.prev = null;
        this.next = null;
    }

}