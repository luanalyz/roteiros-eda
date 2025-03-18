import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RoteiroTest {
    
    private BST b;
    
    @Test
    public void testSearch() {
        b = new BST();
        assertTrue(b.isEmpty());
        assertNull(b.search(50));
        b.add(50);
        assertFalse(b.isEmpty());
        assertEquals(50, b.search(50).value);
        b.add(60);
        b.add(40);
        assertEquals(40, b.search(40).value);
        assertEquals(60, b.search(60).value);
        assertNull(b.search(986));
        b.add(55);
        assertEquals(55, b.search(55).value);
    }

    @Test
    public void testHeigth() {
        b = new BST();
        assertEquals(-1, b.height());
        b.add(50);
        assertEquals(0, b.height());
        b.add(60);
        assertEquals(1, b.height());
        b.add(40);
        assertEquals(1, b.height());
        b.add(12);
        assertEquals(2, b.height());
        b.add(55);
        assertEquals(2, b.height());
        b.add(57);
        assertEquals(3, b.height());
    }

    @Test
    public void testEqualsElemIguaisOrdemDif() {
        b = new BST();
        BST outro = new BST();
        assertTrue(b.equals(outro));
        b.add(50);
        outro.add(50);
        assertTrue(b.equals(outro));
        b.add(1);
        b.add(40);
        outro.add(40);
        outro.add(1);
        assertFalse(b.equals(outro));
    }

    @Test
    public void testEquals() {
        b = new BST();
        BST outro = new BST();
        assertTrue(b.equals(outro));
        b.add(50);
        outro.add(50);
        assertTrue(b.equals(outro));
        b.add(60);
        outro.add(60);
        assertTrue(b.equals(outro));
        b.add(40);
        outro.add(40);
        assertTrue(b.equals(outro));
        b.add(1);
        assertFalse(b.equals(outro));
    }

    @Test
    public void testContaFolhas() {
        b = new BST();
        assertEquals(0, b.contaFolhas());
        b.add(50);
        assertEquals(1, b.contaFolhas());
        b.add(40);
        assertEquals(1, b.contaFolhas());
        b.add(60);
        assertEquals(2, b.contaFolhas());
        b.add(1);
        assertEquals(2, b.contaFolhas());
        b.add(55);
        b.add(61);
        assertEquals(3, b.contaFolhas());
    }

    @Test
    public void testSucessor() {
        b = new BST();
        b.add(50);
        b.add(40);
        b.add(60);
        b.add(55);
        b.add(65);
        b.add(63);
        assertEquals(b.search(55), b.sucesor(50));
        assertEquals(b.search(63), b.sucesor(60));
        assertEquals(b.search(50), b.sucesor(40));
        assertNull(b.sucesor(65));
    }

    @Test
    public void testPredecessor() {
        b = new BST();
        b.add(50);
        b.add(40);
        b.add(60);
        b.add(55);
        b.add(65);
        b.add(63);
        assertNull(b.predecessor(40));
        assertEquals(b.search(63), b.predecessor(65));
        assertEquals(b.search(60), b.predecessor(63));
        assertEquals(b.search(40), b.predecessor(50));
    }

    @Test
    public void testRemove() {
        BST bst = new BST();
        bst.add(85);
        bst.add(49);
        bst.add(97);
        bst.add(7);
        bst.add(53);
        bst.add(93);
        bst.add(51);
        bst.add(81);
        bst.add(65);
        bst.add(55);
        
        BST expectedBFS = new BST();
        expectedBFS.add(85);
        expectedBFS.add(49);
        expectedBFS.add(97);
        expectedBFS.add(7);
        expectedBFS.add(53);
        expectedBFS.add(93);
        expectedBFS.add(51);
        expectedBFS.add(81);
        expectedBFS.add(65);
        expectedBFS.add(55);
        
        assertTrue(bst.equals(expectedBFS));
        
        bst.remove(85);
        expectedBFS = new BST();
        expectedBFS.add(93);
        expectedBFS.add(49);
        expectedBFS.add(97);
        expectedBFS.add(7);
        expectedBFS.add(53);
        expectedBFS.add(51);
        expectedBFS.add(81);
        expectedBFS.add(65);
        expectedBFS.add(55);
        assertTrue(bst.equals(expectedBFS));
        
        bst.remove(93);
        expectedBFS = new BST();
        expectedBFS.add(97);
        expectedBFS.add(49);
        expectedBFS.add(7);
        expectedBFS.add(53);
        expectedBFS.add(51);
        expectedBFS.add(81);
        expectedBFS.add(65);
        expectedBFS.add(55);
        assertTrue(bst.equals(expectedBFS));
        
        bst.remove(7);
        expectedBFS = new BST();
        expectedBFS.add(97);
        expectedBFS.add(49);
        expectedBFS.add(53);
        expectedBFS.add(51);
        expectedBFS.add(81);
        expectedBFS.add(65);
        expectedBFS.add(55);
        assertTrue(bst.equals(expectedBFS));
        
        bst.remove(97);
        expectedBFS = new BST();
        expectedBFS.add(49);
        expectedBFS.add(53);
        expectedBFS.add(51);
        expectedBFS.add(81);
        expectedBFS.add(65);
        expectedBFS.add(55);
        assertTrue(bst.equals(expectedBFS));
        
        bst.remove(53);
        expectedBFS = new BST();
        expectedBFS.add(49);
        expectedBFS.add(55);
        expectedBFS.add(51);
        expectedBFS.add(81);
        expectedBFS.add(65);
        assertTrue(bst.equals(expectedBFS));
        assertEquals(5, bst.size());

        bst.remove(81);
        expectedBFS = new BST();
        expectedBFS.add(49);
        expectedBFS.add(55);
        expectedBFS.add(51);
        expectedBFS.add(65);
        assertTrue(bst.equals(expectedBFS));
        
        bst.remove(51);
        expectedBFS = new BST();
        expectedBFS.add(49);
        expectedBFS.add(55);
        expectedBFS.add(65);
        assertTrue(bst.equals(expectedBFS));
        
        bst.remove(55);
        expectedBFS = new BST();
        expectedBFS.add(49);
        expectedBFS.add(65);
        assertTrue(bst.equals(expectedBFS));
        
        bst.remove(49);
        expectedBFS = new BST();
        expectedBFS.add(65);
        assertTrue(bst.equals(expectedBFS));
        
        bst.remove(65);
        expectedBFS = new BST();
        assertTrue(bst.equals(expectedBFS));
        
        bst.add(65);
        expectedBFS = new BST();
        expectedBFS.add(65);
        assertTrue(bst.equals(expectedBFS));
        assertEquals(bst.size(), 1);
    }
}
