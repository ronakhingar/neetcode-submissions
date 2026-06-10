class MedianFinder {
List<Integer> list;
PriorityQueue<Integer> minHeap;
PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {

    minHeap.add(num);

    if(minHeap.size() > maxHeap.size()+1){
        maxHeap.add(minHeap.poll());
    }

    if(maxHeap.size()>0 && maxHeap.peek()<minHeap.peek()){
        minHeap.add(maxHeap.poll());
        maxHeap.add(minHeap.poll());
    }

    }
    
    public double findMedian() {
        
        // if(list.size()%2==0){
        //     return (double)(list.get((list.size()/2)-1)+list.get(list.size()/2))/2;
        // }else{
        //     return list.get((list.size()/2));
        // }

    int total= maxHeap.size()+minHeap.size();
    if(total%2==0){
        return (maxHeap.peek()+minHeap.peek())/2.0;
    }else{
        return minHeap.peek();
    }

    }

    private void addToMinHeap(PriorityQueue<Integer> heap1,PriorityQueue<Integer> heap2, int num){

            if(heap2.peek()<num){
                heap1.add(num);
            }else{
                heap1.add(heap2.poll());
                heap2.add(num);
            }
    }


    private void addToMaxHeap(PriorityQueue<Integer> heap1,PriorityQueue<Integer> heap2, int num){

            if(heap2.peek()<num){
                heap1.add(heap2.poll());
                heap2.add(num);
            }else{
                heap1.add(num);
            }
    }


}
