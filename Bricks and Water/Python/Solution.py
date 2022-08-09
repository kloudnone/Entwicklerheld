class BricksAndWaterPython:

    def how_much_water(bricks_array: list) -> int:
        res = 0
        for a in range(len(bricks_array)):
            for b in range(a, len(bricks_array)):
                for c in range(a, b):
                    if (bricks_array[a] > bricks_array[c] and bricks_array[b] > bricks_array[c]):
                        minValue = min(bricks_array[a], bricks_array[b])
                        res +=  minValue - bricks_array[c]
                        bricks_array[c] = minValue 
    
        return res;