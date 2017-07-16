package com.pkg.prob1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stream<String> streamOfString = Stream.of("Bill", "Thomas", "Mary");
		String s = streamOfString.collect(Collectors.joining(","));
		System.out.println(s);

	}

}
