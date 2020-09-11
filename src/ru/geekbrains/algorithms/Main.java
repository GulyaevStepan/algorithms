package ru.geekbrains.algorithms;

import java.util.*;

public class Main {

	public static void main(String[] args) {

        /*
        * Пример рекурсии из жизни.
        * 2 зеркала, стоящих друг напротив друга.
        * Каждое из них будет бесконечно отражать само себя
        * с помощью противоположного зеркала.
        * */

        double time;

        System.out.println(recursion3(1));

        time = System.nanoTime();
        System.out.println(recursion2(30));
        System.out.println((System.nanoTime() - time) / 1_000_000_000 + "\n");
        System.out.println(function2(30));
        System.out.println((System.nanoTime() - time) / 1_000_000_000 + "\n");



	}

	static int recursion1() {
	    return recursion1();
    }

    static int recursion2(int n) {
        if (n == 0) {
            return 1;
        }
	    return n*recursion2(n-1);
    }

    static int function2(int n) {
        int result = 1;
	    for (int i = 2; i <= n; i++) {
            result *= i;
        }
	    return result;
    }

    static int recursion3(int n) {
        System.out.println("Вызов recursion3(" + n + ")");
	    ++n;
        if (n > 10) {
            return 1;
        }
        return recursion3(n);
    }

    static int recursion4 (int[] arr, int low, int higt, int key) {
	    int mid = (low + higt)/2;
	    if (arr[mid] == key) {
	        return mid;
        }
	    else if (arr[mid]<key) {
	        return recursion4(arr, low + 1, higt, key);
	    }
	    else {
            return recursion4(arr, low, higt - 1, key);
        }
    }

}

