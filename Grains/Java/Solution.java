package de.entwicklerheld.grainsJava;


import java.math.BigInteger;

public class Grains {
    BigInteger grainsOnSquare(final int square) {
        if (square < 1 || square > 64) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }

        BigInteger result = BigInteger.valueOf(1);

        for (int i = 1; i < square; i++) {
            result = result.multiply(BigInteger.valueOf(2));
        }

        return result;
    }

    BigInteger grainsOnBoard() {
        BigInteger resultPerSquare = BigInteger.valueOf(1);
        BigInteger result = BigInteger.valueOf(1);

        for (int i = 1; i < 64; i++) {
            resultPerSquare = resultPerSquare.multiply(BigInteger.valueOf(2));
            result = result.add(resultPerSquare);
        }

        return result;
    }


}