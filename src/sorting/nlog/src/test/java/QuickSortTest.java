import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sorting.QuickSort;

public class QuickSortTest {

    QuickSort sorting = new QuickSort(); 
    int[] v;

    @Test
    public void testMediana() {
        v = new int[]{1};
        assertEquals(1, sorting.mediana(v));

        v = new int[]{1, 1, 1};
        assertEquals(1, sorting.mediana(v));

        v = new int[]{5,1,4,3,2,6,7};
    	assertEquals(4, sorting.mediana(v));

        v = new int[]{5,1,4,3,2,6,7,11,9,8,10};
        assertEquals(6, sorting.mediana(v));

        v = new int[]{8, 1, 78, 45, 3, 2, 103};
        assertEquals(8, sorting.mediana(v));
    }

    @Test
    public void testSort() {
        v = new int[]{8, 1, 78, 45, 3, 2, 103};
        sorting.sort(v, 0, v.length - 1);
        assertArrayEquals(new int[]{1, 2, 3, 8, 45, 78, 103}, v);	

        v = new int[]{2};
        sorting.sort(v, 0, v.length - 1);
        assertArrayEquals(new int[]{2}, v); 

        v = new int[]{1, 2, 3, -4};
        sorting.sort(v, 0, v.length - 1);
        assertArrayEquals(new int[]{-4, 1, 2, 3}, v); 

        v = new int[]{10, 2, 3, 4};
        sorting.sort(v, 0, v.length - 1);
        assertArrayEquals(new int[]{2, 3, 4, 10}, v); 
    }	

    @Test
    public void testMedianaDeTres() {

    	int[] v = new int[]{1, 2, 3, 4, 5};
    	assertEquals(3, sorting.medianaDeTres(v));

    	v = new int[]{4, 8, 10, 12};
        assertEquals(8, sorting.medianaDeTres(v));    	
    	
        v = new int[]{40, 8, 10, 12, 12};
        assertEquals(12, sorting.medianaDeTres(v));      
        
        v = new int[]{12, 8, 40, 12, 10};
        assertEquals(12, sorting.medianaDeTres(v));      
        
    }
        
}




