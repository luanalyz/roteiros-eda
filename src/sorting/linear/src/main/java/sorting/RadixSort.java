package sorting;

import java.util.Arrays;

public class RadixSort {

	// Você pode assumir que todos os valores possuem a mesma quantidade de dígitos
	// Caso precise do counting sort, use o que você já implementou na outra classe.
	public int[] radixSort(int[] v) {
		if (v == null || v.length == 0) {
			return new int[0];
        	}

		int[] output = Arrays.copyOf(v, v.length);
        	int max = getMax(v);

	        for (int exp = 1; max / exp > 0; exp *= 10) {
	            CountingSort.classicCountingSort(output, exp);
	        }
	
		return output;
	}

	private static int getMax(int[] array) {
	        int max = array[0];
	        for (int num : array) {
	            if (num > max) {
	                max = num;
	            }
	        }
	        return max;
    	}

}
