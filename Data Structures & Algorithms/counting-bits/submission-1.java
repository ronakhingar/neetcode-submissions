class Solution {
    public int[] countBits(int n) {
        
        int[] output = new int[n+1];
        for(int i=0;i<=n;i++){

           output[i] = count(i);
        }

        return output;
    }

    private int count(int x){
        int c=0;
        while(x!=0){
            x=x&(x-1);
            c++;
        }
        return c;
    }
}
