import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionFactory {

    @Test
    public void mapTest() {
        Map<String, String> map = Map.of("a", "aaa", "b", "bbb");

        assertEquals(map.size(), 2);
        assertEquals(map.get("a"), "aaa");
        assertEquals(map.get("b"), "bbb");
    }

    @Test
    public void listTest() {
        List<String> list  = List.of("aaa", "bbb", "ccc");

        assertEquals(list.size(), 3);
        assertEquals(list.get(0), "aaa");
        assertEquals(list.get(1), "bbb");
        assertEquals(list.get(2), "ccc");
    }
}
