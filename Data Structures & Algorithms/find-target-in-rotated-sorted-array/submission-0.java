class Solution {
    public int search(int[] nums, int target) {
        // [3,4,5,6,1,2]
        //  0 1 2 3 4 5 
        // mid = 2 , target = 1 
        int n = nums.length;
        // int ans = -1; 
        int start = 0;
        int end = n-1;

        while(start <= end){
            int mid = start + (end - start)/2; 

            if(nums[start] <= nums[mid]){
                if(nums[mid] == target) {
                    return mid;
                }
                else if(target < nums[mid] && target >= nums[start]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(nums[mid] == target) {
                    return mid;
                }
                else if(target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }  
        return -1;
    }
}
