/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {


        Collections.sort(intervals,(Interval a, Interval b)->{
            return Integer.compare(a.start,b.start);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Interval x: intervals){

            if(pq.size()>0 && pq.peek()<=x.start){

                pq.poll();
                pq.add(x.end);
                

            }else{
                pq.add(x.end);
            }
        }

        return pq.size();
    }
}
