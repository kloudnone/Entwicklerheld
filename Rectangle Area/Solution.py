from typing import Tuple, Optional

def intersection_rectangle(
        a: Tuple[int, int, int, int],
        b: Tuple[int, int, int, int]
) -> Optional[Tuple[int, int, int, int]]:
    x1, y1, x2, y2 = a
    x3, y3, x4, y4 = b

    if not (x1 < x4 and x2 > x3 and y1 < y4 and y2 > y3):
        return None

    ix1 = max(x1, x3)
    iy1 = max(y1, y3)
    ix2 = min(x2, x4)
    iy2 = min(y2, y4)

    if ix1 < ix2 and iy1 < iy2:
        return (ix1, iy1, ix2, iy2)
    else:
        return None


def intersection_area(
        a: Tuple[int, int, int, int],
        b: Tuple[int, int, int, int]
) -> int:
    intersection = intersection_rectangle(a, b)
    if intersection is None:
        return 0
    
    ix1, iy1, ix2, iy2 = intersection
    width = ix2 - ix1
    height = iy2 - iy1

    return width * height
