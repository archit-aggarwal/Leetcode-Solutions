class Solution {
    public List<Integer> getRow(int rows) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        
        for(int n=1; n<=rows; n++){
            List<Integer> curr = new ArrayList<>();
            curr.add(1); // nC0
            
            for(int k=1; k<n; k++){
                // nCk = n-1Ck-1 + n-1Ck
                int nCk = prev.get(k) + prev.get(k - 1);
                curr.add(nCk);
            }
            
            curr.add(1); // nCn
            prev = curr;
        }
        
        return prev;
    }
}