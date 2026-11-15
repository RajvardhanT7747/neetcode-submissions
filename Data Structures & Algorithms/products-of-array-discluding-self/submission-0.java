class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; 
        // my approach: prefixProduct[i]*suffixProduct[i] 
        int[] suffixProduct = new int[n];
        int[] prefixProduct = new int[n];  

        int prevProd = 1; 
        prefixProduct[0] = 1;
        for(int i=1; i<n; i++){
            prevProd *= nums[i-1];
            prefixProduct[i] = prevProd;
        }  

        int suffProd = 1; 
        suffixProduct[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            suffProd *= nums[i+1];
            suffixProduct[i] = suffProd;
        }
        
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            ans[i] = prefixProduct[i] * suffixProduct[i];
        }



        return ans;
    }
}  
