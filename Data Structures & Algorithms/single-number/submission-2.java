class Solution {
    public int singleNumber(int[] nums) {
        

    int output=0;
        for(int num:nums){

            output = output^num;
        }
    return output;
        
    }
}
