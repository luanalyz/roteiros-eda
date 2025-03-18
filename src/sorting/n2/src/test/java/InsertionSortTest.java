import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sorting.InsertionSort;

public class InsertionSortTest {

    InsertionSort sorting = new InsertionSort(); 
    int[] v;

    @Test
    public void testInsereUltimoOrdenado() {
        v = new int[]{1, 2, 3, 4, 5, 6, -1};
        sorting.insereUltimoOrdenado(v);
        assertArrayEquals(new int[]{-1, 1, 2, 3, 4, 5, 6}, v);

        v = new int[]{1, 1, 1, 0};
        sorting.insereUltimoOrdenado(v);
        assertArrayEquals(new int[]{0, 1, 1, 1}, v);


        v = new int[]{1, -1};
        sorting.insereUltimoOrdenado(v);
        assertArrayEquals(new int[]{-1, 1}, v);

        v = new int[]{10, 20, 30, 40, 25};
        sorting.insereUltimoOrdenado(v);
        assertArrayEquals(new int[]{10, 20, 25, 30, 40}, v);
    }

    @Test
    public void testInsereUltimoOrdenadoExtra() {
        v = new int[]{0, 1, 1, 2, 2, 3, 0};
        sorting.insereUltimoOrdenado(v);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2, 3}, v);
    }

    @Test
    public void testInserePrimeiroOrdenado() {
        v = new int[]{4, 1, 2, 3};
        sorting.inserePrimeiroOrdenado(v);
        assertArrayEquals(new int[]{1, 2, 3, 4}, v);

        v = new int[]{10, 2, 5};
        sorting.inserePrimeiroOrdenado(v);
        assertArrayEquals(new int[]{2, 5, 10}, v);


        v = new int[]{1, -1};
        sorting.inserePrimeiroOrdenado(v);
        assertArrayEquals(new int[]{-1, 1}, v);

        v = new int[]{25, 10, 20, 30, 40};
        sorting.inserePrimeiroOrdenado(v);
        assertArrayEquals(new int[]{10, 20, 25, 30, 40}, v);
    }

    @Test
    public void testInserePrimeiroOrdenadoExtra() {
        v = new int[]{3, 1, 1, 2, 2, 3};
        sorting.inserePrimeiroOrdenado(v);
        assertArrayEquals(new int[]{1, 1, 2, 2, 3, 3}, v);
    }

    @Test
    public void testSort() {

        // já ordenado
        int[] v = new int[]{1, 2, 3, 4, 5};
        sorting.sort(v);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, v);

        // limite final
        v = new int[]{1, 2, 3, 4, 5, -1};
        sorting.sort(v);
        assertArrayEquals(new int[]{-1, 1, 2, 3, 4, 5}, v);

        // limite inicial
        v = new int[]{10, 1, 2, 3, 4, 5};
        sorting.sort(v);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 10}, v);

        // limite final, meio
        v = new int[]{10, 20, 30, 40, 50, 15};
        sorting.sort(v);
        assertArrayEquals(new int[]{10, 15, 20, 30, 40, 50}, v);

        // limite inicio, meio
        v = new int[]{45, 10, 20, 30, 40, 50};
        sorting.sort(v);
        assertArrayEquals(new int[]{10, 20, 30, 40, 45, 50}, v);

        // reverso
        v = new int[]{5, 4, 3, 2, 1};
        sorting.sort(v);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, v);

        // um elemento
        v = new int[]{5};
        sorting.sort(v);
        assertArrayEquals(new int[]{5}, v);


        v = new int[]{5, 1, 25, 2,  -9, 10};
        sorting.sort(v);
        assertArrayEquals(new int[]{-9, 1, 2, 5, 10, 25}, v);

    }

    @Test
    public void testSortRecursivo() {

        // já ordenado
        int[] v = new int[]{1, 2, 3, 4, 5};
        sorting.sortRecursivo(v);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, v);

        // limite final
        v = new int[]{1, 2, 3, 4, 5, -1};
        sorting.sortRecursivo(v);
        assertArrayEquals(new int[]{-1, 1, 2, 3, 4, 5}, v);

        // limite inicial
        v = new int[]{10, 1, 2, 3, 4, 5};
        sorting.sortRecursivo(v);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 10}, v);

        // limite final, meio
        v = new int[]{10, 20, 30, 40, 50, 15};
        sorting.sortRecursivo(v);
        assertArrayEquals(new int[]{10, 15, 20, 30, 40, 50}, v);

        // limite inicio, meio
        v = new int[]{45, 10, 20, 30, 40, 50};
        sorting.sortRecursivo(v);
        assertArrayEquals(new int[]{10, 20, 30, 40, 45, 50}, v);

        // reverso
        v = new int[]{5, 4, 3, 2, 1};
        sorting.sortRecursivo(v);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, v);

        // um elemento
        v = new int[]{5};
        sorting.sortRecursivo(v);
        assertArrayEquals(new int[]{5}, v);


        v = new int[]{5, 1, 25, 2,  -9, 10};
        sorting.sortRecursivo(v);
        assertArrayEquals(new int[]{-9, 1, 2, 5, 10, 25}, v);

    }

}
