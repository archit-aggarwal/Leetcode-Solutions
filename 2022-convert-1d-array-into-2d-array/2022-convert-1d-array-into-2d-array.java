class Solution {
    public int[][] construct2DArray(int[] original, int rows, int cols) {
        int[][] mat = new int[rows][cols];
        if(rows * cols != original.length) return new int[0][0];
        
        int idx = 0;
        
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                mat[row][col] = original[idx++];
            }
        }
        
        return mat;
    }
}