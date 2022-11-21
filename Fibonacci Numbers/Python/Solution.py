class FibonacciPython:

    @staticmethod
    def fibonacci(number: int) -> int:
        a, b = 0, 1
        for i in range(number-1):
            a, b = b, a+b
        return a