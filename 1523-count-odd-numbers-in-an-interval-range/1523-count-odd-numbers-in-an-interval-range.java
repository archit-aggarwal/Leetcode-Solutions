class Solution {
    public int countOdds(int low, int high) {
        int total = (high - low + 1);
        if(total % 2 == 1 && low % 2 == 1) 
            return total / 2 + 1;
        return total / 2;
    }
}