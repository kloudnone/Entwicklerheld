public class ClimbingStairs {
    public static int climbingStairs(int n) {
        if (n < 0) {
            return 0;
        }
        
        if (n <= 2) {
            return n;
        } 
            
        int a = 0;
        int b = 1;
        int c = 2;
            
        while (n > 2){
            a = b;
            b = c;
            c = a + b;
            n = n - 1;  
        }
        
        return c;
    }

}