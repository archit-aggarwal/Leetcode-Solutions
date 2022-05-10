class Solution {
    public int maxProfit(int[] prices) {
       int valley = 0, profit = 0;
       while(valley < prices.length){
           int peak = valley;
           while(peak + 1 < prices.length && prices[peak + 1] >= prices[peak]){
               peak++;
           }
           
           profit = profit + (prices[peak] - prices[valley]);
           valley = peak + 1;
       }
       return profit;
    }
}