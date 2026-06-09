class Solution {
    public int maxArea(int[] heights) {
        

        int left=0;
        int right= heights.length-1;
        int maxArea=0;
        while(left<right){
        
          int ht=Math.min(heights[left],heights[right]);
          int width=right-left;
          maxArea=Math.max(ht*width,maxArea);
          if(heights[left]>heights[right]){
            right--;
          }else if(heights[left]<heights[right]){
            left++;
          }else{
            left++;
            right--;
          }

        }
        return maxArea;
    }
}
