class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        
        for(int i=0;i<9;i++){

            if(! (isValidRow(board,i) && isValidColumn(board,i) && isValidGrid(board,i))){
                return false;
            }
        }
        return true;
    }


    private boolean isValidRow(char[][] board, int row){
        boolean[] bool= new boolean[9];
        for(int i=0;i<9;i++){

              if (board[row][i] == '.') {
                continue;
            }

            int index=(board[row][i]-'1');
          
            if(bool[index]){
                return false;
            }
           bool[index]=true;

        }
        return true;
    }

    private boolean isValidColumn(char[][] board, int col){
        boolean[] bool= new boolean[9];
        for(int i=0;i<9;i++){
            if (board[i][col] == '.') {
                continue;
            }
            int index=(board[i][col]-'1');
            if(bool[index]){
                return false;
            }
           bool[index]=true;

        }
        return true;
    
    }

    private boolean isValidGrid(char[][] board,int gridNo){

        int rowMin = (gridNo / 3) * 3;
int rowMax = rowMin + 3;
int colMin = (gridNo % 3) * 3;
int colMax = colMin + 3;
        boolean[] bool= new boolean[9];

        for(int i=rowMin;i<rowMax;i++){
            for(int j=colMin;j<colMax;j++){
                if (board[i][j] == '.') {
                continue;
            }
        int index=(board[i][j]-'1');
            if(bool[index]){
                return false;
            }
           bool[index]=true;

            }
        }
        return true;
    }
}
