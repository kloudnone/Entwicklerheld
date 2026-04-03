def _gregorian_weekday_sunday0(year: int, month: int, day: int) -> int:
    t = (0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4)
    y = year - (1 if month < 3 else 0)
    return (y + y // 4 - y // 100 + y // 400 + t[month - 1] + day) % 7


def count_friday_13(year: int) -> int:
    # scenario 1
    return sum(
        1 for month in range(1, 13) if _gregorian_weekday_sunday0(year, month, 13) == 5
    )


def count_friday_13_range(year1: int, year2: int) -> int:
    # scenario 2
    return sum(count_friday_13(y) for y in range(year1, year2 + 1))
