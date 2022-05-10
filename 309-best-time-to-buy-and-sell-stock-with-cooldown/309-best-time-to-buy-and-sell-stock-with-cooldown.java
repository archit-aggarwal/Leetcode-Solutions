class Solution {
    public int maxProfit(int[] prices) {
         if(prices.length <= 1) return 0;
        
        int buy0 = -prices[0];
        int sell0 = 0;
        int buy1 = Math.max(-prices[0], -prices[1]); // Either buy 0th stock or 1st stock
        int sell1 = Math.max(0, prices[1] - prices[0]); // Either do nothing or Buy 0 Sell 1
         
        for(int i=2; i<prices.length; i++){
            int newbuy = Math.max(buy1, sell0 - prices[i]);
            int newsell = Math.max(sell1, buy1 + prices[i]);
            
            buy0 = buy1; sell0 = sell1;
            buy1 = newbuy; sell1 = newsell;
        }
        
        return sell1;
    }
}