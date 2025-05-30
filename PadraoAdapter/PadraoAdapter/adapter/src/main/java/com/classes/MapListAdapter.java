package com.classes;

import java.util.Collection;
import java.util.Map;

import com.interfaces.InterfaceList;
import com.interfaces.InterfaceMap;

public class MapListAdapter implements InterfaceList, InterfaceMap {
    private Map<Integer, String> map;

    public MapListAdapter(Map<Integer, String> map) {
        this.map = map;
    }

    // Exceções internas
    public static class InvalidIndexException extends RuntimeException {
        public InvalidIndexException(String message) {
            super(message);
        }
    }

    public static class NullKeyException extends RuntimeException {
        public NullKeyException(String message) {
            super(message);
        }
    }

    // Métodos da InterfaceList
    @Override
    public void add(String value) {
        map.put(map.size(), value);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(String value) {
        return map.containsValue(value);
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= map.size()) {
            throw new InvalidIndexException("Índice inválido: " + index);
        }
        return map.get(index);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean remove(String value) {
        Integer keyToRemove = null;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                keyToRemove = entry.getKey();
                break;
            }
        }
        if (keyToRemove != null) {
            map.remove(keyToRemove);
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Object[] toArray() {
        return map.values().toArray();
    }

    // Métodos da InterfaceMap
    @Override
    public void put(Integer key, String value) {
        if (key == null) {
            throw new NullKeyException("Chave nula não é permitida.");
        }
        map.put(key, value);
    }

    @Override
    public String get(Integer key) {
        return map.get(key);
    }

    @Override
    public boolean containsKey(Integer key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return map.containsValue(value);
    }

    @Override
    public void remove(Integer key) {
        if (key == null) {
            throw new NullKeyException("Chave nula não é permitida.");
        }
        map.remove(key);
    }

    @Override
    public Collection<String> values() {
        return map.values();
    }
}
