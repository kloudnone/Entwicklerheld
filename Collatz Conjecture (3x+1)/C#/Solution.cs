using System;
using System.Collections.Generic;
using System.Linq;

namespace CollatzChallengeImplementation
{
    public static class CollatzConjecture
    {
        static int count = 1;

        public static int CountStepsToOne(int number)
        {
            int count = 0;

            if (number <= 0) {
                throw new ArgumentOutOfRangeException();
            }

            while (number != 1) {
                if (number % 2 == 0) {
                    number = number / 2;
                } else {
                    number = (3 * number) + 1;
                }
                count++;
            }
            
            return count;
        }
    }
}