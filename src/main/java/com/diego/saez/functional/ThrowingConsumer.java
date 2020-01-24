package com.diego.saez.functional;

/**
 * Functional interface for Consumer.
 * 
 * @author diegosaez
 *
 * @param <T>
 * @param <E>
 */
@FunctionalInterface
public interface ThrowingConsumer<T, E extends Exception> {
	/**
	 * 
	 * Performs this operation on the given parameter.
	 *
	 * @param t the input argument T
	 * 
	 * @throws E
	 */
	void accept(T t) throws E;
}
