package com.google.hashcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.hashcode.Main.calculateInterest;

public class DummyCalculationStrategy {
    public List<Slide> calculateAlgorithm(List<Photo> inputPhotos) {
        List<Photo> photos = inputPhotos.stream()
                .filter(Photo::isHorizontal)
                .collect(Collectors.toList());
        List<Photo> results = new ArrayList<>();
        results.add(photos.get(0));
        photos.remove(photos.get(0));
        int currentEntry = 0;
        while (photos.size() > 0) {
            Photo toCheck = results.get(currentEntry);
            Photo bestFound = null;
            int bestValue = 0;
            for (int j = 0; j < photos.size(); j++) {
                Photo current = photos.get(j);
                if (toCheck.getId() != current.getId()) {
                    Integer result = calculateInterest(toCheck, photos.get(j));
                    if (result > bestValue) {
                        bestValue = result;
                        bestFound = current;
                    }
                }
            }
            results.add(bestFound);
            photos.remove(bestFound);
            currentEntry++;
        }
        return results.stream()
                .map(Slide::new)
                .collect(Collectors.toList());
    }
}
