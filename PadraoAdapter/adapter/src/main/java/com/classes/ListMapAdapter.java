package com.classes;

import java.util.Collection;
import java.util.List;

import com.interfaces.InterfaceMap;

public class ListMapAdapter implements InterfaceMap {
    private List<String> list;

    public ListMapAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public void put(Integer key, String value) {
        while (list.size() <= key) {
            list.add(null);
        }
        list.set(key, value);
    }

    @Override
    public String get(Integer key) {
        if (key < list.size()) {
            return list.get(key);
        }
        return null;
    }

    @Override
    public boolean containsKey(Integer key) {
        return key < list.size() && list.get(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        return list.contains(value);
    }

    @Override
    public void remove(Integer key) {
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
