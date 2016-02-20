package com.jcranky.scalando.cap02.java7;

public class Foto {
    private final Integer id;
    private final String owner;
    private final String title;
    private final Integer farm;

    public Foto(Integer id, String owner, String title, Integer farm) {
        this.id = id;
        this.owner = owner;
        this.title = title;
        this.farm = farm;
    }

    public Integer getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getTitle() {
        return title;
    }

    public Integer getFarm() {
        return farm;
    }
}
