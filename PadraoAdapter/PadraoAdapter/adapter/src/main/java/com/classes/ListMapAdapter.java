package com.classes;

import java.util.Collection;
import java.util.List;

import com.interfaces.InterfaceMap;

public class ListMapAdapter implements InterfaceMap {
    private List<String> list;

    public ListMapAdapter(List<String> list) {
        this.list = list;
    }

    // Exceções internas
    public static class NullKeyException extends RuntimeException {
        public NullKeyException(String message) {
            super(message);
        }
    }

    public static class InvalidKeyException extends RuntimeException {
        public InvalidKeyException(String message) {
            super(message);
        }
    }

    @Override
    public void put(Integer key, String value) {
        if (key == null) throw new NullKeyException("Chave nula não é permitida.");
        if (key < 0) throw new InvalidKeyException("Chave negativa não é permitida: " + key);

        while (list.size() <= key) {
            list.add(null);
        }
        list.set(key, value);
    }

    @Override
    public String get(Integer key) {
        if (key == null) throw new NullKeyException("Chave nula não é permitida.");
        if (key < 0) throw new InvalidKeyException("Chave negativa não é permitida: " + key);
        if (key < list.size()) {
            return list.get(key);
        }
        return null;
    }

    @Override
    public boolean containsKey(Integer key) {
        if (key == null || key < 0) return false;
        return key < list.size() && list.get(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        return list.contains(value);
    }

    @Override
    public void remove(Integer key) {
        if (key == null) throw new NullKeyException("Chave nula não é permitida.");
        if (key < 0) throw new InvalidKeyException("Chave negativa não é permitida: " + key);
        if (key < list.size()) {
            list.set(key, null);
        }
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Collection<String> values() {
        return list;
    }
}
