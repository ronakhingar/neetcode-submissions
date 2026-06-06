class Solution {

    int maxSum=Integer.MIN_VALUE;
    public int maxSubArray(int[] nums) {
        int currSum=0;
        for(int i=0;i<nums.length;i++){


            if(currSum+nums[i]>0){
                currSum=currSum+nums[i];
            }else{
                if(nums[i]<0){
                    currSum=nums[i];
                }else{
                    currSum=0;
                }
               
            }

            currSum= Math.max(currSum,nums[i]);

            maxSum=Math.max(currSum,maxSum);

        }
        return maxSum;

    }
}
