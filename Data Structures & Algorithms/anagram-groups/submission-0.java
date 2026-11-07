class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // see we have to use charArray to check anagram now question is how to put into list or how to match with prev one lets say act is in list and i am at index 3 cat so it should go to list where act present right but how to put this cat into act list ? 

        // brute force 
        int n = strs.length; 
        int[] charArray = new int[26]; 
        boolean[] visited = new boolean[n]; // this will help to skip visited ones 
        List<List<String>> list = new ArrayList<>(); 

        for(int i=0; i<n; i++){ 

            if(visited[i]){
                continue;
            }

            String str1 = strs[i]; 
            List<String> temp = new ArrayList<>();
            temp.add(str1);
            visited[i] = true;

            // if not visited then and then only explore else skip these string 
            for(int j=i+1; j<n; j++){
                String str2 = strs[j];

                if(!visited[j]){
                    if(matchesAnagram(str1, str2)){
                        temp.add(str2);
                        visited[j] = true;
                    }
                } 
            }
            list.add(temp);
        } 
        return list;
    } 

    public boolean matchesAnagram(String str1, String str2){
        int n = str1.length();
        int m = str2.length(); 

        int[] charStr1 = new int[26];
        int[] charStr2 = new int[26]; 

        for(int i=0; i<n; i++){
            char ch = str1.charAt(i); 
            charStr1[ch-'a']++;
        } 
        
        for(int i=0; i<m; i++){
            char ch = str2.charAt(i); 
            charStr2[ch-'a']++; 
        } 

        for(int i=0; i<26; i++){
            if(charStr1[i] != charStr2[i]){
                return false;
            }
        }
        return true;
    }
    
}
