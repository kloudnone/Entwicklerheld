class BricksAndWaterPython:

    def how_much_water(bricks_array: list) -> int:

        result = 0
        bricksCount = len(bricks_array)

        for i in range(1, bricksCount - 1):
            leftBrickHeight = bricks_array[i]

            for j in range(i):
                leftBrickHeight = max(leftBrickHeight, bricks_array[j])

            rightBrickHeight = bricks_array[i]

            for j in range(i + 1, bricksCount):
                rightBrickHeight = max(rightBrickHeight, bricks_array[j])

            result = result + (min(leftBrickHeight, rightBrickHeight) - bricks_array[i])

        return result
