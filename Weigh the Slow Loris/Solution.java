package de.entwicklerheld.scalechallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Scale {
    static List<Integer> getMasses(Integer weight, List<Integer> allMasses) {

        List<Integer> neededMasses = new ArrayList<>();
        
        Collections.sort(allMasses, Collections.reverseOrder());

        for(int i = 0; i < allMasses.size(); i++) {
            if(allMasses.get(i) <= weight) {
                neededMasses.add(allMasses.get(i));
                weight = weight - allMasses.get(i);
            }

            if(weight == 0) {
                break;
            }
        }
        return neededMasses;
    }
}