package com.hit.cs.stupidkafka.example;

import com.hit.cs.stupidkafka.KafkaConsumerBuilder;
import com.hit.cs.stupidkafka.core.CloudKafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.util.Arrays;

public class ExampleConsumer {
    public static void main(String [] args) {
        CloudKafkaConsumer<String, String> kafkaConsumer =
                KafkaConsumerBuilder.builder()
                        .withBootstrapServers("172.31.1.161:9092")
                        .withGroupId("connector")
                        .withAutoCommit("true")
                        .withCommitIntervalMs("1000")
                        .withSessionimeoutMs("30000")
                        .build();
        kafkaConsumer.subscribe(Arrays.asList("test"));
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(5000);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf(record.value());
        }
    }
}
