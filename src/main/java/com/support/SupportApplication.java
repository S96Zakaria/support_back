package com.support;

import com.support.services.Consumer;
import com.support.services.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SupportApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SupportApplication.class, args);
        Producer producer = new Producer();

        Consumer consumer = new Consumer();

        producer.myProducer();

        consumer.myConsumer();

    }

}
