package com.hit.cs.stupidkafka;

import com.hit.cs.stupidkafka.core.CloudKafkaConsumer;

import java.util.Properties;

public class KafkaConsumerBuilder {
    private Properties properties;

    private KafkaConsumerBuilder(Properties props) {
        this.properties = props;
    }

    public static KafkaConsumerBuilder builder(Properties prop) {
        if (prop == null) {
            prop = new Properties();
        }
        return new KafkaConsumerBuilder(prop);
    }

    public static KafkaConsumerBuilder builder() {
        return builder(null);
    }

    public KafkaConsumerBuilder withBootstrapServers
            (final String bootstrapServers) {
        properties.put("bootstrap.servers",bootstrapServers);
        return this;
    }

    public KafkaConsumerBuilder withGroupId(final String groupId) {
        properties.put("group.id",groupId);
        return this;
    }

    public KafkaConsumerBuilder withAutoCommit(final String autoCommito){
        properties.put("enable.auto.commit",autoCommito);
        return this;
    }

    public KafkaConsumerBuilder withCommitIntervalMs(final String intervalMs) {
        properties.put("auto.commit.interval.ms",intervalMs);
        return this;
    }

    public KafkaConsumerBuilder withSessionimeoutMs
            (final String sessionTimeoutMs){
        properties.put("session.timeout.ms",sessionTimeoutMs);
        return this;
    }

    public KafkaConsumerBuilder withKeyDeserializer
            (final String keyDeserializer) {
        properties.put("key.deserializer",keyDeserializer);
        return this;
    }

    public KafkaConsumerBuilder withValueDeserializer
            (final String valueDeserializer) {
        properties.put("value.deserializer",valueDeserializer);
        return this;
    }

    public <K,V> CloudKafkaConsumer<K,V> build() {
        if(properties.get("key.deserializer")==null) {
            properties.put("key.deserializer",
                    "org.apache.kafka.common.serialization.StringDeserializer");
        }
        if(properties.get("value.deserializer")==null) {
            properties.put("value.deserializer",
                    "org.apache.kafka.common.serialization.StringDeserializer");
        }
        return new CloudKafkaConsumer<>(properties);
    }
}
