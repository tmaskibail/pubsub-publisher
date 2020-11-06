package com.tmaskibail.pubsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PubsubPublisherApplication implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(PubsubPublisherApplication.class);
    private static final String PROJECT_ID = "tmaskibail-sandbox";
    private static final String TOPIC_ID = "records";

    public static void main(String[] args) {
        SpringApplication.run(PubsubPublisherApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        PublisherWithAttributes.publish(PROJECT_ID, TOPIC_ID);
    }
}
