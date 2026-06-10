class Solution {
    public int[] productExceptSelf(int[] nums) {
        

        int[] prefix = new int[nums.length];
        int[] output= new int[nums.length];

        int prev=1;
        for(int i=0;i<prefix.length;i++){

          prefix[i]=prev;
          prev=prefix[i]*nums[i];
        }

        prev=1;
        for(int i=nums.length-1;i>=0;i--){

          output[i]=prefix[i]*prev;
          prev=nums[i]*prev;
        }

        return output;
    }
}  
