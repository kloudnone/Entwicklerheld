package de.entwicklerheld.scalechallengehard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Scale {
    static List<List<Integer>> getMasses(Integer slowLorisWeight, List<Integer> allMasses) {
        
        List<List<List<Integer>>> possibleWeights = new ArrayList<>();
        
        getPossibleMasses(
            possibleWeights, 
            allMasses, 
            new ArrayList<Integer>(), 
            new ArrayList<Integer>()
        );

        for(List<List<Integer>> currentWeight : possibleWeights) {
            int leftWeight = 0;
            int rightWeight = 0;

            for(Integer i : currentWeight.get(0)) {
                leftWeight = leftWeight + i;
            }
            for(Integer j : currentWeight.get(1)) {
                rightWeight = rightWeight + j;
            }

            if(leftWeight + slowLorisWeight == rightWeight) {
                return currentWeight;
            }
        }
        return possibleWeights.get(0);
    }

    static void getPossibleMasses(
        List<List<List<Integer>>> possible, 
        List<Integer> allMasses, 
        List<Integer> prevLeft, 
        List<Integer> prevRight
    ){
        List<Integer> masses = new ArrayList<>(allMasses);

        for(int i = 0; i < masses.size(); i++) {
            List<List<Integer>> firstTemporaryWeights = new ArrayList<>();
            List<List<Integer>> secondTemporaryWeights = new ArrayList<>();
            List<Integer> leftPlate = new ArrayList<>(prevLeft);
            List<Integer> rightPlate = new ArrayList<>(prevRight);

            leftPlate.add(masses.get(i));
            rightPlate.add(masses.get(i));
            masses.remove(i);

            firstTemporaryWeights.add(prevLeft);
            firstTemporaryWeights.add(rightPlate);
            secondTemporaryWeights.add(prevRight);
            secondTemporaryWeights.add(leftPlate);

            possible.add(firstTemporaryWeights);
            possible.add(secondTemporaryWeights);

            getPossibleMasses(possible, masses, prevLeft, rightPlate);
            getPossibleMasses(possible, masses, leftPlate, prevRight);
            getPossibleMasses(possible, masses, prevLeft, prevRight);
        }
    }
}