package com.hit.cs.stupidkafka.example;

import com.hit.cs.stupidkafka.KafkaProducerBuilder;
import com.hit.cs.stupidkafka.core.CloudKafkaProducer;

public class ExampleProducer {
    public static void main(String[] args) {
        CloudKafkaProducer<String, String> kafkaProducer =
                KafkaProducerBuilder.builder()
                        .withServer("172.31.1.161:9092")
                        .build();
        kafkaProducer.send("test","huming");
    }
}
