package com.google.hashcode;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final String A = "input/a_example.txt";
    private static final String B = "input/b_lovely_landscapes.txt";
    private static final String C = "input/c_memorable_moments.txt";
    private static final String D = "input/d_pet_pictures.txt";
    private static final String E = "input/e_shiny_selfies.txt";

    private static final List<String> inputFiles = Arrays.asList(A, B, C, D, E);

    public static void main(String[] args) throws IOException {
        int counter = 0;

        for (String inputFile : inputFiles) {
            executeForInput(inputFile, "output_" + counter + ".txt");
            counter++;
        }
    }

    private static void executeForInput(final String inputFile, final String outputFile) throws IOException {
        List<Photo> photos = new FileInputReader().parse(inputFile);
        List<Slide> results = new DummyCalculationStrategy().calculateAlgorithm(photos);
        new OutputFileWriter(results).write(outputFile);
        System.out.println(results);
    }


    public static Integer calculateInterest(Photo photo1, Photo photo2) {
        List<String> tagsPhoto1 = photo1.getTags();
        List<String> tagsPhoto2 = photo2.getTags();
        List<String> common = tagsPhoto1.stream().filter(tagsPhoto2::contains).collect(Collectors.toList());
        int commonEntries = common.size();
        int notInPhoto2 = (int) tagsPhoto1.stream().filter(elem -> !common.contains(elem)).count();
        int notInPhoto1 = (int) tagsPhoto2.stream().filter(elem -> !common.contains(elem)).count();
        return Math.min(Math.min(commonEntries, notInPhoto1), notInPhoto2);
    }
}
