package sorting;

public class MergeSort implements SortingStrategy {


    /**
    * Implemente o método abaixo, que recebe dois arrays ordenados em forma crescente
    * e retorna um novo array também ordenado em forma crescente.
    */
    public static int[] mergeOrdenadosCrescente(int[] a, int[] b) {
        
        int[] helper = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < a.length && j < b.length) {
            
            if(a[i] < b[j]) {
                helper[k] = a[i];
                i++;
            } else {
                helper[k] = b[j];
                j++;
            }
            k++;
        }
        
        while(i < a.length) {
            helper[k] = a[i];
            i++;
            k++;
        }
        
        while(j < b.length) {
            helper[k] = b[j];
            j++;
            k++;
        }

        return helper;
    }
    
    /**
    * Implemente o método abaixo, que recebe dois arrays ordenados em forma decrescente
    * e retorna um novo array ordenado em forma crescente.
    */
    public static int[] mergeOrdenadosDecrescente(int[] a, int[] b) {
        int[] helper = new int[a.length + b.length];
        int i = a.length - 1;
        int j = b.length - 1;
        int k = 0;
        
        while(i >= 0 && j >= 0) {
            
            if(a[i] < b[j]) {
                helper[k] = a[i];
                i--;
            } else {
                helper[k] = b[j];
                j--;
            }
            k++;
        }
        
        while(i >= 0) {
            helper[k] = a[i];
            i--;
            k++;
        }
        
        while(j >= 0) {
            helper[k] = b[j];
            j--;
            k++;
        }
        return helper;
    }
   
    /**
    * Implemente o método abaixo, que recebe dois arrays: a, ordenado em forma crescente e b, ordenado
    * em forma descrescente. Seu método deve retornar um array ordenado em forma crescente.
    */
    public static int[] mergeOrdenadosDistintos(int[] a, int[] b) {
        int[] helper = new int[a.length + b.length];
        int i = 0;
        int j = b.length - 1;
        int k = 0;
        
        while(i < a.length && j >= 0) {
            
            if(a[i] < b[j]) {
                helper[k] = a[i];
                i++;
            } else {
                helper[k] = b[j];
                j--;
            }
            k++;
        }
        
        while(i < a.length) {
            helper[k] = a[i];
            i++;
            k++;
        }
        
        while(j >= 0) {
            helper[k] = b[j];
            j--;
            k++;
        }
        return helper;
    }
   
    /**
    * Implemente a versão clássica do merge sort que vimos em sala de aula. Você pode
    * criar métodos auxiliares se precisar.
    */
    public  void sort(int[] v, int ini, int fim) {
        if (ini >= fim)
            return;
        
        else {
            
            int meio = (ini + fim) / 2;
            sort(v, ini, meio);
            sort(v, meio + 1, fim);
    
            merge(v, ini, meio, fim);
        }
    }

    private static void merge(int[] v, int ini, int meio, int fim) {
        
        int[] helper = new int[v.length];
		
        for (int i = ini; i <= fim; i++) {
			helper[i] = v[i];
		}
		
		int i = ini;
		int j = meio + 1;
		int k = ini;
		
		while (i <= meio && j <= fim) {
			
			if (helper[i] < helper[j]) {
				v[k] = helper[i];
				i++;
			} else {
				v[k] = helper[j];
				j++;
			}
			k++;
		}
		
		while (i <= meio) {
			v[k] = helper[i];
			i++;
			k++;
		}
		
        while (j <= fim) {
			v[k] = helper[j];
			j++;
			k++;
		}
    }

}
