class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost=new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src]=0;
        
        for(int i=0;i<=k;i++)
        {
            int[] temp = Arrays.copyOf(cost,n);
            for(int[] f: flights)
            {
                int incoming = f[0];
                int outgoing = f[1];
                int price = f[2];
                
                if(cost[incoming] == Integer.MAX_VALUE) continue;
                temp[outgoing] = Math.min(temp[outgoing], cost[incoming] + price);
            }
            cost = temp;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}