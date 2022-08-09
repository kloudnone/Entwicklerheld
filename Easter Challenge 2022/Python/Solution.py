import datetime
from typing import List


class EasterChallenge2022Python:

    @staticmethod
    def calculate_easter_sunday(year: int) -> datetime.datetime:
        a = year % 19
        b = int(year / 100)
        c = int(b - (b /4) - int((8 * b + 13) / 25) + 19 * a + 15) % 30
        d =  int(c - int(c / 28) * (1 - int(c / 28) * int(29 / (c + 1)) * (int(21 - a) / 11)))
        e = (year + int(year / 4)+ d + 2 - b + int(b / 4)) % 7
        f = d - e
        month = 3 + int((f + 40) / 44)
        day = int(f + 28 - 31 * int(month / 4))

        dateTime = datetime.datetime(year, month, day)
        return dateTime

    @staticmethod
    def calculate_easter_days(year: int) -> List[datetime.datetime]:
        
        easterSunday = EasterChallenge2022Python.calculate_easter_sunday(year)

        easterFriday = easterSunday - datetime.timedelta(days=2)
        easterMonday = easterSunday + datetime.timedelta(days=1)

        return [
            easterFriday,
            easterSunday,
            easterMonday
        ]