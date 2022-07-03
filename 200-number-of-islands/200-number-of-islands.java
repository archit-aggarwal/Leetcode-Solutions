class Solution {
    public void DFS(int r, int c, char[][] grid){
        // Out of Matrix, Water Cell, Visited Land
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length 
           || grid[r][c] == '0' || grid[r][c] == 'N') return;
        
        grid[r][c] = 'N'; // Visited Land
        DFS(r - 1, c, grid);
        DFS(r + 1, c, grid);
        DFS(r, c - 1, grid);
        DFS(r, c + 1, grid);
    }
    
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                // Unvisited Land
                if(grid[i][j] == '1'){
                    DFS(i, j, grid);
                    islands++;
                }
            }
        }
        return islands;
    }
}