class LRUCache {


HashMap<Integer,ListNode> map;
ListNode head;
ListNode tail;
int capacity;
    public LRUCache(int capacity) {
        map= new HashMap<>();
        head = new ListNode(-1,-1);
        tail= new ListNode(-1,-1);
        head.next=tail;
        tail.prev=head;
        this.capacity=capacity;
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key)){
            return -1;
        }

         removeFromCurrent(map.get(key));
            addToHead(map.get(key));
           return map.get(key).value;
    }
    
    public void put(int key, int value) {
        ListNode l= new ListNode(key,value);
        if(map.containsKey(key)){

            removeFromCurrent(map.get(key));
        }else{
            if(capacity<=map.size()){
                removeFromEnd();
            }
        }
            addToHead(l);

        map.put(key,l);
    }

    private void removeFromCurrent(ListNode l){

        l.prev.next=l.next;
        l.next.prev=l.prev;

    }

    private void addToHead(ListNode l){
        ListNode first= head.next;
        l.next=first;
        first.prev=l;
        head.next=l;
        l.prev=head;
    }

    private void removeFromEnd(){
        ListNode l = tail.prev;
        l.prev.next=tail;
        tail.prev=l.prev;

        map.remove(l.key);
    }
}

class ListNode{
Integer key;
Integer value;
ListNode next;
ListNode prev;

public ListNode(Integer key,Integer value){
this.key=key;
this.value=value;
}


}
