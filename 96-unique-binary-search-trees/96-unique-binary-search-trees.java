class Solution {
    public int catalan(int n){
        if(n == 0 || n == 1) return 1;
        
        int ans = 0;
        for(int i=0; i<n; i++){
            ans = ans + catalan(i) * catalan(n - 1 - i);
        }
        return ans;
    }
    public int numTrees(int n) {
        return catalan(n);
    }
}