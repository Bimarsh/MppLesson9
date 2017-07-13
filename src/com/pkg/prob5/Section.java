package com.pkg.prob5;

import java.util.Arrays;
import java.util.stream.Stream;

public class Section {
	public static Stream<String> streamSection(Stream<String> stream, int m,
			int n) {
		// Implement the code
		Stream<String> newStream = stream.skip(m).limit(n + 1 - m);
		newStream.forEach(System.out::println);

		return null;
	}

	public static void main(String[] args) {
		// Make three calls for the streamSection() method with different inputs
		// use nextStream() method to supply the Stream input as a first
		// argument in streamSection() method
		System.out.println("Stream from 0 to 4 position inclusive");
		Section.streamSection(nextStream(), 0, 4);
		System.out.println("Stream from 4 to 5 position inclusive");
		Section.streamSection(nextStream(), 4, 5);
		System.out.println("Stream from 0 to 7 position inclusive");
		Section.streamSection(nextStream(), 0, 7);

	}

	// support method for the main method -- for testing
	private static Stream<String> nextStream() {
		return Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg",
				"hhh", "iii").stream();
	}
}
