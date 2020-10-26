package com.example.demo.agency;

/**
 * @Author zhangfu
 * @Date 2020-10-19 14:55
 */
public class Star implements ShowService {
    private String name;

    @Override
    public void sing(String songName) {
        System.out.println(this.name + " sing a song: " + songName);
    }

    @Override
    public void dance() {
        System.out.println(this.name + "dance");
    }
    public void paly() {
        System.out.println(this.name + "paly");
    }
    public Star(){}

    public Star(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Star star = new Star("Eminem");
        star.sing("Mockingbird");
    }

    public void setName(String name) {
        this.name = name;
    }
}
