class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>(); 
        // HashSet<List<Integer>> set = new HashSet<>(); // either you can use set but as arr is sorted use adj over set take most of use of sorting right
        Arrays.sort(nums);
        // [-4, -1, -1, 0, 1, 2]
        for(int i=0; i<=n-3; i++){ // n-3 because below two pointers will take care of n-2 and n-1
            // avoid duplicates 
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int j = i+1; 
            int k = n-1;  
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                    while(j < k && nums[k] == nums[k+1]){
                        k--;
                    }
                }else if(sum < 0){
                    j++;
                }else{
                    k--;
                }
            }
        } 
        return list;
    }
}
