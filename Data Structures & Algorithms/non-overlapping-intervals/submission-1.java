class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length; 
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();  
        int[] current = intervals[0];
        for(int i=1; i<n; i++){
            // check overlapping 
            int[] next = intervals[i]; 
            if(next[0] < current[1]){
                // find interval with min end and add in list 
                if(current[1] <= next[1]){
                    // keep current one 
                }else{
                    // keep next one 
                    current = next; 
                }
            }else{
                list.add(current);
                current = next; 
            }
        } 
        list.add(current); 

        return n - list.size();
    }
}
