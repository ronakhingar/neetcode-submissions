class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        int ladderLength=0;
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visitedWords = new HashSet<>();

        if(!wordSet.contains(endWord)){
            return ladderLength;
        }

        Queue<String> queue = new ArrayDeque<>();

        queue.offer(beginWord);

        while(!queue.isEmpty()){

            int size = queue.size();
            ladderLength++;

        for(int i=0;i<size;i++){


          String word = queue.poll();
        if(word.equals(endWord)){
return ladderLength;
        }


        

        for(String w: wordList){

            if(!visitedWords.contains(w) && oneDiff(word,w)){
                queue.offer(w);
                visitedWords.add(word); 
            }
        }

        }

        }
       return visitedWords.contains(endWord)?ladderLength:0;
    }

    private boolean oneDiff(String word1, String word2){

        boolean oneDiff=false;
        for(int i=0;i<Math.min(word1.length(),word2.length());i++){

            if(word1.charAt(i)!=word2.charAt(i)){

                if(!oneDiff ){
                oneDiff=true;
                }else{
                    return false;
                }


            }

        }

        return oneDiff;
    }
}
