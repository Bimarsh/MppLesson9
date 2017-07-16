package com.pkg.prob3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Problem3 {
	@FunctionalInterface
	interface Custom<T, E, F, L, R> {
		R apply(T t, E e, F f, L l);

	}

	public final static Custom<List<String>, Character, Character, Integer, Stream<String>> custom = (
			t, c, d, len) -> t.stream().filter(x -> x.length() == len)
			.filter(x -> x.contains(Character.toString(c)))
			.filter(x -> !x.contains(Character.toString(d)));

	public Stream<String> matchedStream(List<String> words, char c, char d,
			int len) {
		/*
		 * which counts the number of words in the input list words that have
		 * length equal to len, that contain the character c, and that do not
		 * contain the character d. Create a Good and Better solution, as
		 * described in the slides (see
		 * \\cs5\Public\Courses\CS401-MPP\Renuka\DemoCodeLabSolution
		 * \lesson8\lecture\lambda\filter) – a Good solution creates a lambda
		 * expression each time values are passed into countWords, whereas a
		 * Better solution has parametrized lambda expressions pre-made, and so
		 * a call to countWords simply substitutes values into these
		 * expressions. Try also creating a Best solution in which there is just
		 * one lambda expression.
		 */

		Stream<String> toReturn = words.stream().filter(x -> x.length() == len)
				.filter(x -> x.contains(Character.toString(c)))
				.filter(x -> !x.contains(Character.toString(d)));

		return toReturn;
	}

	public static int countWordsBetter(List<String> words, char c, char d,
			int len) {
		int numberOfwords = (int) custom.apply(words, c, d, len).count();
		return numberOfwords;
	}

	public int countWords(List<String> words, char c, char d, int len) {
		long numberOfWords = matchedStream(words, c, d, len).count();
		return (int) numberOfWords;
	}

	public int countWords1(List<String> words, char c, char d, int len) {
		Predicate<String> firstCharacterChecker = s -> s.contains(Character
				.toString(c));
		Predicate<String> secondCharacterChecker = s -> s.contains(Character
				.toString(c));

		long number = words.stream().filter(firstCharacterChecker)
				.filter(secondCharacterChecker).filter(x -> x.length() == len)
				.count();

		return (int) number;

	}

	public static void main(String[] arg) {

		List<String> strings = Arrays.asList("Ram", "Sha", "Dym");
		Problem3 prob3 = new Problem3();
		System.out.println(prob3.countWords(strings, 'S', 'm', 3));
		System.out.println(prob3.countWords1(strings, 'S', 'm', 3));
	}
}
