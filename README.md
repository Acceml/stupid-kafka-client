#stupid kafka client
A simple wrapper for kafka mq.
Use builder pattern when u try to construct an `Object`
#Required
JDK 1.7 or higher.
#usage
[Official document of kafka producer](http://kafka.apache.org/090/javadoc/index.html?org/apache/kafka/clients/consumer/KafkaConsumer.html)
##official api
###producer
```java
 Properties props = new Properties();
 props.put("bootstrap.servers", "localhost:4242");
 props.put("acks", "all");
 props.put("retries", 0);
 props.put("batch.size", 16384);
 props.put("linger.ms", 1);
 props.put("buffer.memory", 33554432);
 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
 props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

 Producer<String, String> producer = new KafkaProducer<>(props);
 for(int i = 0; i < 100; i++)
     producer.send(new ProducerRecord<String, String>("my-topic", Integer.toString(i), Integer.toString(i)));

 producer.close();
```
###consumer
```java
 Properties props = new Properties();
     props.put("bootstrap.servers", "localhost:9092");
     props.put("group.id", "test");
     props.put("enable.auto.commit", "true");
     props.put("auto.commit.interval.ms", "1000");
     props.put("session.timeout.ms", "30000");
     props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
     props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
     KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
     consumer.subscribe(Arrays.asList("foo", "bar"));
     while (true) {
         ConsumerRecords<String, String> records = consumer.poll(100);
         for (ConsumerRecord<String, String> record : records)
             System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
     }
```

##stupid kafka client api
###producer
```java
   CloudKafkaProducer<String, String> kafkaProducer =
                KafkaProducerBuilder.builder()
                        .withServer("172.31.1.161:9092")
                        .build();
        kafkaProducer.send("test","huming");
```
###consumer
```java
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
```





