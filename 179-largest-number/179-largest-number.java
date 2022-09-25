class Solution {
    
    public String largestNumber(int[] arr) {
        String[] copy = new String[arr.length];
        boolean allZero = true;
        for(int idx = 0; idx < arr.length; idx++) 
        {
            if(arr[idx] != 0) allZero = false;
            copy[idx] = Integer.toString(arr[idx]);
        }
        
        if(allZero == true) return "0";
        
        Arrays.sort(copy, (a, b) -> {
            if((a + b).compareTo(b + a) < 0) return +1;
            return -1;
        });
        
        StringBuilder res = new StringBuilder("");
        for(String val: copy) res.append(val);
        return res.toString();
    }
}