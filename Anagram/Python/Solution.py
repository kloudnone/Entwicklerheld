def is_anagram(firstWord: str, secondWord: str) -> bool:
    firstWord = sorted([c for c in firstWord.lower() if c.isalpha()])
    secondWord = sorted([c for c in secondWord.lower() if c.isalpha()])
    return firstWord == secondWord
