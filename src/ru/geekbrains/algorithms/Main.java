package ru.geekbrains.algorithms;

public class Main {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("Hello");
        list.add(" ");
        list.add("world!");
        System.out.println(list.getKey(0) + list.getKey(1) + list.getKey(2));

    }
}

class Node<T> {
    private T key;
    private Node next;

    Node(T key) { this.key = key; }

    public T getKey() { return key; }
    public void setKey(T key) { this.key = key; }
    public Node getNext() { return next; }
    public void setNext(Node next) { this.next = next; }
}

class LinkedList<T> {
    private Node first;
    private int size;

    LinkedList() {
        size = 0;
    }

    void add(T key) {
        if (first == null) {
            first = new Node(key);
        } else {
            Node temp = first;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(key));
        }
        size++;
    }

    T getKey(int index) {
        if (index < 0 || index > size) {
            return null;
        } else {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            return (T) temp.getKey();
        }
    }
}