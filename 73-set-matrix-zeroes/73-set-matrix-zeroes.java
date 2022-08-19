class Solution {
    public void setRow(int[][] matrix, int row, int val){
        for(int col=0; col<matrix[0].length; col++)
            matrix[row][col] = val;
    }
    
    public void setCol(int[][] matrix, int col, int val){
        for(int row=0; row<matrix.length; row++)
            matrix[row][col] = val;
    }
    
//     public void approach1(int[][] matrix){
//         // Inplace - O(1) space, if allowed to store other than 0/1
//         for(int i=0; i<matrix.length; i++){
//             for(int j=0; j<matrix[0].length; j++){
//                 if(matrix[i][j] == 0){
//                     setRow(matrix, i, -1);
//                     setCol(matrix, j, -1);
//                 }
//             }
//         }
        
//         for(int i=0; i<matrix.length; i++)
//             for(int j=0; j<matrix[0].length; j++)
//                 if(matrix[i][j] == -1)
//                     matrix[i][j] = 0;
//     }
    
    public void approach2(int[][] matrix){
        // Extra Space - O(N * M), Time = O(N * M)
        
        int[][] copy = Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);
        // creating a copy of 2d matrix
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(copy[i][j] == 0){
                    setRow(matrix, i, 0);
                    setCol(matrix, j, 0);
                }
            }
        }
    }
    
    public void approach3(int[][] matrix){
        // Extra Space - O(N + M), Time = O(N * M)
        
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rows[i] = cols[j] = true;
                }
            }
        }
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(rows[i] == true || cols[j] == true){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    public void approach4(int[][] matrix){
        // Extra Space - O(N + M), Time = O(N * M)
        
        boolean row0 = false;
        boolean col0 = false;
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if(i == 0) row0 = true;
                    if(j == 0) col0 = true;
                    
                    if(i != 0 && j != 0)
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(col0 == true){
            for(int i=0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        
        if(row0 == true){
            for(int j=0; j<matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
    }
    
    public void setZeroes(int[][] matrix) {
        approach4(matrix);
    }
}