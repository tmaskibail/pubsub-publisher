package com.tmaskibail.pubsub.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tmaskibail.pubsub.model.Metadata;
import com.tmaskibail.pubsub.model.Product;
import com.tmaskibail.pubsub.model.Record;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MessageBuilder {
    private static final List<String> PRODUCT_CATEGORIES = Arrays.asList("Coats", "Jackets", "Blazer", "Leather", "Jeans", "Shorts", "Suits", "Pyjamas");
    private static final List<String> CLOTH_SIZE = Arrays.asList("XS", "S", "M", "L", "XL", "XXL");

    /**
     * Generate record with random elements and size to support tests
     *
     * @return dummy record
     */
    public static Record getRandom() {
        Metadata metadata = new Metadata();
        metadata.setCpuMax(ThreadLocalRandom.current().nextInt(6));
        metadata.setMemoryMax(ThreadLocalRandom.current().nextInt(8));
        metadata.setLocale("GB");

        List<Product> products = new ArrayList<>();
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(4); i++) {
            Product product = new Product();
            product.setProductCategory(PRODUCT_CATEGORIES.get(ThreadLocalRandom.current().nextInt(PRODUCT_CATEGORIES.size())));
            product.setProductId(String.valueOf(ThreadLocalRandom.current().nextLong(20)));
            product.setSize(CLOTH_SIZE.get(ThreadLocalRandom.current().nextInt(CLOTH_SIZE.size())));
            product.setType("CLOTH");
            products.add(product);
        }

        Record record = new Record();
        record.setDeviceId(String.valueOf(ThreadLocalRandom.current().nextLong(1000)));

        // set nulls randomly
        double chance = Math.random();
        if(chance < 0.2) {
            record.setDeviceUptimeInMins(0);
        }
        record.setOsVersion("v" + ThreadLocalRandom.current().nextInt(14));
        record.setType("MOBILE");
        record.setMetadata(metadata);
        record.setPurchaseTimestamp(new Timestamp(System.currentTimeMillis()));
        record.setStateCode(ThreadLocalRandom.current().nextInt(60));
        record.setProducts(products);
        return record;
    }

    public static String getRandomAsJson() {
//        Gson gson = new Gson();
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.toJson(getRandom());
    }
}
