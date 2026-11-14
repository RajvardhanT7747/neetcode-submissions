class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();

        for(String str : strs){
            result.append(str.length())
                .append("#")
                .append(str);
        } 
        return result.toString(); // single string converted from list of strings 
    }

    public List<String> decode(String str) { 
        // 5#Hello5#World

        List<String> res = new ArrayList<>(); 
        int i = 0; // it will track len of string ie 5 

        while(i < str.length()){
            int j = i;
            // j will find delimiter ie # 
            while(str.charAt(j) != '#'){
                j++;
            } 
            int length = Integer.parseInt(str.substring(i, j)); // we will get 5
            String s = str.substring(j+1, j+1+length); // we will get Hello 

            res.add(s); 
            i = j+1+length;
        }
        return res; 
    }
}
