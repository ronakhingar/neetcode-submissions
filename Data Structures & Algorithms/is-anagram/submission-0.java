class Solution {
    public boolean isAnagram(String s, String t) {
        int[] countAlphabets = new int[26];

        for(char c: s.toCharArray()){
            int index = c- 'a';
            countAlphabets[index]++;
        }

        for(char c: t.toCharArray()){
            int index = c - 'a';
            countAlphabets[index]--;

        }

        for(int i=0;i<countAlphabets.length;i++){
            if(countAlphabets[i]!=0){
                return false;
            }
        }
    return true;
    }
}
