class Twitter {


    int timestamp=0;
    Map<Integer,HashSet<Integer>> followMap;
    Map<Integer,TweetList> tweetMap;

    public Twitter() {
        followMap= new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        
        Tweet tweet = new Tweet(timestamp++,userId,tweetId);
        if(!tweetMap.containsKey(userId)){
            tweetMap.put(userId, new TweetList());
        }
        tweetMap.get(userId).addFirst(tweet);

        if(tweetMap.get(userId).size>10){
            tweetMap.get(userId).removeLast();
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
            pq.add(tweetMap.get(userIdTemp).head.next);
            }
        }

    int count=0;
    List<Integer> outputList= new ArrayList<>();
        while(pq.size()>0 && count<10){

          Tweet t=  pq.poll();
          outputList.add(t.tweetId);

          if(t.next.next!=null){
            pq.add(t.next);
          }
          count++;
          

        }
        return outputList;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId,x->new HashSet<>()).add(followeeId);
        followMap.get(followerId).add(followerId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        
        followMap.get(followerId).remove(followeeId);
    }
}

class Tweet implements Comparable<Tweet>{

    int timestamp;
    int userId;
    int tweetId;
   Tweet next;
   Tweet prev;

   public Tweet(){
    timestamp=0;
    userId=0;
    tweetId=0;
    next=null;
    prev=null;
   }

    public Tweet(int timestamp, int userId, int tweetId){
        this.timestamp = timestamp;
        this.userId = userId;
        this.tweetId = tweetId;
       
    }
    public int compareTo(Tweet other){
             return Integer.compare(other.timestamp,this.timestamp);
    }
}

class TweetList{

    Tweet head;
    Tweet tail;
    int size=0;
    public TweetList(){
        head = new Tweet();
        tail = new Tweet();
        head.next=tail;
        tail.prev=head;
    }

    public void addFirst(Tweet t){
       Tweet prevHead= head.next;
        t.next=prevHead;
        t.prev=head;
        prevHead.prev=t;
        head.next=t;
        size++;
      
    }

    public void removeLast(){

        Tweet prevLast=tail.prev;
        prevLast.prev.next=tail;
        tail.prev=prevLast.prev;
        size--;
    }
}

