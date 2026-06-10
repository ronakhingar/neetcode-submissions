class Solution {

    private static int[][] directions={{0,-1},{-1,0},{0,1},{1,0}};
    int count=0;
    int time=0;
    public int orangesRotting(int[][] grid) {
        int freshFruits=0;

        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j< grid[0].length;j++){

                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    freshFruits++;
                }
            }
        }

        bfs(grid,queue);
        return count==freshFruits ?time:-1;
    }

    private void bfs(int[][] grid, Queue<int[]> queue){

        while(!queue.isEmpty()){
            int size= queue.size();
        while(size > 0){

           int[] polled= queue.poll(); 
           size--;

            for(int[] direction: directions){
                int r= polled[0]+direction[0];
                int c= polled[1]+direction[1];
            if(isValid(r,c,grid)){
                queue.add(new int[]{r,c});
                grid[r][c]=2;
                 count++; 
            }

            }

        }

        if (!queue.isEmpty()) {
                time++;
            }
        }

    }

    private boolean isValid(int r, int c, int[][] grid){
        return r>=0 &&c>=0 && r<grid.length && c<grid[0].length && grid[r][c]!=2 && grid[r][c]!=0;
    }
}
