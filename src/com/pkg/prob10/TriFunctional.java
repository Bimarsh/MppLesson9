package com.pkg.prob10;

@FunctionalInterface
public interface TriFunctional<T, S, U, R> {

	R apply(T t, S s, U u);
}
