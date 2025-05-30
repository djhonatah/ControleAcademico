import com.classes.MapListAdapter;
import com.interfaces.InterfaceList;
import com.interfaces.InterfaceMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapListAdapterTest {

    private InterfaceList listAdapter;
    private InterfaceMap mapAdapter;

    @BeforeEach
    void setup() {
        Map<Integer, String> map = new HashMap<>();
        listAdapter = new MapListAdapter(map);
        mapAdapter = (InterfaceMap) listAdapter;
    }

    @Test
    void testAddAndGet() {
        listAdapter.add("Java");
        assertEquals("Java", listAdapter.get(0));
    }

    @Test
    void testGetInvalidIndex() {
        assertThrows(MapListAdapter.InvalidIndexException.class, () -> listAdapter.get(1));
    }

    @Test
    void testPutNullKeyThrowsException() {
        assertThrows(MapListAdapter.NullKeyException.class, () -> mapAdapter.put(null, "Valor"));
    }

    @Test
    void testRemoveNullKeyThrowsException() {
        assertThrows(MapListAdapter.NullKeyException.class, () -> mapAdapter.remove(null));
    }

    @Test
    void testContainsValue() {
        listAdapter.add("Test");
        assertTrue(listAdapter.contains("Test"));
    }

    @Test
    void testRemoveValue() {
        listAdapter.add("Remover");
        assertTrue(listAdapter.remove("Remover"));
        assertFalse(listAdapter.contains("Remover"));
    }

    @Test
    void testClearAndIsEmpty() {
        listAdapter.add("A");
        listAdapter.clear();
        assertTrue(listAdapter.isEmpty());
    }

    @Test
    void testSizeAndToArray() {
        listAdapter.add("A");
        listAdapter.add("B");
        assertEquals(2, listAdapter.size());
        assertArrayEquals(new String[]{"A", "B"}, listAdapter.toArray());
    }

    @Test
    void testMapSpecificMethods() {
        mapAdapter.put(100, "Z");
        assertEquals("Z", mapAdapter.get(100));
        assertTrue(mapAdapter.containsKey(100));
        assertTrue(mapAdapter.containsValue("Z"));
    }
}
