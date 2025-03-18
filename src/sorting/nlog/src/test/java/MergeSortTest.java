import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sorting.MergeSort;


public class MergeSortTest {

    MergeSort m = new MergeSort();
    int[] v, w, esperado;

    @Test
    public void testMergeOrdenadosCrescente() {
        v = new int[]{1,3,5,7};
        w = new int[]{2,4,6,8};
        esperado = new int[]{1,2,3,4,5,6,7,8};
        assertEquals(m.mergeOrdenadosCrescente(v, w), esperado);
    }

}
