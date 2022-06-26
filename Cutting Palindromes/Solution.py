class CuttingPalindromesPython:

    def is_palindrome(self, string):
        return string == string[::-1]

    def minimum_palindrome_cuts(self, palindrome_string) -> int:

        if self.is_palindrome(palindrome_string):
            return 0

        result = [i - 1 for i in range(1 + len(palindrome_string))]

        for i in range(1 + len(palindrome_string)):
            for j in range(i):
                if palindrome_string[j:i] == palindrome_string[j:i][::-1]:
                    result[i] = min(result[i], 1 + result[j])

        return result[-1]
