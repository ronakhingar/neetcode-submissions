class Solution {
    public int reverseBits(int n) {

        int output=0;

        int count=0;
        while(count<32){

            int val= n&(1<<count);
            if(val!=0){
                output=output|(1<<31-count);
            }
            count++;
        }

return output;

    }
}
