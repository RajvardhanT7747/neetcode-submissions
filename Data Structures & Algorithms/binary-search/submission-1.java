class Solution {
    public int search(int[] nums, int target) {
        // if array is sorted and we have to search something bs will come into picture 
        int n = nums.length; 
        int left = 0;
        int right = n-1; 
        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }
}
