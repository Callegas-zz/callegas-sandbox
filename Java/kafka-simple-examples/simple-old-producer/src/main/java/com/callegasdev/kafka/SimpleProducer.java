package com.callegasdev.kafka;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

public class SimpleProducer {
    private static Producer<Integer, String> producer;
    private final Properties properties = new Properties();

    public SimpleProducer() {
        properties.put("metadata.broker.list", "localhost:9092");
        properties.put("serializer.class", "kafka.serializer.StringEncoder");
        properties.put("request.required.acks", "1");
        producer = new Producer<>(new ProducerConfig(properties));
    }

    public static void main(String[] args) {
        new SimpleProducer();
        String topic = "series";
        String msg = "The 100";
        KeyedMessage<Integer, String> data = new KeyedMessage<>(topic, msg);
        try {
            producer.send(data);
            producer.close();
            System.out.println("Message sent successfully");
        }catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
}