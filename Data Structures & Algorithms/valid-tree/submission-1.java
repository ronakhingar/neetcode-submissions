class Solution {
    public boolean validTree(int n, int[][] edges) {

        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }

        for(int[] edge:edges){

           if (!union(edge, parent,rank)){
            return false;
           }

        }

        int count=0;
        for(int i=0;i<parent.length;i++){
            
            if(i==parent[i]){
                count++;
            }
        }

        return count>1?false:true;

    }


    private boolean union(int[] edge,int[] parent, int[] rank){

        

      int parentX = find(edge[0],parent);
      int parentY = find(edge[1],parent);

      if(parentX == parentY){

        return false;
      }

      if(rank[parentX]>=rank[parentY]){
        parent[edge[1]]=edge[0];
        rank[parentX]++;
      }else{
        parent[edge[0]]=edge[1];
        rank[parentY]++;
      }

return true;
    }

    private int find(int curr, int[] parent){

        if(curr==parent[curr]){
            return curr;
        }

        return parent[curr] = find(parent[curr],parent);
    }

}
