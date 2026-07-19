class Solution {
    public int getSum(int a, int b) {

        
        int carry=0;
        int multiplier=1;
        int n=0;
        int output=0;
        while(n<32){

            int x = a&multiplier;
            int y= b&multiplier;

            int t1= (x^y)^carry;
            carry=((x&y)|(x&carry)|(y&carry))<<1;
            multiplier*=2;
            output=output | t1;
            n++;
        }
    return output;
        
    }
}
