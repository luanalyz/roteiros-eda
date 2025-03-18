import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void testStrategy() {
        
        FIFOEvictionStrategy fifocache = new FIFOEvictionStrategy(3);
        assertNull(fifocache.getNextEviction());
        assertEquals(0, fifocache.size());
        assertEquals("miss", fifocache.get("a"));
        assertNull(fifocache.getNextEviction());
        assertEquals(1, fifocache.size());
        assertEquals("hit", fifocache.get("a"));
        assertEquals(1, fifocache.size());

        assertEquals("miss", fifocache.get("b"));
        assertNull(fifocache.getNextEviction());
        assertEquals("miss", fifocache.get("c"));
        assertEquals("hit", fifocache.get("b"));
        assertEquals("hit", fifocache.get("c"));
        assertEquals(3, fifocache.size());


        // agora o nextEviction não é mais nulo porque o cache está cheio
        assertEquals("a", fifocache.getNextEviction());
        assertEquals("miss", fifocache.get("d"));
        // o próximo é b porque a saiu
        assertEquals("b", fifocache.getNextEviction());

        // "a" teve que sair para a entrada do "d"
        assertEquals("miss", fifocache.get("a"));

        // com a entrada de a, b saiu e c é o próximo a sair
        assertEquals("c", fifocache.getNextEviction());
        assertEquals("miss", fifocache.get("b"));
    }
}
