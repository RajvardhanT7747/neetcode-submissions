class Solution {
    public int trap(int[] height) {
        // one way is use stack approach of NGE and PGE 
        // one more way is use prefix max and suffix max using auxillary space (extra arrays for both prefix and suffix) 
        // one more way is optimal way i.e use two pointers
        int n = height.length;
        int trappedWater = 0; 
        int left = 0;
        int right = n-1; 
        int leftMax = 0; // which tracks left maximum element 
        int rightMax = 0; // which tracks right maximum element

        while(left < right){ // when both becomes == stop 
            if(height[left] < height[right]){
                // do left process 
                leftMax = Math.max(leftMax, height[left]); 
                trappedWater += leftMax - height[left];
                left++;
            }else{ // process right when height[right] < height[left]
                rightMax = Math.max(rightMax, height[right]); 
                trappedWater += rightMax - height[right];
                right--;
            }
        } 
        return trappedWater;
    }
}
