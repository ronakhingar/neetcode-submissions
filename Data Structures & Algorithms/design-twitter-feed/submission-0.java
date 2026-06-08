class Twitter {


    int timestamp=0;
    Map<Integer,HashSet<Integer>> followMap;
    Map<Integer,List<Tweet>> tweetMap;
    public Twitter() {
        followMap= new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        
        Tweet tweet = new Tweet(timestamp++,userId,tweetId);
        tweetMap.computeIfAbsent(userId,x->new LinkedList<>()).addFirst(tweet);

        if(tweetMap.get(userId).size()>10){
            tweetMap.get(userId).removeLast();
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        PriorityQueue<Tweet> pq = new PriorityQueue<>((Tweet a,Tweet b)->{
            return Integer.compare(b.timestamp,a.timestamp);
        }); 

        followMap.computeIfAbsent(userId,x->new HashSet<>()).add(userId);
        for(Integer followee: followMap.get(userId)){
            
            if(tweetMap.containsKey(followee)){
            pq.addAll(tweetMap.get(followee));
            }
            
        }

    int count=0;
    List<Integer> outputList= new ArrayList<>();
        while(pq.size()>0 && count<10){

          Tweet t=  pq.poll();
          outputList.add(t.tweetId);
          count++;
          

        }
        return outputList;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId,x->new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        
        followMap.get(followerId).remove(followeeId);
    }
}

class Tweet{

    int timestamp;
    int userId;
    int tweetId;

    public Tweet(int timestamp, int userId, int tweetId){
        this.timestamp = timestamp;
        this.userId = userId;
        this.tweetId = tweetId;
    }
}
