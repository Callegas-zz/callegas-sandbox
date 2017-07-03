package com.callegasdev;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Producer {

    private static Logger LOG = LogManager.getLogger(Producer.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "1");
        props.put("retries", 0);
        props.put("batch.size", 2);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        ArrayList<String> messages = new ArrayList<>();

        String topic = "soccer-teams";
        messages.add("Gremio");


        messages.stream()
                .forEach(m -> {
                    try {
                        LOG.info("Preparing to send message: " + m);
                        producer.send(new ProducerRecord<>(topic, m)).get();
                        LOG.info("Sent message: " + m);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                });

        producer.flush();
    }


}