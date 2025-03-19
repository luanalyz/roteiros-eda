package sorting;

import java.util.Arrays;

public class CountingSort {
   
    /**
    * Implemente a versão clássica do counting sort que vimos em sala de aula. Você pode
    * criar métodos auxiliares se precisar.
    */

    public static int[] classicCountingSort(int[] a, int k) {
        int[] c = new int[k];
        int[] b = new int[a.length];

        //frequencia
        for (int i = 0; i < a.length; i++) {
            c[a[i] - 1] += 1;
        }

        //cumulativa
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i-1];
        }

        for(int i = a.length - 1; i >= 0; i--) {
            b[c[a[i] - 1] - 1] = a[i];
            c[a[i]-1] -=1;
        }
        return b;
    }

    /**
    * Implemente uma versão do counting sort que aceita valor 0 na coleção original.
    */
    public static int[] zeroCountingSort(int[] v, int k) {
        int[] c = new int[k + 1];
        int[] b = new int[v.length];

        for (int i = 0; i < v.length; i++) {
            c[v[i] - 1] += 1;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] += c[i-1];
        }

        for(int i = v.length - 1; i >= 0; i--) {
            b[c[v[i] - 1] - 1] = v[i];
            c[v[i]-1] -= 1;
        }

        return b;
    }

    /**
    * Implemente uma versão do counting sort que aceita valores negativos na coleção original. Você
    * vai precisar identificar o menor elemento do array. FAça isso no início do método.
    */
    public static int[] negativosCountingSort(int[] v, int k) {
        int[] b = new int[v.length];
        if(v.length > 0) {
            int menor = v[0];
        
            for(int i = 0; i < v.length; i++) {
                if(v[i] < menor) {
                    menor = v[i]; 
                }
            }
            
            int[] c = new int[k - menor + 1];

            for(int i = 0; i < v.length; i++)
                c[v[i] - menor] += 1;

            for(int i = 1; i < c.length; i++)
                c[i] += c[i - 1];
            
            for(int i = v.length -1; i >= 0; i--) {
                b[c[v[i]-menor]-1] = v[i];
                c[v[i]-menor] -=1;
            }
        }
        return b;
    }

}
