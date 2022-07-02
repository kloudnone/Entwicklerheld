package de.entwicklerheld.anagram;

import java.util.Arrays;

public class Anagram {
  public static boolean isAnagram(String firstWord, String secondWord) {
    char firstWordLetters[] = firstWord.toLowerCase().toCharArray();
    char secondWordLetters[] = secondWord.toLowerCase().toCharArray();

    if(firstWord.length() != secondWord.length()) {
      return false;
    } else {
      Arrays.sort(firstWordLetters);
      Arrays.sort(secondWordLetters);

      return Arrays.equals(firstWordLetters, secondWordLetters);
    }
  }
}
