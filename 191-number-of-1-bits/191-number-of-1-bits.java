public class Solution {
    public int hammingWeight(int num) {
        int count = 0;
        
        while(num != 0)
        {
            count++;
            num = num & (num-1);
        }
        return count;
    }
}