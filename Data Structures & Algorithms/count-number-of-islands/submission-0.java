class Solution {

    public static int[][] directions ={{0,-1},{-1,0},{0,1},{1,0}};
    public int numIslands(char[][] grid) {

        int count=0;
            for(int i=0;i<grid.length;i++){

                for(int j=0;j<grid[0].length;j++){

                    if(grid[i][j]=='1'){
                        bfs(i,j,grid);
                        count++;
                    }
                }
            }
            return count;
    }

    private void bfs(int i, int j, char[][] grid){

        grid[i][j]='0';

        for(int[] direction:directions){
            int x= i + direction[0];
            int y=j + direction[1];
            if(isValid(x,y,grid)){
                bfs(x,y,grid);
            }
        }
    }

    private boolean isValid(int i, int j, char[][] grid){

        return i>=0&& i<grid.length && j>=0 && j<grid[0].length && grid[i][j]=='1';
           

    }
}
