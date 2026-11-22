class Solution {
    public int findMin(int[] nums) {
        // brute force : 
        int n = nums.length;
        int min = Integer.MAX_VALUE; 
        // for(int i=0; i<n; i++){
        //     min = Math.min(min, nums[i]);
        // } 
        // return min; 
        int start = 0;
        int end = n-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] > nums[end]){
                // that means min exists on right so do mid + 1
                start = mid + 1;
            }else{
                // nums[mid] < nums[end] 
                min = Math.min(min, nums[mid]);
                end = mid-1;
            }
        }
        return min;
    }
}
