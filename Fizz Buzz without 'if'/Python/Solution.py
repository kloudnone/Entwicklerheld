def fizzbuzz(number: int):
    for i in range(1, number + 1):
        res = "fizz" * (i % 3 == 0) + (i % 5 == 0) * "buzz" or number
    
    return res
