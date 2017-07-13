package com.pkg.prob4;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem4 {

	public static void printSquares(int num) {
		// i have used .boxed to change intstream to Stream<Integer> so that i
		// can use .collect(Collectors.toList)
		IntStream str = IntStream.iterate(1, n -> n + 1).map(n -> n * n);
		str.limit(num).boxed().collect(Collectors.toList())
				.forEach(System.out::println);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Problem4.printSquares(6);

	}

}
