
package com.hit.cs.stupidkafka;

import com.hit.cs.stupidkafka.core.CloudKafkaProducer;

import java.util.Properties;

public class KafkaProducerBuilder {

    private Properties properties;

    private KafkaProducerBuilder(Properties properties) {
        this.properties = properties;
    }

    public static KafkaProducerBuilder builder() {
        return builder(null);
    }

    public static KafkaProducerBuilder builder(Properties props) {
        if (props == null) {
            return new KafkaProducerBuilder(new Properties());
        }
        return new KafkaProducerBuilder(props);
    }

    public KafkaProducerBuilder withServer(final String bootstrapServer) {
        properties.put("bootstrap.servers", bootstrapServer);
        return this;
    }

    public KafkaProducerBuilder withAcks(final String acks) {
        properties.put("acks", acks);
        return this;
    }

    public KafkaProducerBuilder withKeySerializer(final String keySerializer) {
        properties.put("key.serializer",keySerializer);
        return this;
    }

    public KafkaProducerBuilder withValueSerializer
            (final String valueSerializer) {
        properties.put("value.serializer",valueSerializer);
        return this;
    }

    public KafkaProducerBuilder withRetries(final int retries) {
        properties.put("retries",retries);
        return this;
    }

    public KafkaProducerBuilder withBatchSize(final int batchSize) {
        properties.put("batch.size",batchSize);
        return this;
    }

    public KafkaProducerBuilder withLingerMs(final int lingerMs) {
        properties.put("linger.ms",lingerMs);
        return this;
    }

    public KafkaProducerBuilder withBufferMemory(final int bufferMemory) {
        properties.put("buffer.memory",bufferMemory);
        return this;
    }

    public  <K, V> CloudKafkaProducer<K, V> build() {
        if(properties.get("key.serializer")==null) {
            properties.put("key.serializer",
                    "org.apache.kafka.common.serialization.StringSerializer");
        }
        if(properties.get("value.serializer")==null) {
            properties.put("value.serializer",
                    "org.apache.kafka.common.serialization.StringSerializer");
        }
        return new CloudKafkaProducer<>(properties);
    }

}
