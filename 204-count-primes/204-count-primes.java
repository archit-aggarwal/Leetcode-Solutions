class Solution {
    
    public int countPrimes(int n) {
        // Sieve of Eratosthenes
        boolean[] prime = new boolean[n + 1];
        for(int i=2; i<n; i++) prime[i] = true;
        
        int count = 0;
        for(int i=2; i<n; i++){
            
            if(prime[i] == false){
                // if the number is composite,
                // then all it's multiples will be already false
                continue;
            }
            
            count++; // Because it is a prime no
            
            // Making all the multiples of i as not prime
            for(int j=2*i; j<n; j = j + i){
                prime[j] = false;
            }
        }
        
        return count;
    }
}