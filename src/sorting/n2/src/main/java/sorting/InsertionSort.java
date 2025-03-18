package sorting;

public class InsertionSort implements SortingStrategy {

    /**
    * O array  está ordenado exceto pelo último elemento. Esse método
    * deve colocar o último elemento em sua posição.
    * Importante: seu algoritmo deve ser O(n).
    */
    public void insereUltimoOrdenado(int[] v) {
        int j = v.length - 1;

	    while (j > 0 && v[j] < v[j-1]) {
            int aux = v[j];
            v[j] = v[j-1];
            v[j-1] = aux;
            j -= 1;
        }

    }
   
    /**
    * O array  está ordenado exceto pelo primeiro elemento. Esse método
    * deve colocar o primeiro elemento em sua posição. Ao final da execução,
    * v deve estar ordenado.
    * Importante: seu algoritmo deve ser O(n);
    */
    public void inserePrimeiroOrdenado(int[] v) {
        
        int j = 1;
        
        while (j < v.length && v[j] < v[j-1]) {
            int aux = v[j];
            v[j] = v[j-1];
            v[j-1] = aux;
            j++;
        }
    }

    /**
    * Ordena um array de inteiros utilizando o insertion sort.
    */
    public void sort(int[] v) {
        for (int i = 1; i < v.length; i++) { 
		
            int j = i;
        
            while (j > 0 && v[j] < v[j-1]) {
                int aux = v[j];
                v[j] = v[j - 1];
                v[j - 1] = aux;
                j -= 1;
            }
        
        }	
    }

    /**
    * Ordena um array de inteiros utilizando o insertion sort de maneira recursiva.
    * Pense que insertion sort são várias execuções da inserção ordenada e use
    * essa estratégia chamando recursivamente. 
    * Você não pode mudar a assinatura desse método, mas pode/deve criar outros
    * métodos para te auxiliar na recursão.
    */
    public void sortRecursivo(int[] v) {
        sortRecursivo(v, 1);
    }

    private void sortRecursivo(int[] v, int index) {
        
        if(index > 0 && index < v.length) {

            int proximo = index + 1;
            
            while (index > 0 && v[index] < v[index - 1]) {
                int aux = v[index];
                v[index] = v[index - 1];
                v[index - 1] = aux;
                index -= 1;
            }

            sortRecursivo(v, proximo);
        }

    }
  
}
