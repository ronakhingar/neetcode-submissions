class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] taskFreq= new int[26];
        TreeMap<String,Character> map = new TreeMap<>();

        for(int i=0;i<tasks.length;i++){
            taskFreq[tasks[i]-'A']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (int[] a, int[] b)->{
                return Integer.compare(b[1],a[1]);
            }
        );
       for(int i=0;i<26;i++){
        if(taskFreq[i]!=0){
        pq.add(new int[]{(char)('A'+i),taskFreq[i]});

        }
        
       }

        int size=tasks.length;
        int count=0;
        List<int[]> tempList= new ArrayList<>();
       while(pq.size()>0 || tempList.size()>0){
       
    if(pq.size()>0){
        int[] taskPolled = pq.poll();
        taskPolled[1]--;
        if(taskPolled[1]>0){
    tempList.add(taskPolled);

        }
       
    }
       
        count++;
        

        if(count%(n+1)==0){
            pq.addAll(tempList);
            tempList = new ArrayList<>();

        }

       }


return count;




    }
}
