package ru.geekbrains.algorithms;

import java.util.*;

public class Main {

	public static void main(String[] args) {

        /*
        * Пример древовидной структуры из жизни.
        * Родословная.
        * Любое генеологическое древо имеет
        * древовидную структуру, даже название такоеже - древо.
        * */

        double time;
        Tree tree = new Tree();
        tree.insert(new Person(2, "Bill", 20));
        tree.insert(new Person(4, "Bob", 31));
        tree.insert(new Person(7, "Steev", 19));
        tree.insert(new Person(1, "Mike", 55));
        tree.insert(new Person(5, "Anna", 29));
        tree.insert(new Person(6, "Julia", 42));
        tree.find(1).display();
        time = System.nanoTime();
        tree.displayTree();
        System.out.println((System.nanoTime() - time) / 1_000_000_000 + "\n");

        time = System.nanoTime();
        int[] arr = {4, 3, 8, 6, 9, 0, 3, 1, 2, 7, 7};
        HeapSort heap = new HeapSort();
        heap.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println((System.nanoTime() - time) / 1_000_000_000 + "\n");


    }


}

class Person {

    private String name;
    private int age;
    private int id;

    public Person (int id, String name, int age) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString() {
        return "id: " + id +  ", name: " + name + ", age: " + age;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

class Node {

    private Person person;
    private Node left;
    private Node right;

    public void display() {
        System.out.println(person.toString());
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

class Tree {

    private Node root;

    public void insert(Person person) {
        Node node = new Node();
        node.setPerson(person);
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (person.getId() < current.getPerson().getId()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(node);
                        return;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(node);
                        return;
                    }
                }

            }
        }
    }

    public Node find(int key) {
        Node current = root;
        while (current.getPerson().getId() != key) {
            if (key < current.getPerson().getId()) {
                current = current.getLeft();
            } else {
                current =current.getRight();
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    private void preOrder(Node rootNode) {
        if (rootNode != null) {
            rootNode.display();
            preOrder(rootNode.getLeft());
            preOrder(rootNode.getRight());
        }
    }

    private void postOrder(Node rootNode) {
        if (rootNode != null) {
            postOrder(rootNode.getLeft());
            postOrder(rootNode.getRight());
            rootNode.display();
        }
    }

    private void inOrder(Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.getLeft());
            rootNode.display();
            inOrder(rootNode.getRight());
        }
    }

    public Node min() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.getLeft();
        }
        return last;
    }

    public Node max() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.getRight();
        }
        return last;
    }

    public boolean delete(int id) {
        Node current = root;
        Node parent = root;

        boolean isLeft = true;

        while (current.getPerson().getId() != id) {
            parent = current;
            if (id < current.getPerson().getId()) {
                isLeft = true;
                current = current.getLeft();
            } else {
                isLeft = false;
                current = current.getRight();
            }
            if (current == null) {
                return false;
            }
        }

        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root) {
                root = null;
            } else if (isLeft) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        } else if (current.getRight() == null) {
            if (current == null) {
                root = current.getLeft();
            } else if (isLeft) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        } else if (current.getLeft() == null) {
            if (current == null) {
                root = current.getRight();
            } else if (isLeft) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeft) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
            successor.setLeft(current.getLeft());
        }
        return true;
    }

    public Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.getRight();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }
        if (successor != node.getRight()) {
            successorParent.setLeft(successor.getRight());
            successor.setRight(node.getRight());
        }

        return successor;
    }

    public void displayTree() {
        Node current = root;
        System.out.println("Симметричный");
        inOrder(current);
        System.out.println("Прямой");
        preOrder(current);
        System.out.println("Обратный");
        postOrder(current);
    }
}

class HeapSort {

    private static int heapSize;

    public static void sort(int[] a) {
        buildHeap(a);
        while (heapSize > 1) {
            swap(a, 0, heapSize - 1);
            heapSize--;
            heapify(a, 0);
        }
    }

    private static void buildHeap(int[] a) {
        heapSize = a.length;
        for (int i = a.length / 2; i >= 0; i--) {
            heapify(a, i);
        }
    }

    private static void heapify(int[] a, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < heapSize && a[i] < a[l]) {
            largest = l;
        }
        if (r < heapSize && a[largest] < a[r]) {
            largest = r;
        }
        if (i != largest) {
            swap(a, i, largest);
            heapify(a, largest);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int right(int i) {
        return 2 * i + 2;
    }
}

