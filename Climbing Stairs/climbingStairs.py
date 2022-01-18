class ClimbingStairs:
    
    @staticmethod
    def climbing_stairs(n: int) -> int:
        if n <= 0:
            return 0
        
        if n <= 2: 
            return n
        
        a, b, c = 0, 1, 2
        
        while (n > 2):
            a, b = b, c
            c = a + b
            n = n - 1
        
        return c