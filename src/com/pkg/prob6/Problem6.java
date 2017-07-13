package com.pkg.prob6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {

	public Set<String> union(List<Set<String>> sets) {

		Set<String> stringSet = sets.stream().flatMap(n -> n.stream())
				.collect(Collectors.toSet());
		return stringSet;

	}

	public static void main(String[] args) {

		List<Set<String>> listofSet = new ArrayList<Set<String>>();
		Set<String> first = new HashSet<String>();
		first.add("A");
		first.add("B");
		Set<String> second = new HashSet<String>();
		first.add("D");
		Set<String> third = new HashSet<String>();
		first.add("1");
		first.add("2");
		first.add("3");

		listofSet.add(first);
		listofSet.add(second);
		listofSet.add(third);

		Problem6 problem = new Problem6();
		Set<String> getter = problem.union(listofSet);
		getter.stream().forEach(System.out::println);

	}

}
