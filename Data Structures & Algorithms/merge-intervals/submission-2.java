class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        if (n == 1) {
            return intervals;
        }

        // Sort by starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();

        // // Current merged interval
        // int[] current = intervals[0];

        // for (int i = 1; i < n; i++) {
        //     int[] next = intervals[i];

        //     if (current[1] >= next[0]) {
        //         // Overlapping -> merge
        //         current[0] = Math.min(current[0], next[0]);
        //         current[1] = Math.max(current[1], next[1]);
        //     } else {
        //         // Non-overlapping -> finalize current
        //         list.add(current);

        //         // Start tracking next interval
        //         current = next;
        //     }
        // }

        // // Add the last interval
        // list.add(current);

        list.add(intervals[0]); 
        for(int i=1; i<n; i++){
            int[] current = intervals[i];
            int[] last = list.get(list.size()-1); 

            if(current[0] <= last[1]){
                last[1] = Math.max(last[1], current[1]);
            }else{
                list.add(current);
            }
        }
        
        return list.toArray(new int[list.size()][]);
    }
}