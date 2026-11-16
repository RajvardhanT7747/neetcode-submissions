class Solution {
    public boolean isValidSudoku(char[][] board) {
     int n = board.length;
     int m = board[0].length; 

    // row vallidation  
     for(int i=0; i<n; i++){
        HashSet<Character> set = new HashSet<>(); 
        for(int j=0; j<m; j++){
            char ch = board[i][j]; 
            if(ch == '.'){
                continue;
            }
            if(set.contains(ch)){
                return false;
            } 
            set.add(ch); 
        }
     } 
     // col validation  
     for(int j=0; j<m; j++){
        HashSet<Character> set = new HashSet<>(); 
        for(int i=0; i<n; i++){
            char ch = board[i][j]; 
            if(ch == '.') continue; 
            if(set.contains(ch)) return false; 
            set.add(ch);
        }
     } 

     // 3 x 3 matrix validation 
     for(int row=0; row<n; row+=3){
        for(int col=0; col<m; col+=3){
            int startRow = (row / 3) * 3; 
            int startCol = (col / 3) * 3; 
            
            HashSet<Character> set = new HashSet<>(); 

            for(int i=startRow; i<startRow + 3; i++){
                for(int j=startCol; j<startCol + 3; j++){
                    char ch = board[i][j]; 
                    if(ch == '.') continue; 
                    if(set.contains(ch)) return false; 
                    set.add(ch);
                }
            }    
        }
     } 
     return true;
    }
}
