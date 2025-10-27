from type_of_triangle.type import TriangleType


def triangle_type(a: int, b: int, c: int) -> TriangleType:
    if a <= 0 or b <= 0 or c <= 0:
        return TriangleType.NONE

    if a + b <= c or a + c <= b or b + c <= a:
        return TriangleType.NONE

    if a == b == c:
        return TriangleType.EQUILATERAL
    elif a == b or b == c or a == c:
        return TriangleType.ISOSCELES

    return TriangleType.SCALENE