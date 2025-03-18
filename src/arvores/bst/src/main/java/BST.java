import java.util.ArrayList;

public class BST {

    private Node root;
    private int size;
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    /**
     * Implementação iterativa da adição de um elemento em uma árvore binária de pequisa.
     * @param element o valor a ser adicionado na árvore.
     */
    public void add(int element) {
        this.size += 1;
        if (isEmpty())
            this.root = new Node(element);
        else {
            
            Node aux = this.root;
            
            while (aux != null) {
                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        Node newNode = new Node(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        Node newNode = new Node(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }
        
    }
    
    
    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro. Essa é a implementação 
     * iterativa clássica da busca binária em uma árvore binária de pesquisa.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    public Node search(int element) {

        Node aux = this.root;

        while(aux != null) {
            if(aux.value == element) return aux;
            if(aux.value > element)
                aux = aux.left;
            if(aux.value < element)
                aux = aux.right;
        }
        return null;
    }
    
    /**
     * Retorna a altura da árvore.
     */
    public int height() {
        return this.height(this.root);
    }

    private int height(Node current) {
        if(current == null) return -1;
        return 1 + Math.max(height(current.right), height(current.left));
    }

    public boolean equals(BST outra) {
        return equals(this.root, outra.root);
    }

    private boolean equals(Node n1, Node n2) {
        if(n1 == null && n2 == null) return true;
        if(n1 == null || n2 == null || n1.value != n2.value) return false;
        return equals(n1.left, n2.left) && equals(n1.right, n2.right);
    }
    /**
    * Retorna o número de folhas da árvore.
    */
    public int contaFolhas() {
        return this.contaFolhas(this.root);
    }

    private int contaFolhas(Node current) {
        if(current == null) return 0;
        if(isLeaf(current)) return 1;
        return contaFolhas(current.right) + contaFolhas(current.left);
    }

    public boolean isLeaf(Node leaf) {
        return (leaf.left == null || leaf.right == null);
    }
    /**
     * @return o tamanho da árvore.
     */
    public int size() {
        return this.size;
    }
    

    ////////////////////////////////////////
   
    public Node sucesor(int k) {
        Node node = this.search(k);

        if(node == null) return null;
        if(node.right != null) return min(node.right);
        else {
            Node aux = node.parent;
            while(aux != null && aux.value < node.value)
                aux = aux.parent;
            return aux;
        }
    }

    private Node min(Node n) {
        Node aux = n;
        while(aux.left != null) 
            aux = aux.left;
        return aux;
    }

    public Node predecessor(int k) {
        Node node = this.search(k);

        if(node == null) return null;
        if(node.left != null) return max(node.left);
        else {
            Node aux = node.parent;
            while(aux != null && aux.value > node.value)
                aux = aux.parent;
            return aux;
        }
    }

    private Node max(Node n) {
        Node aux = n;
        while(aux.right != null)
            aux = aux.right;
        return aux;
    }

    public void remove(int k) {
        Node toRemove = this.search(k);
        if(toRemove == null) return;
        this.size--;
        
        if (isLeaf(toRemove)) {
            if (toRemove == this.root)
                this.root = null;
            else {
                if (toRemove.value < toRemove.parent.value)
                    toRemove.parent.left = null;
                else
                    toRemove.parent.right = null;
            }
        } else if (toRemove.hasOnlyLeftChild()) {
            if (toRemove == this.root)  {
                this.root = toRemove.left;
                this.root.parent = null;
            } else {
                toRemove.left.parent = toRemove.parent;
                if (toRemove.value < toRemove.parent.value)
                    toRemove.parent.left = toRemove.left;
                else
                    toRemove.parent.right = toRemove.left;
            }
        } else if (toRemove.hasOnlyRightChild()) {
            if (toRemove == this.root) {
                this.root = toRemove.right;
                this.root.parent = null;
            } else {
                toRemove.right.parent = toRemove.parent;
                if (toRemove.value < toRemove.parent.value)
                    toRemove.parent.left = toRemove.right;
                else
                    toRemove.parent.right = toRemove.right;
            }
        } else {
            Node sucessor = sucessor(toRemove);
            toRemove.value = sucessor.value;
            remove(sucessor.value);
        }
    }

    private Node findMinimum(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    /*
     * Retorna o sucessor do nó.
     */
    public Node sucessor(Node node) {
        if (node == null) {
            return null;
        }
        
        if (node.right != null) {
            return findMinimum(node.right);
        } else {
            
            Node current = node;
            Node parent = node.parent;
            
            while (parent != null && current == parent.right) {
                current = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

}


class Node {
    
    int value;
    Node left;
    Node right;
    Node parent;
    
    Node(int v) {
        this.value = v;
    }

    public boolean hasOnlyLeftChild() {
        return left != null && right == null;
    }

    public boolean hasOnlyRightChild() {
        return left == null && right != null;
    }
    
}