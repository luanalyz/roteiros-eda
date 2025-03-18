package sorting;

import java.util.Arrays;

public class QuickSort implements SortingStrategy {

    /*
       A mediana de uma sequência de tamanho ímpar é o valor que divide uma sequência ao meio, isto é, 
       metado dos valores são menores que ela, enquanto metade são maiores. Implemente o método abaixo
       que recebe uma sequência de tamanho ímpar e retorna a mediana dessa sequência.
    */
    public int mediana(int[] v) {
        
        Arrays.sort(v);
        int meio = (v.length - 1) / 2;

        return v[meio];
    }

    /**
    * Implemente a versão do quick sort usando o particionamento Hoare, que está descrito
    * neste material: https://joaoarthurbm.github.io/eda/posts/particionamento-hoare/
    */
    public void sort(int[] v, int ini, int fim) {
        if (ini < fim) {
            int index_pivot = partition(v, ini, fim);
            sort(v, ini, index_pivot - 1);
            sort(v, index_pivot + 1, fim);	
        }
    }
    

    /*
     * Muda os valores de 2 ints em uma lista,
     */
    public static int[] swap(int[] v, int i, int j) {
        
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
        
        return v;
    }

    /*
     * Faz o particionamento.
     */
    public static int partition(int[] v, int ini, int fim) {
        
        int pivot = v[ini];
        int i = ini;

        for (int j = ini + 1; j <= fim; j++) {
            if (v[j] <= pivot) {
                i+=1;
                swap(v, i, j);
            }
        }

        // troca pivot (v[ini]) com i.
        swap(v, ini, i);
        
        return i; 
    }
    /**
    * Nós discutimos em sala de aula que uma tentativa para melhorar a escolha do pivot é
    * decidir usar o valores mediano (não média, cuidado) entre o primeiro elemento do array,
    * o elemento central e o último.

    * Implemente o método abaixo que retorna o valor que seria escolhido como pivot seguindo
    * a abordagem acima.
    * 
    * Interprete os testes para saber qual valor usar como elemento central para calcular a mediana de três.
    */
    public int medianaDeTres(int[] v) {
        
        int meio = (v.length - 1) / 2;

        int[] helper = new int[]{v[0], v[meio], v[v.length - 1]};
        
        Arrays.sort(helper);
        
        return helper[1];
    }

}
