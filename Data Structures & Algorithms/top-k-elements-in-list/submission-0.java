class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num: nums){


            map.put(num,map.getOrDefault(num,0)+1);

        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b)->{

            return Integer.compare(a[1],b[1]);
        });

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            pq.add(new int[]{entry.getKey(),entry.getValue()});

            if(pq.size()>k){

                pq.poll();
            }
        }

       List<Integer> list = new ArrayList<>();

       while(pq.size()!=0){

        list.add(pq.poll()[0]);
       }

return list.stream().mapToInt(i -> i).toArray();    }
}
