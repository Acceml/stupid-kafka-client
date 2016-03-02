#stupid kafka client
A simple wrapper for kafka mq.
Use builder pattern when u try to construct a `Object`
#Required
JDK 1.7 or higher.
#usage
[Official document of kafka producer](http://kafka.apache.org/090/javadoc/index.html?org/apache/kafka/clients/consumer/KafkaConsumer.html)
```java
   CloudKafkaProducer<String, String> kafkaProducer =
                KafkaProducerBuilder.builder()
                        .withServer("172.31.1.161:9092")
                        .build();
        kafkaProducer.send("test","huming");
```



