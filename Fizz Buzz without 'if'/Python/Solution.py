def fizzbuzz(number: int):
    for i in range(1, number + 1):
        text = "fizz" * (i % 3 < 1) + (i % 5 < 1) * "buzz" or number
    return text
