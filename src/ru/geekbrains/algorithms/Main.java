package ru.geekbrains.algorithms;

public class Main {

	private int result;

	public Main () {
		result = 3;
	}

	int getResult () {
		return result;
	}


	public static void main(String[] args) {
	/*
	* Задание 1
	* Пример из жизни: телефонный справочник.
	* Данные хранятся строго по алфавиту (чаще всего),
	* а чтобы найти нужный номер надо воспользовоться известным алгоритмом.
	* */

	/*
	* Задание 2
	* Пример из программирования: хранение информации по игре "крестики-нолики".
	* Это обычная таблица, двумерный массив с крестиками, ноликами или
	* пока не поставленным символом (например пробел, чтобы не был null).
	* А вот алгоритм - это отдельный разговор. Можно, конечно, обойтись перебором,
	* но если игровое поле 100х100, а для победы надо поставить 5 крестиков или
	* ноликов в ряд, то перебор отпадёт.
	* */

    Integer a = 1; // Ссылочный тип данных
	int b = 2; // Примитивный тип данных
	Main c = new Main(); //	Тип данных, содержащий свой класс
	int d = 3;
	System.out.println(a);
	System.out.println(b);
	System.out.println(c.getResult());

	System.out.println(a == d);
	System.out.println(b == d);
	System.out.println(c.getResult() == d);

	System.out.println((double) System.nanoTime() / 1_000_000_000);
	}
}
