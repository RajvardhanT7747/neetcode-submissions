class Solution {
    public int leastInterval(char[] tasks, int n) {
         int m = tasks.length; 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());  // max heap 

        int[] charFreq = new int[26]; 
        for(int i=0; i<m; i++){
            int ch = tasks[i]; 
            charFreq[ch - 'A']++; 
        }  

        // add all elements in heap 
        for(int i=0; i<26; i++){
            if(charFreq[i] > 0){
                pq.add(charFreq[i]);
            }
        } 

        int ans = 0; 

        while(!pq.isEmpty()){
            int  taskCycle = 0;
            int cycle = n + 1; 

            // maintain Queue to keep track of processsed ones 
            ArrayList<Integer> list = new ArrayList<>(); 

            while(cycle > 0 && !pq.isEmpty()){
                int currentTask = pq.poll(); 

                if(currentTask > 1){
                    list.add(currentTask - 1); // decreament count by 1 and push 
                } 

                taskCycle++; 
                cycle--; 
            } 
            // reinsert elements back to heap 
            for(int element : list){
                pq.add(element); 
            } 
            ans += pq.isEmpty() ? taskCycle : n + 1;
        }
        return ans;
        
    }
}
