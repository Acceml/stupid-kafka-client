package com.hit.cs.stupidkafka.core;

import com.hit.cs.stupidkafka.exception.KafkaException;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;
import java.util.Properties;

public class CloudKafkaProducer<K, V> extends KafkaProducer<K, V> {

    private String topic;

    public CloudKafkaProducer(Properties properties) {
        super(properties);
        this.topic = properties.getProperty("topic");
    }

    public CloudKafkaProducer(Properties properties,
                              Serializer<K> keySerializer,
                              Serializer<V> valueSerializer) {
        super(properties, keySerializer, valueSerializer);
    }

    public CloudKafkaProducer(Map<String, Object> configs) {
        super(configs);
    }

    public CloudKafkaProducer(Map<String, Object> configs,
                              Serializer<K> keySerializer,
                              Serializer<V> valueSerializer) {
        super(configs, keySerializer, valueSerializer);
    }

    public void send(V value) {
            send(topic, value);
    }

    public void send(String topicName, V value) {
        send(topicName, null, value);
    }

    public void send(String topicName, K key, V value) {
        send(topicName, null, key, value);
    }

    public void send(String topicName, Integer partition, K key, V value) {
        try {
            super.send(new ProducerRecord<>(topicName, partition, key, value));
        } catch (RuntimeException e) {
            throw new KafkaException("send msg exception: " + e);
        }
    }

}
