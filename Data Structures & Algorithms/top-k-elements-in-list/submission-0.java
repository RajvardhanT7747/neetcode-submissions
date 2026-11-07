class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // this question can be solved using heap as well 
        Map<Integer, Integer> mpp = new HashMap<>(); 
        for(int i=0; i<nums.length; i++){
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1); 
        } 

        // now build PQ with freq as key and number as val but we have to sort freq  
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(mpp.get(a), mpp.get(b))
        ); 

        // maintain only k elements 
        for(int num : mpp.keySet()){
            pq.add(num); 

            if(pq.size() > k){
                pq.poll();
            }
        } 

        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = pq.poll();
        }
        return ans;
    } 
}
