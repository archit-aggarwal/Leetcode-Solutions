class Solution {
    public int maxProfit(int[] prices) {
         if(prices.length <= 1) return 0;
        
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        
        buy[0] = -prices[0];
        sell[0] = 0;
        buy[1] = Math.max(-prices[0], -prices[1]); // Either buy 0th stock or 1st stock
        sell[1] = Math.max(0, prices[1] - prices[0]); // Either do nothing or Buy 0 Sell 1
         
        for(int i=2; i<prices.length; i++){
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        
        return sell[prices.length - 1];
    }
}