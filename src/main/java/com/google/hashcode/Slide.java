package com.google.hashcode;

public class Slide {

    private final int[] ids;

    public Slide(final Photo photo) {
        ids = new int[]{photo.getId()};
    }

    public Slide(final Photo first, final Photo second) {
        if (first.isHorizontal() || second.isHorizontal()){
            throw new HorizontalPhotoException();
        }
        ids = new int[]{first.getId(), second.getId()};
    }

    @Override
    public String toString() {
        final StringBuilder output = new StringBuilder();
        for (int id : ids) {
            output.append(id).append(" ");
        }

        return output.toString();
    }

    public class HorizontalPhotoException extends RuntimeException {
    }
}
