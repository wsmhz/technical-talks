package com.wsmhz.dataStructure.array;

/**
 * create by tangbj on 2018/10/21
 */
public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity){
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public Array(){
        this(10);
    }

    public Array(E[] arr){
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    public void addLast(E e){
        add(size,e);
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("索引应该index >= 0 and index <= size");
        }
        if(size == data.length){
            resize(2 * getCapacity());
        }
        for(int i = size-1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
    }

    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("索引应该index >= 0 and index < size");
        }
        return data[index];
    }

    public E getLast(){
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }

    public void set(int index,E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("索引应该index >= 0 and index < size");
        }
        data[index] = e;
    }


    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("索引应该index >= 0 and index < size");
        }
        E temp = data[index];
        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
        }
        size--;
        data[size] = null;
        if(size == data.length/4 && data.length/2 != 0){
            resize(data.length/2);
        }
        return temp;
    }

    public E removeLast(){
        return remove(size-1);
    }

    public E removeFirst(){
        return remove(0);
    }

    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    };

    public int getCapacity(){
        return data.length;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void swap(int i, int j){
        E e = data[i];
        data[i] = data[j];
        data[j] = e;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array capacity:%d,size:%d\n",data.length,size));
        stringBuilder.append("{");
        for (int i=0; i<size; i++) {
            stringBuilder.append(data[i]);
            if(i != size-1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i<=9; i++){
            array.addLast(i);
        }
        System.out.println(array);
        array.add(1,100);
        System.out.println(array);

        array.remove(0);
        array.remove(0);
        array.remove(0);
        array.remove(0);

        System.out.println(array);
//        array.addFirst(500);
//        System.out.println(array);
//
//        System.out.println(array.remove(0));
//        System.out.println(array);
//
//        System.out.println(array.find(2));
//        System.out.println(array.find(11));
//        System.out.println(array.contains(11));

    }
}
