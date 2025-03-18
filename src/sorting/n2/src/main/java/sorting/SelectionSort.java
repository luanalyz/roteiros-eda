package sorting;

public class SelectionSort implements SortingStrategy {

    /**
    * Ordena um array de inteiros utilizando o selection sort.
    */
    public void sort(int[] v) {
        for (int i = 0; i < v.length; i++) {
		
            int menor = i;
            for (int j = i + 1; j < v.length; j++)
                if (v[j] < v[menor])
                    menor = j;
            
            int aux = v[i];
            v[i] = v[menor];
            v[menor] = aux;
        
        }		
    }

    /**
    * Ordena um array de inteiros utilizando o selection sort de maneira recursiva.
    * Pense que selection sort são várias execuções da atividade de procurar 
    * o menor e colocá-lo em seu lugar. Use essa estratégia chamando recursivamente. 
    * Você não pode mudar a assinatura desse método, mas pode/deve criar outros
    * métodos para te auxiliar na recursão.
    */
    public void sortRecursivo(int[] v) {
        sortRecursivo(v, 0);
    }

    private void sortRecursivo(int[] v, int i) {
        if(i < v.length) {
            int menor = i;
            for (int j = i + 1; j < v.length; j++)
                if (v[j] < v[menor])
                    menor = j;
            
            int aux = v[i];
            v[i] = v[menor];
            v[menor] = aux;
            sortRecursivo(v, i + 1);
        }		
    }
    
}
