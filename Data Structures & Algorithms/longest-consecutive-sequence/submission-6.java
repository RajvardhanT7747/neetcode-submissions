class Solution {
    public int longestConsecutive(int[] nums) {
        // brute force approach is sort the array first and then just check the diff between current and prev if it is one then increament the count  
        int n = nums.length;
        if(n == 0) return 0;
        Arrays.sort(nums);
        int count = 1; 
        int maxCount = 1; 
        for(int i=1; i<n; i++){
            if(nums[i] == nums[i-1]) continue;
            if(nums[i] - nums[i-1] == 1){
                count++;
                maxCount = Math.max(count, maxCount);
            }else{
              count=1;  
            }
        } 
        return maxCount;
    }
}
