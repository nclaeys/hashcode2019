package com.google.hashcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final String A = "input/a_example.txt";
    private static final String B = "input/b_lovely_landscapes.txt";
    private static final String C = "input/c_memorable_moments.txt";
    private static final String D = "input/d_pet_pictures.txt";
    private static final String E = "input/e_shiny_selfies.txt";

    public static void main(String[] args) {
        List<Photo> photos = new FileInputReader().parse(A);
        List<Photo> results = calculateAlgorithm(photos);
        System.out.println(results);
    }

    private static List<Photo> calculateAlgorithm(List<Photo> photos) {
        List<Photo> results = new ArrayList<>();
        results.add(photos.get(0));
        photos.remove(photos.get(0));
        int currentEntry = 0;
        while (photos.size() > 0){
            Photo toCheck = results.get(currentEntry);
            Photo bestFound = null;
            int bestValue = 0;
            for(int j = 0; j < photos.size(); j++) {
                Photo current = photos.get(j);
                if(toCheck.getId() != current.getId()) {
                    Integer result = calculateInterest(toCheck, photos.get(j));
                    if(result > bestValue) {
                        bestValue = result;
                        bestFound = current;
                    }
                }
            }
            results.add(bestFound);
            photos.remove(bestFound);
            currentEntry++;
        }
        return results;
    }

    private static Integer calculateInterest(Photo photo1, Photo photo2) {
        List<String> tagsPhoto1 = photo1.getTags();
        List<String> tagsPhoto2 = photo2.getTags();
        List<String> common = tagsPhoto1.stream().filter(tagsPhoto2::contains).collect(Collectors.toList());
        int commonEntries = common.size();
        int notInPhoto2 = (int) tagsPhoto1.stream().filter(elem -> !common.contains(elem)).count();
        int notInPhoto1 = (int) tagsPhoto2.stream().filter(elem -> !common.contains(elem)).count();
        return Math.min(Math.min(commonEntries, notInPhoto1), notInPhoto2);
    }
}
