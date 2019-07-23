package com.wsmhz.dataStructure.linked;

/**
 * create by tangbj on 2018/10/25
 */
public class LinkedList<E> {

    private class Node{
        private E e;
        private Node next;

        public Node(E e,Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead; //虚拟头节点
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 0 1 2 3
    public void add(int index,E e){
        if(index < 0 || index > getSize()){
            throw new IllegalArgumentException("索引越界");
        }
        Node pre = dummyHead;
        for(int i = 0;i < index; i++){
            pre = pre.next;
        }
//        Node node = new Node(e);
//        node.next = pre.next;
//        pre.next = node;
        pre.next = new Node(e,pre.next);//简化
        size ++;
    }

    public void addFrist(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(getSize(),e);
    }

    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("索引越界");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    public void set(int index,E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("索引越界");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("索引越界");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node retNode = pre.next;
        pre.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size -1);
    }

    public void removeElement(E e){

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur + " >- ");
            cur = cur.next;
        }
        res.append("NUll");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i <= 5; i++) {
            list.addFrist(i);
            System.out.println(list);
        }
        list.set(2,66);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);

    }
}
