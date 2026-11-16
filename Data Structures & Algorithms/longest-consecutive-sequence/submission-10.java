class Solution {
    public int longestConsecutive(int[] nums) {
        // optimal is to get adj elements no need of sorting check through existenc and how to get existsnce optimally using set 
        int n = nums.length; 
        if(n == 0) return 0;
        HashSet<Integer> set = new HashSet<>(); 
        for(int num : nums){
            set.add(num);
        } 
        // if num - 1 does not exist in the array that means that num could be our potential starting point may be not always 
        // assume potential and check num + 1 exists in set or not if exists go ahead increamnt count updated max if it is not reset count
        int count = 1; 
        int max = 1; 
        // to optime furtehr iterate on set over array to avoid duplicate elements
        for(int i=0; i<n; i++){
            int num = nums[i]; 
            if(!set.contains(num-1)){
                // this is my potential starting point 
                while(set.contains(num+1)){
                    count++;
                    max = Math.max(max, count);
                    num++; 
                } 
                count = 1; 
            }
        } 
        return max;
    }
}
