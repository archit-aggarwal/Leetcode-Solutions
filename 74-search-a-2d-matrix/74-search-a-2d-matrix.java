class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Linear Search -> Nested Loops 
//         int row = matrix.length, col = matrix[0].length;
//         for(int i=0; i<row; i++){
//             for(int j=0; j<col; j++){
//                if(matrix[i][j] == target){
//                    return true;
//                }
//             } 
//         }
        
//         return false;
        
        int row = 0, col = matrix[0].length - 1; // Top Right Corner
        
        while(row < matrix.length && col >= 0){
            
            if(matrix[row][col] == target) 
                return true;
            
            else if(matrix[row][col] < target){
                // Discard the current row
                row++;
            }
            
            else {
                // Discard the current col
                col--;
            }
        }
        
        return false;
    }
}