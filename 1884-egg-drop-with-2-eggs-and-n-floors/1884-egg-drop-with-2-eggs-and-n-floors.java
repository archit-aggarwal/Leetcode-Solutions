class Solution {
    public int twoEggDrop(int n) {
        // Equation: x^2 + x = 2 * n
        // => x = (-1 + root(1 + 8 * n)) / 2.0;
    
        double ans = (-1.0 + Math.sqrt(1.0 + 8.0 * n)) / 2.0;
        if(ans == (int)ans) return (int)ans;
        return (int)ans + 1;
    }
}