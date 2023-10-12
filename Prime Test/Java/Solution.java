package de.entwicklerheld.primeTestJava;


public class PrimeTestJava {
    public static boolean testPrimeNumber(int number) {
        if (number <= 1) {
            return false
        }

        for (int p = 2; p < number; p++) {
            if (number % p == 0) {
                return false;
            }
        }

        return true;
    }
}