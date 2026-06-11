class Solution {
    int[] rank;
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {

         parent = new int[edges.length+1];

        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        rank = new int[edges.length+1];
        int[] output = new int[2];
        for(int[] edge: edges){

            if(union(edge[0],edge[1])){
                output=edge;
                break;
            }

        }
        return output;
    
        
    }

    private boolean union(int u, int v){

       int pU= findParent(u);
        int pV= findParent(v);

        if(pU==pV){
            return true;
        }

        if(rank[pU]>=rank[pV]){
            parent[pV]=pU;
            rank[pU]++;
        }else{
            parent[pU]=pV;
            rank[pV]++;
        }

    return false;
    }

    private int findParent(int node){

        if(parent[node]==node){
            return node;
        }

        return parent[node]=findParent(parent[node]);

    }
}
