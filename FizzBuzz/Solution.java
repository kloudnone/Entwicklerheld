package de.entwicklerheld.fizzbuzz.challenge.stage1;

public class Fizzbuzz {

    static String fizzbuzz(int number) {
        String res;
       
        if (number % 15 == 0) {
            res = "fizzbuzz";
        } else if (number % 3 == 0) {
            res = "fizz";
        } else if (number % 5 == 0) {
            res = "buzz";
        } else {
            res = Integer.toString(number);
        }

        return res;
    }
}