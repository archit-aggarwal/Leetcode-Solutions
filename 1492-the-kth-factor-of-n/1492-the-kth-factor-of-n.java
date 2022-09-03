class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        
        for(int i=1; i*i<=n; i++){
            if(n % i == 0){
                first.add(i);
                if(i != n/i)
                    second.add(n / i);
            }
        }
        
        Collections.reverse(second);
        List<Integer> factors = new ArrayList<>(first);
        factors.addAll(second);
        
        if(k > factors.size()) 
            return -1;
        return factors.get(k - 1);
    }
}