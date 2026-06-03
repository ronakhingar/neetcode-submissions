class Solution {
    public boolean isPalindrome(String s) {
        

        int leftIndex=0;
        int rightIndex=s.length()-1;

        while(leftIndex<rightIndex){

        
            while(leftIndex < s.length() && !Character.isLetterOrDigit(s.charAt(leftIndex))){
                leftIndex++;
            }

               while(rightIndex>=0 && !Character.isLetterOrDigit(s.charAt(rightIndex))){
                rightIndex--;
            }

            if(leftIndex<rightIndex && Character.toLowerCase(s.charAt(leftIndex))!=Character.toLowerCase(s.charAt(rightIndex))){
                return false;
            }
            leftIndex++;
            rightIndex--;
        }

        return true;
    }
}
