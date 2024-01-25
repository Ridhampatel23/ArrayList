 package edu.csun.comp182;

import java.util.NoSuchElementException;

public class MyArrayList<E> implements MyCollection<E> {

    private E[] items_array;
    private int used_counter;

    public MyArrayList() {
        used_counter = 0;
        items_array = (E[]) new Object[2];

    }

    public MyArrayList(int initial_capacity){
        used_counter = 0;
        items_array = (E[]) new Object[initial_capacity];
    }

    @Override
    public void clear() {
        used_counter = 0;
    }

    @Override
    public boolean isEmpty() {
        return used_counter == 0;
    }

    private boolean isFull() {
        return used_counter == items_array.length;
    }

    @Override
    public int size() {
        return used_counter;
    }

    private void resizeArray(int desired_size) {
        E[] replacement_array = (E[]) new Object[desired_size];
        for (int index = 0;
             index < items_array.length && index < replacement_array.length;
             index++) {
            replacement_array[index] = items_array[index];

        }
        items_array = replacement_array;
    }

    public void add(E item) {
        if (isFull())
            resizeArray(items_array.length * 2);

        items_array[used_counter] = item;
        used_counter++;

    }

    private int findIndexOf(Object key) throws NoSuchElementException {
        int index = 0;
        boolean found = false;
        while (index < used_counter) {
            if (key == null) {
                if (items_array[index] == null)
                    return index;
            } else {
                if (items_array[index].equals(key))
                    return index;
            }
            index++;

        }
        throw new NoSuchElementException("item not found");
    }

    @Override
    public boolean contains(E key) {
        try {
            findIndexOf(key);
            return true;
        } catch (NoSuchElementException nse) {
            return false;

        }

    }


    private void assertValidIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= used_counter)
            throw new IndexOutOfBoundsException("index too small or large for" + index
                    + "of" + used_counter + "possible items");

    }

    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= used_counter)
            throw new IndexOutOfBoundsException("index too small or large for" + index
                    + "of" + used_counter + "possible items");
        return items_array[index];
    }

    private void shiftItemsRight(int index) {
        while (index < used_counter - 1) {
            items_array[index] = items_array[index + 1];
            index++;
        }
        used_counter--;
    }

    private boolean tooEmpty() {
        return used_counter * 3 < items_array.length;
    }

    public E remove(int index) throws IndexOutOfBoundsException {
        assertValidIndex(index);
        E result = items_array[index];

        shiftItemsRight(index);

        if (tooEmpty())
            resizeArray(items_array.length / 2);
        return result;

    }

    @Override
    public boolean remove(Object obj) {
        if (obj == null) {

            try {
                int location = findIndexOf(null);
                remove(location);
                return true;
            } catch (NoSuchElementException nse) {
                return false;
            }
        } else {
                for (int index = 0; index < used_counter; index++ )
                    if (obj.equals(items_array[index])){
                        remove(index);
                        return true;
                    }
                return false;
        }
    }
}