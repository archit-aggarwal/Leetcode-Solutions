class Solution {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        
        int count = 0;
        for(int i=2; i<n; i++){
            if(prime[i] == false) continue;
            
            count++; // i is a prime number
            for(long j= 1l * i * i; j < n; j = j + i){
                prime[(int)j] = false; // mark multiples of i as non-prime
            }
        }
        
        return count;
    }
}