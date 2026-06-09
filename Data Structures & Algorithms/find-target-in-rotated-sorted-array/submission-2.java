class Solution {
    public int search(int[] nums, int target) {
        
        return searchInRotated(nums,target,0,nums.length-1);
    }

    private int searchInRotated(int[] nums,int target, int low,int high){

        if(low>high){
            return -1;
        }

        int mid = low +(high-low)/2;

        if(nums[mid]==target){
          return mid;
        }

        else if(nums[low]<=nums[mid]){
          if(nums[low]<=target && nums[mid]>target){
           return searchInRotated(nums,target,low,mid-1);
          }else{
           return searchInRotated(nums,target,mid+1,high);
          }


        }else{

          if(nums[mid]<target && nums[high]>=target){
           return searchInRotated(nums,target,mid+1,high);
          
          }else{
           return searchInRotated(nums,target,low,mid-1);
          }
        }

    }
}
