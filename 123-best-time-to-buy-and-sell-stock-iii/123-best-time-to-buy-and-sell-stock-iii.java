class Solution {
    public int maxProfit(int[] prices) {
        int[] selling = new int[prices.length];
        
        int min = prices[0];
        for(int i=0; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            
            if(i - 1 >= 0)
                selling[i] = Math.max(selling[i - 1], prices[i] - min);
            else selling[i] = prices[i] - min;
        }
        
        int[] buying = new int[prices.length];
        
        int max = prices[prices.length - 1];
        for(int i=prices.length-1; i>=0; i--){
            max = Math.max(prices[i], max);
            
            if(i != prices.length - 1)
                buying[i] = Math.max(buying[i+ 1], max - prices[i]);
            
            else buying[i] = max - prices[i];
        }
        
        int ans = 0;
        for(int i=0; i<prices.length; i++){
            ans = Math.max(ans, buying[i] + selling[i]);
        }
        return ans;
    }
}