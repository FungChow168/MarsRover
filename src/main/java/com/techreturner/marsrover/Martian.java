package com.techreturner.marsrover;

public class Martian {

    public static void main(String[] args) {
        Martian a = new Martian();
        System.out.println(a.getRandomInt(0, 1));
        System.out.println();

    }

    public int getRandomInt(int min, int max) {

        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}


