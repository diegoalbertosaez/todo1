package com.diego.saez.functional;

import java.util.function.Consumer;

public class LambdaExceptionWrappers {
	
    public static <T> Consumer<T> throwingConsumerWrapper(ThrowingConsumer<T, Exception> throwingConsumer) {
        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }
}
