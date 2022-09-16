class RLEIterator {
    int[] arr;
    int idx = 0;
    public RLEIterator(int[] arr) { 
        this.arr = arr; 
        this.idx = 0;
    }
    
    public int next(int n) {
        int last = -1;
        while(n > 0 && idx < arr.length){
            last = arr[idx + 1];
            if(n >= arr[idx]){
                n = n - arr[idx];
                idx = idx + 2;
            } else {
                arr[idx] = arr[idx] - n;
                n = 0;
            }
        }
        
        return (n > 0) ? -1 : last;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */