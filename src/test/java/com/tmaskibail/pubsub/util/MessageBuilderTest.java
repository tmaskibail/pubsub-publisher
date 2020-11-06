package com.tmaskibail.pubsub.util;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * dummy tests
 */
class MessageBuilderTest {
    private static final Logger LOG = LoggerFactory.getLogger(MessageBuilderTest.class);

    @Test
    void getRandom() {
    }

    @Test
    void getRandomAsJson() {
        String message = MessageBuilder.getRandomAsJson();
        LOG.info(message);
        assertNotNull(message);
    }
}