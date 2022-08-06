class Solution {
public:
    long long dp[75][75][75];
    
    long long calc(vector<vector<int>> &grid, int x1, int y1, int x2, int y2)
    {
        if(x1 == x2 && y1 == y2)
            return grid[x1][y1];
        
        return grid[x1][y1] + grid[x2][y2];
    }
    long long helper(vector<vector<int>> &grid, int r, int c1, int c2)
    {
        int n = grid.size(), m = grid[0].size();
        
        long long curr = calc(grid, r, c1, r, c2);
        if(r == n-1) return curr;
        if(dp[r][c1][c2] != -1) return dp[r][c1][c2];
        
        long long Max = INT_MIN;
        // 1 -> L 2 -> L
        if(c1-1 >= 0 && c2-1 >= 0)
            Max = max(Max, helper(grid, r+1, c1-1, c2-1));
        
        // 1 -> L 2 -> D
        if(c1-1 >= 0)
            Max = max(Max, helper(grid, r+1, c1-1, c2));
        
        // 1 -> L 2 -> R
        if(c1-1 >= 0 && c2+1 < m)
            Max = max(Max, helper(grid, r+1, c1-1, c2+1));
        
        // 1 -> D 2 -> L
        if(c2-1 >= 0)
            Max = max(Max, helper(grid, r+1, c1, c2-1));
        
        // 1 -> D 2 -> D
        Max = max(Max, helper(grid, r+1, c1, c2));
        
        // 1 -> D 2 -> R
        if(c2+1 < m)
            Max = max(Max, helper(grid, r+1, c1, c2+1));
        
        // 1 -> R 2 -> L
        if(c1+1 < m && c2-1 >= 0)
            Max = max(Max, helper(grid, r+1, c1+1, c2-1));
        
        // 1 -> R 2 -> D
        if(c1+1 < m)
            Max = max(Max, helper(grid, r+1, c1+1, c2));
        
        // 1 -> R 2 -> R
        if(c1+1 < m && c2+1 < m)
            Max = max(Max, helper(grid, r+1, c1+1, c2+1));
        
        dp[r][c1][c2] = curr + Max;
        return dp[r][c1][c2];
    }
    int cherryPickup(vector<vector<int>>& grid) {
        // In This Question Also, Row of both robots will be same.
        // Hence, this will also be 3d DP.
        
        int n = grid.size(), m = grid[0].size();
        
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                for(int k=0; k<m; k++)
                    dp[i][j][k] = -1;
        
        return max(0ll, helper(grid, 0, 0, m-1));
    }
};