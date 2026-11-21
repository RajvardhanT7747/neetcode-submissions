class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int ans = 0;
        int start = 1;
        int end = maxi(piles); 

        while(start <= end){
            int mid = start + (end - start) / 2;
            // mid is basically hour
            if(helper(piles, mid, h)){
                ans = mid;
                end = mid-1;
            } else {
                start = mid + 1;
            }
        } 
        return ans;
    }
    public boolean helper(int[] piles, int mid, int h){
        long check = calculate(piles, mid); 

        if(check <= h) return true;
        else return false;
    } 
    public int maxi(int[] piles){
        int max=piles[0];
        for(int i=1; i<piles.length; i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }
        return max;
    }
    public long calculate(int[] piles, int mid){
        int n = piles.length; 
        long sum = 0; // due to constraints

        for(int i=0; i<n; i++){
            sum += Math.ceil((double)piles[i]/mid);
        } 
        return sum;
    }
}
