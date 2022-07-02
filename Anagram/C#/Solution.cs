using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualBasic;

namespace AnagramImplementation
{
    public static class Anagram
    {
        public static Boolean IsAnagram(String firstWord, String secondWord)
        {
            if(firstWord.Length != secondWord.Length) {
                return false;
            }

            var firstWordArray = firstWord.ToLower().ToCharArray();
            var secondWordArray = secondWord.ToLower().ToCharArray();

            Array.Sort(firstWordArray);
            Array.Sort(secondWordArray);

            firstWord = new String(firstWordArray);
            secondWord = new String(secondWordArray);

            return firstWord == secondWord;
        }
    }
}
