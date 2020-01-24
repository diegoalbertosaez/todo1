package com.diego.saez.functional;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Wrapper exception for lambda expression.
 * 
 * @author diegosaez
 *
 */
public class LambdaExceptionWrappers {
	private static final Logger logger = LoggerFactory.getLogger(LambdaExceptionWrappers.class);

	/**
	 * Lambda wrapper method.
	 * 
	 * @param throwingConsumer
	 * @return {@link Consumer}
	 */
	public static <T> Consumer<T> throwingConsumerWrapper(ThrowingConsumer<T, Exception> throwingConsumer) {
		logger.debug("Init throwingConsumerWrapper");
		return i -> {
			try {
				throwingConsumer.accept(i);
			} catch (Exception ex) {
				logger.error("Error", ex);
				throw new RuntimeException(ex);
			}
		};
	}
}
