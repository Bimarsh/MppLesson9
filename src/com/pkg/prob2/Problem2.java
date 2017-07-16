package com.pkg.prob2;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2 {

	public static void main(String[] args) {

		Stream<Integer> myIntStream = Stream.of(5, 4, 6, 3, 1, 9);
		// can also be done using optional
		/*
		 * Optional<Integer> max = myIntStream .max(Comparator.comparingInt(i ->
		 * i));
		 */

		IntSummaryStatistics summary = myIntStream.collect(Collectors
				.summarizingInt(i -> i));
		System.out.println("The maximum value: " + summary.getMax());
		System.out.println("The minimum value: " + summary.getMin());

	}

}
