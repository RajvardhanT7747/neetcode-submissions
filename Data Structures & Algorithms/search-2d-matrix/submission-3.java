class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
     // row is sorted in increasing order
     // first integer of every new row is greater than last integer of prev row
     // see brute force approach is simple linear search which will end up taking 0(n) time complexity but we need to take advantage of sorted nature of it 
     // yes optimal way is reduce search space and my main observation is there are only two starting points we can consider one is top right element bcause on left decresing and on below increasing order so we can distinguish and other point is bottom left so we can use either one of them lets take top right corner as a starting point 
     // brute force logic : compare that starting element with if greater then skip that roww because entire row could have elements < target right so go to next row similarly you lik this we can reduce space 

     // optimal way: flatten matrix i.e imagine 2d matrix as 1d matrix 
        int n = matrix.length; // number of rows
        int m = matrix[0].length; // number of column 

        // imagine 1d array and based on that we are pointing left pointer at idx 0 and right pointer at idx last one 
        int left = 0; 
        int right = n * m - 1; 

        while(left <= right){
            int mid = left + (right - left)/2; 

            // now using this mid index we can get (row, column) index of that element 
            int row = mid / m; // to get rowth idx 
            int col = mid % m; // to get colth idx 

            int element = matrix[row][col]; 

            if(element == target){
                return true;
            } else if(element < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        } 
        return false;
    }
}
