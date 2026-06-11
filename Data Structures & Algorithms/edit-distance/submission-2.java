class Solution {
    Integer[][] memo;
    public int minDistance(String word1, String word2) {
        
        memo = new Integer[word1.length()][word2.length()];
        return calculateMinDistance(word1,word2,0,0);
    }


    private int calculateMinDistance(String word1,String word2,int index1, int index2){

       
       
        if(index1==word1.length() ){
            return word2.length()-index2;
        }

        if( index2==word2.length()){
            return word1.length()-index1;
        }

        if(memo[index1][index2]!= null){
            return memo[index1][index2];
        }

            if(word1.charAt(index1)==word2.charAt(index2)){
               return memo[index1][index2] = calculateMinDistance(word1,word2,index1+1,index2+1);
            } else{
                
              int replace=  1+calculateMinDistance(word1,word2,index1+1,index2+1);

              int add = 1+calculateMinDistance(word1,word2,index1,index2+1);

              int delete=1+calculateMinDistance(word1,word2,index1+1,index2);

             return memo[index1][index2]=  Math.min(replace,Math.min(add,delete));
            }


        
    }
}
