package com.apigateway.gateway.models;

public class AddUriModel {
    String key;
    String value;

    public AddUriModel() {
    }

    public AddUriModel(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
