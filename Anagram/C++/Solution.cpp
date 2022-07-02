#include "Anagram.hpp"

bool Anagram::isAnagram(string firstWord, string secondWord) {
    if(firstWord.length() != secondWord.length()) {
        return false;
    }

    if(firstWord.empty() && secondWord.empty()) {
        return true;
    }

    int n = firstWord.length();
    int counts[26] = {0};

    for(int i = 0; i < n; i++) {
        counts[firstWord[i] - 'a']++;
        counts[secondWord[i] - 'a']--;
    }

    for(int i = 0; i < 26; i++) {
        if(counts[i]) {
            return false;
        }
    }

    return true;
}
