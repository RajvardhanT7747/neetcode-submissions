class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // brute force 
        int n = matrix.length;
        int m = matrix[0].length; 

        // select top right corner as start
        int row = 0; 
        int column = m-1; 

        while(row < n && column >= 0){
            if(matrix[row][column] == target){
                return true;
            }else if(matrix[row][column] < target){
                row++;
            }else{
                column--;
            }
        }
        return false;
    }
}
