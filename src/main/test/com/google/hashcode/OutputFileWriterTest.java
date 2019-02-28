package com.google.hashcode;


import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OutputFileWriterTest {

    @Test
    public void givenSlideWithOneId() throws IOException {
        final Slide slide = new Slide(1);

        final OutputFileWriter writer = new OutputFileWriter(Collections.singletonList(slide));
        writer.write();
    }

    @Test
    public void givenSlideWithTwoIds() throws IOException {
        final Slide slide = new Slide(1, 2);

        final OutputFileWriter writer = new OutputFileWriter(Collections.singletonList(slide));
        writer.write();
    }

    @Test
    public void givenMultipleSlides() throws IOException {
        final Slide slideOne = new Slide(1);
        final Slide slideTwo = new Slide(2, 3);
        final Slide slideThree = new Slide(4);
        final Slide slideFour = new Slide(5, 6);

        final List<Slide> slides = Arrays.asList(slideOne, slideTwo, slideThree, slideFour);

        final OutputFileWriter writer = new OutputFileWriter(slides);
        writer.write();
    }
}