package com.hit.cs.stupidkafka.exception;

public class KafkaException extends RuntimeException {

    public KafkaException(String message) {
        super(message);
    }

    public KafkaException(String message, Throwable cause) {
        super(message, cause);
    }

    public KafkaException(Throwable cause) {
        super(cause);
    }

    public KafkaException(String message, Throwable cause,
                          boolean enableSuppression,
                          boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
