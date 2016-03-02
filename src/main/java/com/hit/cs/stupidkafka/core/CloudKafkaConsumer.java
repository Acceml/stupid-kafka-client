package com.hit.cs.stupidkafka.core;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;
import java.util.Properties;

public class CloudKafkaConsumer<K,V> extends KafkaConsumer<K,V> {

    public CloudKafkaConsumer(Map<String, Object> configs) {
        super(configs);
    }

    public CloudKafkaConsumer(Map<String, Object> configs,
                              Deserializer<K> keyDeserializer,
                              Deserializer<V> valueDeserializer) {
        super(configs, keyDeserializer, valueDeserializer);
    }

    public CloudKafkaConsumer(Properties properties) {
        super(properties);
    }

    public CloudKafkaConsumer(Properties properties,
                              Deserializer<K> keyDeserializer,
                              Deserializer<V> valueDeserializer) {
        super(properties, keyDeserializer, valueDeserializer);
    }

}
