package com.pkg.prob10;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Human {
	String name;
	int age;
	String gender;

	public Human(String name) {
		this.name = name;
	}

	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Human(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + ", gender=" + gender
				+ "]";
	}
}

public class ConstructorReference {
	public static void main(String args[]) {
		Human[] list = { new Human("Joe", 35, "Male"),
				new Human("Jane", 45, "Female"), new Human("John", 30, "Male"),
				new Human("Sasha", 35, "Female"),
				new Human("Kaile", 31, "Male"),
				new Human("Sujane", 44, "Female") };

		// Query 1 : Print only male canditates
		System.out.println("Only male candidates............");
		Stream<Human> humanStream = Arrays.stream(list).filter(
				h -> h.getGender().equals("Male"));
		humanStream.forEach(System.out::println);

		// Query 2 : add some more objects to the list, and print the count of
		// female candidates whose age is greater than 30
		System.out
				.println("Female candidates with age greater than 30........");

		Stream<Human> femaleCandidates = Stream.of(list).filter(
				h -> h.getGender() == "Female" && h.getAge() > 30);
		femaleCandidates.forEach(System.out::println);

		// Query 3 : Practice for method reference Classname::new - Cretae an
		// objecy by choosing suitable Interface to the specified
		// constructors(Totally 3 constuctors) and print the object status

		Function<String, Human> oneArg = Human::new;
		Human firstHuman = oneArg.apply("Bimarsh");
		firstHuman.setAge(25);
		firstHuman.setGender("Male");
		System.out.println(firstHuman);

		BiFunction<String, Integer, Human> twoarguments = Human::new;
		Human secondHuman = twoarguments.apply("Roshan", 20);
		secondHuman.setGender("Male");
		System.out.println(secondHuman);

		TriFunctional<String, Integer, String, Human> threeArguments = Human::new;
		Human thirdHuman = threeArguments.apply("Abhinas", 25, "Male");
		System.out.println(thirdHuman);

		// Query 4 : convert your Human array into ArrayList of Human by
		// creating a static method, decide your arguments and return type

		List<Human> col1 = arrayToCollection(list);
		System.out.println("from method" + col1);

	}

	// Implement the body for Query 4

	public static List<Human> arrayToCollection(Human[] arr) {

		List<Human> listofHuman = Arrays.stream(arr).collect(
				Collectors.toList());
		return listofHuman;

	}
}
