class Twitter {


    int timestamp=0;
    Map<Integer,HashSet<Integer>> followMap;
    Map<Integer,TreeSet<Tweet>> tweetMap;
    public Twitter() {
        followMap= new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        
        Tweet tweet = new Tweet(timestamp++,userId,tweetId);
        tweetMap.computeIfAbsent(userId,x->new TreeSet<>()).add(tweet);

        if(tweetMap.get(userId).size()>10){
            tweetMap.get(userId).pollLast();
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        PriorityQueue<Tweet> pq = new PriorityQueue<>((Tweet a,Tweet b)->{
            return Integer.compare(b.timestamp,a.timestamp);
        }); 

        followMap.computeIfAbsent(userId,x->new HashSet<>()).add(userId);
        List<Integer> tempList = new ArrayList<>(followMap.get(userId));

        
        // for(Integer followee: followMap.get(userId)){
            
        //     if(tweetMap.containsKey(followee)){
        //     pq.addAll(tweetMap.get(followee));
        //     }
            
        // }

        for(int i=0;i<tempList.size();i++){
            int userIdTemp=tempList.get(i);
            if(tweetMap.containsKey(userIdTemp)){
            pq.add(tweetMap.get(userIdTemp).first());
            }
        }

    int count=0;
    List<Integer> outputList= new ArrayList<>();
        while(pq.size()>0 && count<10){

          Tweet t=  pq.poll();
          outputList.add(t.tweetId);
          Tweet t2 = tweetMap.get(t.userId).higher(t);
          if(t2!=null){
            pq.add(t2);
          }
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

class Tweet implements Comparable<Tweet>{

    int timestamp;
    int userId;
    int tweetId;

    public Tweet(int timestamp, int userId, int tweetId){
        this.timestamp = timestamp;
        this.userId = userId;
        this.tweetId = tweetId;
    }
    public int compareTo(Tweet other){
             return Integer.compare(other.timestamp,this.timestamp);
    }
}
