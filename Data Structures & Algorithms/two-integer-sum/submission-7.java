class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length; 

        // for(int i=0; i<n; i++){
        //     for(int j=i+1; j<n; j++){
        //         if(nums[i] + nums[j] == target){
        //             return new int[]{i, j};
        //         }
        //     }
        // }
        // return new int[]{-1, -1}; 
        // Above solution takes 0(n^2) time complexity and 0(1) space complexity 

        // int[][] arr = new int[n][2];
        // for(int i=0; i<n; i++){
        //     arr[i][0] = nums[i];
        //     arr[i][1] = i;
        // }

        // Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        // int i = 0; 
        // int j = n-1; 
        // while(i < j){
        //     if(arr[i][0] + arr[j][0] == target){
        //         return new int[]{Math.min(arr[i][1], arr[j][1]), Math.max(arr[j][1], arr[i][1])};
        //     }else if(arr[i][0] + arr[j][0] < target){
        //         i++;
        //     }else{
        //         j--;
        //     }
        // }
        // return new int[]{-1, -1}; 

        HashMap<Integer, Integer> mpp = new HashMap<>(); 

        for(int i=0; i<n; i++){
            int num = nums[i]; 
            int difference = target - num; 

            if(mpp.containsKey(difference)){
                return new int[]{mpp.get(difference), i};
            } 

            mpp.put(num, i);
        }
        return new int[]{};
    }
}
