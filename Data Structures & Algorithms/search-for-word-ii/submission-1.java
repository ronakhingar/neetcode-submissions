class Solution {

    public static int[][] directions = {{0,-1},{-1,0},{0,1},{1,0}};
    
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> outputWords= new ArrayList<>();
        

        for(String word: words){
            boolean found=false;
            for(int i=0;i<board.length;i++){

                for(int j=0;j<board[i].length;j++){

                    if(board[i][j]==word.charAt(0) &&  dfs(board,word,i,j,0))
                        {
                            outputWords.add(word);
                            found =true;
                            break;
                        }
                   
                }
                if(found){
                    break;
                }
            }

        }
        return outputWords;

    }

    private boolean dfs(char[][] board, String word, int i, int j, int index){

        if(word.length()-1==index){
            return true;
        }

        board[i][j]='0';

        for(int[] direction: directions){
            int row= i+ direction[0];
            int col = j+ direction[1];

            if(isValid(row,col,board, word.charAt(index+1))){
              boolean b = dfs(board,word,row,col,index+1);
              if(b){
                board[i][j]= word.charAt(index);
                return true;
              }
            }
        }
        
    board[i][j]= word.charAt(index);
    return false;


    }

    private boolean isValid(int row, int col, char[][] board, char c){

        return row>=0 && col>=0 && row<board.length && col<board[0].length && c==board[row][col];
    }


}
