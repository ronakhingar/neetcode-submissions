class KthLargest {

    PriorityQueue<Integer> queue;
    int k;
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        this.k=k;
        for(int num:nums){
            queue.add(num);

            if(queue.size()>k){
                queue.poll();
            }
        }


    }
    
    public int add(int val) {

        queue.add(val);
        
      
            if(queue.size()>k){
                queue.poll();
            }

    return queue.isEmpty()?null:queue.peek();
    }
}
