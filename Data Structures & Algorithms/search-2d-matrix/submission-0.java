class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        return search(matrix,target,0,matrix.length*(matrix[0].length)-1); 
    }

    private boolean search(int[][] matrix, int target, int start, int end){

        int mid = start+(end-start)/2;

        int row= mid/matrix[0].length;
        int col= mid%matrix[0].length;

        if(start>end){
            return false;
        }

        if(matrix[row][col]==target){
            return true;
        }else if(matrix[row][col]> target){
          return  search(matrix,target,start,mid-1);
        }else{
           return search(matrix,target,mid+1,end);
        }

    }
}
