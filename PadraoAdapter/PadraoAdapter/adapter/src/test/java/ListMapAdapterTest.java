import com.classes.ListMapAdapter;
import com.interfaces.InterfaceMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListMapAdapterTest {

    private InterfaceMap mapAdapter;

    @BeforeEach
    void setup() {
        List<String> list = new ArrayList<>();
        mapAdapter = new ListMapAdapter(list);
    }

    @Test
    void testPutAndGet() {
        mapAdapter.put(2, "Test");
        assertEquals("Test", mapAdapter.get(2));
    }

    @Test
    void testPutNullKeyThrowsException() {
        assertThrows(ListMapAdapter.NullKeyException.class, () -> mapAdapter.put(null, "Value"));
    }

    @Test
    void testPutNegativeKeyThrowsException() {
        assertThrows(ListMapAdapter.InvalidKeyException.class, () -> mapAdapter.put(-1, "Value"));
    }

    @Test
    void testGetNullKeyThrowsException() {
        assertThrows(ListMapAdapter.NullKeyException.class, () -> mapAdapter.get(null));
    }

    @Test
    void testGetNegativeKeyThrowsException() {
        assertThrows(ListMapAdapter.InvalidKeyException.class, () -> mapAdapter.get(-5));
    }

    @Test
    void testContainsKeyAndValue() {
        mapAdapter.put(0, "Hello");
        assertTrue(mapAdapter.containsKey(0));
        assertTrue(mapAdapter.containsValue("Hello"));
    }

    @Test
    void testRemoveKey() {
        mapAdapter.put(1, "ToRemove");
        mapAdapter.remove(1);
        assertFalse(mapAdapter.containsKey(1));
    }

    @Test
    void testRemoveNullKeyThrowsException() {
        assertThrows(ListMapAdapter.NullKeyException.class, () -> mapAdapter.remove(null));
    }

    @Test
    void testRemoveNegativeKeyThrowsException() {
        assertThrows(ListMapAdapter.InvalidKeyException.class, () -> mapAdapter.remove(-3));
    }

    @Test
    void testClearAndIsEmpty() {
        mapAdapter.put(0, "X");
        mapAdapter.clear();
        assertTrue(mapAdapter.isEmpty());
    }

    @Test
    void testSizeAndValues() {
        mapAdapter.put(0, "A");
        mapAdapter.put(1, "B");
        assertEquals(2, mapAdapter.size());
        assertTrue(mapAdapter.values().contains("A"));
        assertTrue(mapAdapter.values().contains("B"));
    }
}
