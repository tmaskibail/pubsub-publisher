package com.tmaskibail.pubsub.model;

import java.io.Serializable;

public class Metadata implements Serializable {
    private String locale;
    private int cpuMax;
    private int memoryMax;

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public int getCpuMax() {
        return cpuMax;
    }

    public void setCpuMax(int cpuMax) {
        this.cpuMax = cpuMax;
    }

    public int getMemoryMax() {
        return memoryMax;
    }

    public void setMemoryMax(int memoryMax) {
        this.memoryMax = memoryMax;
    }
}
