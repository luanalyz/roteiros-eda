import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sorting.SelectionSort;

public class SelectionSortTest {
    
    SelectionSort s = new SelectionSort();
    int[] v;

    @Test
    public void testSort() {

        // já ordenado
        int[] v = new int[]{1, 2, 3, 4, 5};
        s.sort(v);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, v);

        // limite final
        v = new int[]{1, 2, 3, 4, 5, -1};
        s.sort(v);
        assertArrayEquals(new int[]{-1, 1, 2, 3, 4, 5}, v);

        // limite inicial
        v = new int[]{10, 1, 2, 3, 4, 5};
        s.sort(v);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 10}, v);

        // limite final, meio
        v = new int[]{10, 20, 30, 40, 50, 15};
        s.sort(v);
        assertArrayEquals(new int[]{10, 15, 20, 30, 40, 50}, v);

        // limite inicio, meio
        v = new int[]{45, 10, 20, 30, 40, 50};
        s.sort(v);
        assertArrayEquals(new int[]{10, 20, 30, 40, 45, 50}, v);

        // reverso
        v = new int[]{5, 4, 3, 2, 1};
        s.sort(v);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, v);

        // um elemento
        v = new int[]{5};
        s.sort(v);
        assertArrayEquals(new int[]{5}, v);


        v = new int[]{5, 1, 25, 2,  -9, 10};
        s.sort(v);
        assertArrayEquals(new int[]{-9, 1, 2, 5, 10, 25}, v);
    }

    @Test
    public void testSortRecursivo() {

        // já ordenado
        int[] v = new int[]{1, 2, 3, 4, 5};
        s.sortRecursivo(v);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, v);

        // limite final
        v = new int[]{1, 2, 3, 4, 5, -1};
        s.sortRecursivo(v);
        assertArrayEquals(new int[]{-1, 1, 2, 3, 4, 5}, v);

        // limite inicial
        v = new int[]{10, 1, 2, 3, 4, 5};
        s.sortRecursivo(v);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 10}, v);

        // limite final, meio
        v = new int[]{10, 20, 30, 40, 50, 15};
        s.sortRecursivo(v);
        assertArrayEquals(new int[]{10, 15, 20, 30, 40, 50}, v);

        // limite inicio, meio
        v = new int[]{45, 10, 20, 30, 40, 50};
        s.sortRecursivo(v);
        assertArrayEquals(new int[]{10, 20, 30, 40, 45, 50}, v);

        // reverso
        v = new int[]{5, 4, 3, 2, 1};
        s.sortRecursivo(v);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, v);

        // um elemento
        v = new int[]{5};
        s.sortRecursivo(v);
        assertArrayEquals(new int[]{5}, v);


        v = new int[]{5, 1, 25, 2,  -9, 10};
        s.sortRecursivo(v);
        assertArrayEquals(new int[]{-9, 1, 2, 5, 10, 25}, v);

    }

}
