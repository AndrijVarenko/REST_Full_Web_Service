package com.example.restservice;

public record Greeting (long id, String content) {

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
