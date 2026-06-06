class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashSet<Integer> set = new HashSet<>();
        set.add(k);

        int minTotalTime=-1;
        List<int[]> list[] = new List[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b)->{

            return Integer.compare(a[1],b[1]);
        });

        for(int i=0;i<=n;i++){
            list[i] = new ArrayList<>();
        }

        for(int[] time : times){

            list[time[0]].add(new int[]{time[1],time[2]});

            if(time[0]==k){
                pq.add(new int[]{time[1],time[2]});
            }
        }

        
        while(!pq.isEmpty()){

            int[] next = pq.poll();
            

            if(set.contains(next[0])){
                continue;
            }

            set.add(next[0]);
            minTotalTime=next[1];
            for(int[] neighbors: list[next[0]] ){

                if(!set.contains(neighbors[0])){
                pq.add(new int[]{neighbors[0],neighbors[1]+next[1]});

                }

            }

        }

        return set.size()== n? minTotalTime:-1;
        
    }
}
