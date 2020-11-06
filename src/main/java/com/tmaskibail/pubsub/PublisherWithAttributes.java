package com.tmaskibail.pubsub;

import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import com.tmaskibail.pubsub.util.MessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class PublisherWithAttributes {

    private static final Logger LOG = LoggerFactory.getLogger(PublisherWithAttributes.class);

    public static void publish(String projectId, String topicId)
            throws ExecutionException, InterruptedException, IOException {
        TopicName topicName = TopicName.of(projectId, topicId);

        while (true) {
            publishMessage(topicName);
        }
    }

    private static void publishMessage(TopicName topicName) throws IOException, InterruptedException, ExecutionException {
        Publisher publisher = Publisher.newBuilder(topicName).build();
        try {
            String message = MessageBuilder.getRandomAsJson();
            ByteString data = ByteString.copyFromUtf8(message);
            PubsubMessage pubsubMessage =
                    PubsubMessage.newBuilder()
                            .setData(data)
                            .putAllAttributes(ImmutableMap.of("record_type", "retail", "author", "unknown"))
                            .build();

            // Once published, returns a server-assigned message id (unique within the topic)
            ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
            String messageId = messageIdFuture.get();
            LOG.info("Published message with id {} : {} ", messageId, message);
        } finally {
            if (publisher != null) {
                // When finished with the publisher, shutdown to free up resources.
                publisher.shutdown();
                publisher.awaitTermination(1, TimeUnit.MINUTES);
            }
        }

        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5));
    }
}
