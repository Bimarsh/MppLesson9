package com.pkg.prob7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(
				new Employee("Joe", "Davis", 120000), new Employee("John",
						"Sims", 110000),
				new Employee("Joe", "Stevens", 200000), new Employee("Andrew",
						"Reardon", 80000), new Employee("Joe", "Cummings",
						760000), new Employee("Steven", "Walters", 135000),
				new Employee("Thomas", "Blake", 111000), new Employee("Alice",
						"Richards", 101000), new Employee("Donald", "Trump",
						100000));

		// your stream pipeline here
		String print = list.stream()
				.sorted(Comparator.comparing(Employee::getLastName))
				.filter(x -> x.getSalary() > 100000)
				.filter(x -> x.getLastName().charAt(0) > 'M')
				.map(x -> x.getFirstName() + " " + x.getLastName())
				.collect(Collectors.joining(", "));
		System.out.println(print);

		System.out.println("Using lambda Library:  "
				+ LambdaLibrary.printEmployee(list));

	}
}
