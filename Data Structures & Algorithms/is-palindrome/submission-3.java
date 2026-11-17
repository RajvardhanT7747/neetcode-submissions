class Solution {
    public boolean isPalindrome(String s) {
        // CASE Sensitive -> Means both uppercase and lowercasee are considered as different 'A' and 'a' are not equal 
        // CASE Insesitive -> Means both are same 'A' and 'a' are equal 

        int n = s.length(); 
        s = s.toLowerCase(); // convert into lowercase
        int left = 0; 
        int right = n-1; 

        // s = "a,b!"
        //      L R 

        while(left <= right){
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            } 
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        } 
        return true;
    }
}
