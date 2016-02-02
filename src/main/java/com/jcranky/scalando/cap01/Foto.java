package com.jcranky.scalando.cap01;

public class Foto {
    private final String id;
    private final String owner;

    public Foto(String id, String owner) {
        this.id = id;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }
}
