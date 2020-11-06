package com.tmaskibail.pubsub.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Record implements Serializable {
    private String deviceId;
    private String osVersion;
    private Integer deviceUptimeInMins;
    private List<Product> products;
    // To test duplicate fields
    private String type;
    private Metadata metadata;
    private Timestamp purchaseTimestamp;
    private Integer stateCode;

    public Integer getStateCode() {
        return stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    public Integer getDeviceUptimeInMins() {
        return deviceUptimeInMins;
    }

    public void setDeviceUptimeInMins(Integer deviceUptimeInMins) {
        this.deviceUptimeInMins = deviceUptimeInMins;
    }

    public Timestamp getPurchaseTimestamp() {
        return purchaseTimestamp;
    }

    public void setPurchaseTimestamp(Timestamp purchaseTimestamp) {
        this.purchaseTimestamp = purchaseTimestamp;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}
