# Leap

## Summary
Leap year, or no leap year, that is the question.

Determine whether a given year is a leap year according to the rules of the Gregorian calendar.

- The Gregorian calendar was introduced by Pope Gregory XIII in 1582 to correct the Julian calendar’s inaccuracies.
- Without leap years, our calendar would drift by about 6 hours every year, adding up to a full day every 4 years.
- The year 0 is mathematically a leap year but historically questionable – it doesn't exist in the Gregorian calendar!
- Some countries, like Sweden, had an awkward "double leap year" in 1712, adding a February 30th!

## Scenario 1: Leap year, or no leap year
The rules are deceptively simple:

1. A year is a leap year if it is divisible by 4, but...
2. It is not a leap year if it is divisible by 100, unless...
3. It is also divisible by 400, in which case it is a leap year.

For example:

- 1997: Not a leap year (not divisible by 4).
- 1996: Leap year (divisible by 4, but not by 100).
- 1900: Not a leap year (divisible by 100, but not by 400).
- 2000: Leap year (divisible by 400).

**Special Considerations**

Here are some edge cases to ponder as you design your solution:

- What about year 0? Mathematically, it’s divisible by 400.
- What about negative years be supported? The Gregorian calendar doesn't officially recognize them, but your function might encounter them in testing!
- Does your solution handle years far in the future or past, where data types like int might struggle with overflow?