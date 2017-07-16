package com.pkg.prob9;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Dish {

	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;

	public Dish(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public int getCalories() {
		return calories;
	}

	public Type getType() {
		return type;
	}

	public enum Type {
		MEAT, FISH, OTHER
	}

	@Override
	public String toString() {
		return name;
	}

	public static final List<Dish> menu = Arrays.asList(new Dish("pork", false,
			800, Dish.Type.MEAT), new Dish("beef", false, 700, Dish.Type.MEAT),
			new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish(
					"french fries", true, 530, Dish.Type.OTHER), new Dish(
					"rice", true, 350, Dish.Type.OTHER), new Dish(
					"season fruit", true, 120, Dish.Type.OTHER), new Dish(
					"pizza", true, 550, Dish.Type.OTHER), new Dish("prawns",
					false, 400, Dish.Type.FISH), new Dish("salmon", false, 450,
					Dish.Type.FISH));

	public static boolean aVegiterianMenu(List<Dish> menu) {
		boolean found = false;
		Optional<Dish> vegDish = menu.stream().filter(x -> x.isVegetarian())
				.findAny();
		found = vegDish.isPresent();
		return found;
	}

	public static boolean bHealthyMenu(List<Dish> menu) {
		boolean found = menu.stream().anyMatch(x -> x.getCalories() < 1000);
		return found;

	}

	public static boolean cUnhealthyMenu(List<Dish> menu) {
		boolean found = menu.stream().anyMatch(x -> x.getCalories() > 1000);
		return found;
	}

	public static Optional<Dish> dTypeMeat(List<Dish> menu) {
		Optional<Dish> anyMeat = menu.stream()
				.filter(x -> x.getType() == Type.MEAT).findFirst();
		return anyMeat;
	}

	public static int eCalculateTotalCalories(List<Dish> menu) {
		long totalCalories = menu.stream().map(x -> x.getCalories())
				.reduce(0, (a, b) -> (a + b));
		return (int) totalCalories;
	}

	public static int fTotalCaloriesMethodReference(List<Dish> menu) {
		long totalCalories = menu.stream().map(Dish::getCalories)
				.reduce(0, (a, b) -> a + b);
		return (int) totalCalories;
	}

	public static void main(String[] args) {
		System.out.println("Vegiterain Menu: "
				+ Dish.aVegiterianMenu(Dish.menu));
		System.out.println("healthy Menu: " + Dish.bHealthyMenu(Dish.menu));

		System.out.println("Unhealthy Menu: " + Dish.cUnhealthyMenu(Dish.menu));

		Optional<Dish> dis = Dish.dTypeMeat(Dish.menu);
		System.out.println("Meat type menu: " + dis.isPresent());
		System.out.println("Total Calories: "
				+ Dish.eCalculateTotalCalories(Dish.menu));
		System.out.println("Total Calories using method refernce: "
				+ Dish.fTotalCaloriesMethodReference(Dish.menu));

	}
}
