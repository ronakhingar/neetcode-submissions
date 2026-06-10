class Solution {

    private static int[][] directions = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> output = new ArrayList<>();
        int m = heights.length;
        int n= heights[0].length;
        boolean[][] atlantic = new boolean[m][n];
        boolean[][] pacific = new boolean[m][n];

        Queue<int[]> atlQueue = new ArrayDeque<>();
        Queue<int[]> pacQueue = new ArrayDeque<>();

         for (int r = 0; r < m; r++) {
            pacQueue.add(new int[]{r, 0});       // left edge
            atlQueue.add(new int[]{r, n - 1});   // right edge
        }

        for (int c = 0; c < n; c++) {
            pacQueue.add(new int[]{0, c});       // top edge
            atlQueue.add(new int[]{m - 1, c});   // bottom edge
        }

        

            bfs(atlantic,atlQueue,heights);
            bfs(pacific,pacQueue,heights);
            
        

        
    for(int i=0;i<heights.length;i++){
         for(int j=0;j<heights[i].length;j++){

            if (atlantic[i][j] && pacific[i][j]){
                output.add(List.of(i,j));
            }
            }
        }
        return output;

    }


    private void bfs( boolean[][] ocean, Queue<int[]> queue, int[][] heights){


        while(queue.size()>0){

        int[] cell=   queue.poll();

if(ocean[cell[0]][cell[1]]){
    continue;
}

       ocean[cell[0]][cell[1]]=true;


        for(int[] direction:directions){

            int r = cell[0]+direction[0];

            int c = cell[1]+ direction[1];
            if(isValid(r,c,ocean,cell,heights)){
                queue.add(new int[]{r,c});
            }
        }
        }


    }

    private boolean isValid(int r, int c,boolean[][] ocean,int[] cell,int[][] heights){
    return r>=0 && r<heights.length && c>=0 && c<heights[0].length && heights[r][c]>=heights[cell[0]][cell[1]] && !ocean[r][c];

    }


}
