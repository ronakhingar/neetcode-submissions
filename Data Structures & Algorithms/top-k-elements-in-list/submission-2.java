class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num:nums){

            map.put(num,map.getOrDefault(num,0)+1);
        }

       List<Integer> list[] = new List[n+1];

       for(Map.Entry<Integer,Integer> entry : map.entrySet() ){

            if(list[entry.getValue()]==null){
                list[entry.getValue()]= new ArrayList<>();
            }
            list[entry.getValue()].add(entry.getKey());
       }

       int count=0;
       List<Integer> output = new ArrayList<>();
       for(int i =n;i>=0&& count<k;i--){

        if(list[i]!=null){

            for(int j=0;j<list[i].size() && count<k ;j++){
                output.add(list[i].get(j));
                count++;
            }
        }
       }

       return output.stream().mapToInt(i->i).toArray();

    }
}
