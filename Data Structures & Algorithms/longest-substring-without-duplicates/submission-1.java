class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] indexLast = new int[256];
        Arrays.fill(indexLast,-1);
        int longest=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            if(indexLast[s.charAt(i)]!=-1){
                if(indexLast[s.charAt(i)]>=left){
                    left=indexLast[s.charAt(i)]+1;
                }
                
            }
            indexLast[s.charAt(i)]=i;
            longest= Math.max(longest,i-left+1);
        }
        return longest;
    }
}
