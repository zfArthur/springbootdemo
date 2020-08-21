package com.example.demo.aop;

public class Star implements ShowService {

    private String name;

    public Star(String name) {
        this.name = name;
    }

    @Override
    public void sing(String songName) {
        System.out.println(this.name + " sing a song: " + songName);
    }

    @Override
    public void dance() {
        System.out.println(this.name + "dance");
    }

    public Star() {
    }
}
