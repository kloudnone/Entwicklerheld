import unittest
import xmlrunner


def fizzbuzz(number: int):
    if number % 15 == 0:
        res = "fizzbuzz"
    elif number % 3 == 0:
        res = "fizz"
    elif number % 5 == 0:
        res = "buzz"
    else:
        res = number

    return res;