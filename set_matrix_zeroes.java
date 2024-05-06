class Solution {
    public void setZeroes(int[][] matrix) {        
    int col0 = 1;

    // Check if the first column contains a zero
    for (int i = 0; i < matrix.length; i++) {
        if (matrix[i][0] == 0) {
            col0 = 0;
        }
    }

    // Mark the corresponding row and column zero based on zeros in the matrix
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 1; j < matrix[i].length; j++) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = matrix[0][j] = 0;
            }
        }
    }

    // Set zeros based on the marks
    for (int i = matrix.length - 1; i >= 0; i--) {
        for (int j = matrix[i].length - 1; j >= 1; j--) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0;
            }
        }
        // Set zeros for the first column if necessary
        if (col0 == 0) {
            matrix[i][0] = 0;
        }
    }
    }
}