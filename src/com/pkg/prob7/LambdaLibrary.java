package com.pkg.prob7;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaLibrary {

	public final static Function<List<Employee>, String> function = l -> l
			.stream().sorted(Comparator.comparing(Employee::getLastName))
			.filter(x -> x.getSalary() > 100000)
			.filter(x -> x.getLastName().charAt(0) > 'M')
			.map(x -> x.getFirstName() + " " + x.getLastName())
			.collect(Collectors.joining(", "));

	public final static String printEmployee(List<Employee> list) {
		return function.apply(list);
	}

}
