package org.tic.archb;

import java.util.Collections;
import java.util.List;

public class Alphabetiser {
    private List<String> sortedTitles;

    Alphabetiser(CircularShift circularShift) {
        sortedTitles = circularShift.getShiftedTitles();
        Collections.sort(sortedTitles);
    }

    public List<String> getSortedTitles() {
        return sortedTitles;
    }

}
