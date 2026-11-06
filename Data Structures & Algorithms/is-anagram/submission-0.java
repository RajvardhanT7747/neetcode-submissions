class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] charArrayS = new int[26]; 
        int[] charArrayT = new int[26]; 

        for(int i=0; i<n; i++){
            char ch = s.charAt(i); 
            charArrayS[ch-'a']++;
        }
        for(int i=0; i<m; i++){
            char ch = t.charAt(i); 
            charArrayT[ch-'a']++;
        } 

        for(int i=0; i<26; i++){
            if(charArrayS[i] != charArrayT[i]){
                return false;
            }
        }
        return true;    
    }
}
