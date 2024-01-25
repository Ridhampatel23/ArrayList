package edu.csun.comp182;

public interface MyCollection<E>{
    public void clear ();

    public  boolean isEmpty();

    public int size();

    public void add(E item);

    public boolean contains(E key);

    public boolean remove(Object obj);
}
