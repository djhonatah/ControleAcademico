package com.interfaces;

public interface InterfaceList {
   
   public void add(String value);
   
   public void clear();
   
   public boolean contains(String value);
   
   public String get(int index);
   
   public boolean isEmpty();
   
   public boolean remove(String value);
   
   public int size();
   
   public Object[] toArray();
}
