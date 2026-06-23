class Solution {

    Node head= new Node();
    private static int[][] directions ={{-1,0},{0,-1},{1,0},{0,1}};
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> output = new HashSet<>();
        for(String word: words){
            Node n= head;
            for(char c: word.toCharArray()){
                int index =c-'a';
                if(n.nodes[index]==null){
                   n.nodes[index]=new Node(); 
                }
                n= n.nodes[index];
            }
            n.isWord=true;
            n.word=word;
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
            char c = board[i][j];
            int index = c-'a';
            Node n =head;
                if(n.nodes[index]!=null){
                    dfs(board,i,j,n.nodes[index],output ,new StringBuilder(c+""));
                }
            }
        }

    return new ArrayList<>(output);
    }

    private void dfs(char[][] board, int i, int j, Node n, Set<String> output, StringBuilder s){

        if(n.isWord){
            output.add(n.word);
            
        }

        char c = board[i][j];
        board[i][j]='0';
       
        for(int[] direction: directions){
            
            int row = i+direction[0];
            int col=j+direction[1];
                        
            if(isValid(board,row,col,n)){
               int index = board[row][col] - 'a';
            if( index>=0 && index<26 && n.nodes[index]!=null){
                dfs(board,row,col,n.nodes[index],output, s.append(board[row][col]));
            }
               
            }
        }
        board[i][j]=c;


    }

    private boolean isValid(char[][] board, int row, int col, Node n){
 
        return row>=0 && col>=0&& row<board.length && col<board[0].length ;
    }


}

class Node{

    Node[] nodes = new Node[26];
    boolean isWord=false;
    String word="";
}
