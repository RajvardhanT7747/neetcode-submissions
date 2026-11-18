class Solution {
    public int maxArea(int[] heights) {
        // Plz ask interviewer one clarification question that that bars that comes between two bars so while calculating max amount of water do i need to substract height of that bar ? or we hAVE TO consider only two bars that we are considering and in between bars ko maro goli ? 

        // in this question we are ignoring bars that are present in betweeen two bars that we are going to select
        int n = heights.length; 
        int max = 0; 
        int first = 0;
        int last = n-1; 

        while(first < last){
            int width = last - first; 
            if(heights[first] < heights[last]){
                max = Math.max(max, Math.min(heights[first], heights[last]) * width); 
                first++; // because there might be a chance in future we get bigger bar than current and we might get higher amount of water 
            }else{
                max = Math.max(max, Math.min(heights[first], heights[last]) * width); 
                last--;
            }

        }
        return max;
    }
}
