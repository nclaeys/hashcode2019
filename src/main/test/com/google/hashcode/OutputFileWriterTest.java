package com.google.hashcode;


import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OutputFileWriterTest {

    @Test
    public void givenSlideWithOneId() throws IOException {
        final Photo photo = new Photo(1, "H", Collections.<String>emptyList());
        final Slide slide = new Slide(photo);

        final OutputFileWriter writer = new OutputFileWriter(Collections.singletonList(slide));
        writer.write("output.txt");
    }

    @Test
    public void givenSlideWithTwoIds() throws IOException {
        final Photo photo = new Photo(1, "H", Collections.<String>emptyList());
        final Photo photo2 = new Photo(2, "H", Collections.<String>emptyList());
        final Slide slide = new Slide(photo, photo2);

        final OutputFileWriter writer = new OutputFileWriter(Collections.singletonList(slide));
        writer.write("output.txt");
    }

    @Test
    public void givenMultipleSlides() throws IOException {
        final Photo photo = new Photo(1, "H", Collections.<String>emptyList());
        final Photo photo2 = new Photo(2, "V", Collections.<String>emptyList());
        final Photo photo3 = new Photo(3, "V", Collections.<String>emptyList());
        final Photo photo4 = new Photo(4, "V", Collections.<String>emptyList());
        final Photo photo5 = new Photo(5, "V", Collections.<String>emptyList());
        final Photo photo6 = new Photo(6, "V", Collections.<String>emptyList());

        final Slide slideOne = new Slide(photo);
        final Slide slideTwo = new Slide(photo2, photo3);
        final Slide slideThree = new Slide(photo4);
        final Slide slideFour = new Slide(photo5, photo6);

        final List<Slide> slides = Arrays.asList(slideOne, slideTwo, slideThree, slideFour);

        final OutputFileWriter writer = new OutputFileWriter(slides);
        writer.write("output.txt");
    }
}