export function climbingStairs(n) {
    if (n < 0) {
        return 0;
    }
    
    if (n <= 2) {
        return n;
    }
        
    var a = 0;
    var b = 1;
    var c = 2;
        
    while (n > 2){
        a = b;
        b = c;
        c = a + b;
        n = n - 1;  
    }
    
    return c;
}