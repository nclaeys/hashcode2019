package com.google.hashcode;

import org.junit.Test;

import java.util.Collections;

public class SlideTest {

    @Test
    public void SlideWithOneHorizontalPhoto() {
        final Photo photo = new Photo(1, "H", Collections.<String>emptyList());

        Slide slide = new Slide(photo);
    }

    @Test(expected = Slide.HorizontalPhotoException.class)
    public void SlideWithTwoHorizontalPhotos() {
        final Photo photoOne = new Photo(1, "H", Collections.<String>emptyList());
        final Photo photoTwo = new Photo(2, "H", Collections.<String>emptyList());

        new Slide(photoOne, photoTwo);
    }

    @Test
    public void SlideWithTwoVerticalPhotos() {
        final Photo photoOne = new Photo(1, "V", Collections.<String>emptyList());
        final Photo photoTwo = new Photo(2, "V", Collections.<String>emptyList());

        new Slide(photoOne, photoTwo);
    }

    @Test(expected = Slide.HorizontalPhotoException.class)
    public void SlideWithTwoTypesOfPhotos() {
        final Photo photoOne = new Photo(1, "H", Collections.<String>emptyList());
        final Photo photoTwo = new Photo(2, "V", Collections.<String>emptyList());

        new Slide(photoOne, photoTwo);
    }
}