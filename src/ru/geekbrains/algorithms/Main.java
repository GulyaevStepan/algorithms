package ru.geekbrains.algorithms;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		double time;
		
		LinkedList<ArrObj> objList = new LinkedList<>();
        objList.add(new ArrObj(1, 1));
        objList.add(new ArrObj(2, 2));
        objList.add(new ArrObj(3, 3));

        time = System.nanoTime();
		StackM<ArrObj> objStack = new StackM<>(objList);
        for (int i = 4; i < 8; i++) {
            objStack.push(new ArrObj(i, i));
        }
		System.out.println(objStack.peek());
		while (!objStack.isEmpty()) {
		    System.out.println(objStack.pop());
        }
        System.out.println((System.nanoTime() - time) / 1_000_000_000 + "\n");

		time = System.nanoTime();
        QueueM<ArrObj> objQueue = new QueueM<>(objList);
        for (int i = 1; i < 8; i++) {
            objQueue.insert(new ArrObj(i, i));
        }
        System.out.println(objQueue.peek());
        while (!objQueue.isEmpty()) {
            System.out.println(objQueue.remove());
        }
        System.out.println((System.nanoTime() - time) / 1_000_000_000 + "\n");

        time = System.nanoTime();
        DequeM<ArrObj> objDeque = new DequeM<>(objList);
        for (int i = 1; i < 8; i++) {
            objDeque.addLast(new ArrObj(i, i));
        }
        System.out.println(objDeque.peekLast());
        while (!objDeque.isEmpty()) {
            System.out.println(objDeque.pollLast());
        }
        System.out.println((System.nanoTime() - time) / 1_000_000_000 + "\n");

        time = System.nanoTime();
        PriorityQueue<Integer> priorQueue = new PriorityQueue<>();
        Random rand = new Random();
        for (int i = 1; i < 8; i++) {
            priorQueue.add(rand.nextInt(10));
        }
        System.out.println(priorQueue.peek());
        while (!priorQueue.isEmpty()) {
            System.out.println(priorQueue.poll());
        }
        System.out.println((System.nanoTime() - time) / 1_000_000_000 + "\n");

	}

}

class ArrObj {

	int a;
	int b;

	ArrObj (int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "a: " + a + " b: " + b;
	}
}

class StackM<T> {

    LinkedList<T> stack;

    StackM () {
        stack = new LinkedList<>();
    }

    StackM (LinkedList<T> stack) {
        this.stack = stack;
    }

    void push (T Obj) {
        stack.add(Obj);
    }

    T pop () {
        T result = stack.getLast();
        stack.remove(stack.size() - 1);
        return result;
    }

    T peek () {
        return stack.getLast();
    }

    boolean isEmpty () {
        return stack.size() == 0;
    }

}

class QueueM<T> {

    LinkedList<T> queue;

    QueueM() {
        queue = new LinkedList<>();
    }

    QueueM(LinkedList<T> queue) {
        this.queue = queue;
    }

    void insert(T Obj) {
        queue.add(Obj);
    }

    T remove() {
        T result = queue.getFirst();
        queue.removeFirst();
        return result;
    }

    T peek() {
        return queue.getFirst();
    }

    boolean isEmpty() {
        return queue.size() == 0;
    }
}

class DequeM<T> {

    LinkedList<T> deque;

    DequeM() {
        deque = new LinkedList<>();
    }

    DequeM(LinkedList<T> deque) {
        this.deque = deque;
    }

    void addFirst(T Obj) {
        deque.addFirst(Obj);
    }

    void addLast(T Obj) {
        deque.addLast(Obj);
    }

    T pollFirst() {
        T result = deque.getFirst();
        deque.removeFirst();
        return result;
    }

    T pollLast() {
        T result = deque.getLast();
        deque.removeLast();
        return result;
    }

    T peekFirst() {
        return deque.getFirst();
    }

    T peekLast() {
        return deque.getLast();
    }

    boolean isEmpty() {
        return deque.size() == 0;
    }
}