class Solution {


    public int longestConsecutive(int[] nums) {
        
        int longestSequence=0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int num:nums){

            if(map.containsKey(nums)){
                continue;
            }

            map.put(num,null);

            if(map.containsKey(num+1)){
                map.put(num,num+1);
            }

            if(map.containsKey(num-1)){
                map.put(num-1,num);
            }
            

        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){

            if(entry.getValue()==null){
                Integer key= entry.getKey();
                int count=0;
                while(map.containsKey(key)){
                    key=key-1;
                    count++;
                }
                longestSequence= Math.max(longestSequence,count);

            }
        }

return longestSequence;
        

    }
}
