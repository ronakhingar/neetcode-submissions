class Solution {
    public int singleNumber(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();

    int output=0;
        for(int num:nums){

            output = output^num;
        }
    return output;
        
    }
}
