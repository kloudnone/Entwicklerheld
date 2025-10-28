#include "Fizzbuzz.hpp"

string Fizzbuzz::fizzbuzz(int number){
    string res;
       
    if (number % 15 == 0) {
        res = "fizzbuzz";
    } else if (number % 3 == 0) {
        res = "fizz";
    } else if (number % 5 == 0) {
        res = "buzz";
    } else {
        res = to_string(number);
    }

    return res;
}