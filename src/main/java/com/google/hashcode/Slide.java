package com.google.hashcode;

public class Slide {

    private final int[] ids;

    public Slide(int id) {
        ids = new int[]{id};
    }

    public Slide(int first, int second) {
        ids = new int[]{first, second};
    }

    @Override
    public String toString() {
        final StringBuilder output = new StringBuilder();
        for (int id : ids) {
            output.append(id).append(" ");
        }

        return output.toString();
    }
}
