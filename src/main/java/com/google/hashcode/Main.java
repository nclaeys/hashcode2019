package com.google.hashcode;

import java.util.List;

public class Main {

    public static void main(String[] args ){
        List<Photo> photos = new FileInputReader().parse("input/a_example.txt");
        System.out.println(photos);
    }
}
