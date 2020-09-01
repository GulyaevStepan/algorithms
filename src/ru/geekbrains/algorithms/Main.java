package ru.geekbrains.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {

		double time;
		Integer[] arr = {5, 2, 7, 5, 3, 9, 6, 1, 9, 1};

		time = System.nanoTime();
		ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(arr));
		System.out.println(arrList);
		System.out.println((System.nanoTime() - time) / 1_000_000_000 + "\n");

		time = System.nanoTime();
		arrList.add(10);
		arrList.remove(1);
		System.out.println(arrList.get(0));
		System.out.println(arrList);
		System.out.println((System.nanoTime() - time) / 1_000_000_000 + "\n");

		LinkedList<Integer> copyList = new LinkedList<>(arrList);
		time = System.nanoTime();
		copyList.add(8);
		copyList.remove(1);
		System.out.println(copyList.get(0));
		System.out.println(copyList);
		System.out.println((System.nanoTime() - time) / 1_000_000_000 + "\n");
		ArrayList<ArrObj> objList = new ArrayList<>();
		objList.add(new ArrObj(7, 6));
		objList.add(new ArrObj(1, 5));
		objList.add(new ArrObj(8, 2));
		System.out.println(objList);

		Iterator<Integer> iter = copyList.iterator();
		time = System.nanoTime();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
			iter.remove();
		}
		System.out.println("\n" + (System.nanoTime() - time) / 1_000_000_000 + "\n");

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

