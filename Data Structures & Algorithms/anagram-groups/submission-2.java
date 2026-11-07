class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // see we have to use charArray to check anagram now question is how to put into list or how to match with prev one lets say act is in list and i am at index 3 cat so it should go to list where act present right but how to put this cat into act list ? 

        // anagram means if you sort two strings then you will get same output 
        // e.g "act" and "cat" -> after sorting both will look like "act" so both act and cat are anagrams of each other 
        // brute force 
        int n = strs.length; 
        // int[] charArray = new int[26]; 
        // boolean[] visited = new boolean[n]; // this will help to skip visited ones 
        // List<List<String>> list = new ArrayList<>(); 

        // for(int i=0; i<n; i++){ 

        //     if(visited[i]){
        //         continue;
        //     }

        //     String str1 = strs[i]; 
        //     List<String> temp = new ArrayList<>();
        //     temp.add(str1);
        //     visited[i] = true;

        //     // if not visited then and then only explore else skip these string 
        //     for(int j=i+1; j<n; j++){
        //         String str2 = strs[j];

        //         if(!visited[j]){
        //             if(matchesAnagram(str1, str2)){
        //                 temp.add(str2);
        //                 visited[j] = true;
        //             }
        //         } 
        //     }
        //     list.add(temp);
        // } 
        // return list; 

        // better -> sort the string first and use map to check is any other string with same if yes add in list here sorted part will be key and list will be value of that key  

        HashMap<String, List<String>> mpp = new HashMap<>(); 

        for(int i=0; i<n; i++){
            String str = strs[i]; 

            // sorted key 
            // e.g ["act", "cat"]
            char[] charArray = str.toCharArray(); // ['c', 'a' , 't']
            Arrays.sort(charArray);  // ['c', 'a', 't']
            String key = new String(charArray); // convert into string from array i.e act  
            mpp.putIfAbsent(key, new ArrayList<>()); // if key does not exist then create emppty list as val map will lool like act -> []
            mpp.get(key).add(str); // get the sorted key in map and add string map will look like act -> [act, cat] act pehle se hi tha imaginne karo we were processing cat not act
        }
        return new ArrayList<>(mpp.values()); // only print mpp values beccause thhis is answer 
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
