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

    public boolean canAttendMeetings(List<Interval> intervals) {


        Collections.sort(intervals,(Interval a, Interval b)->{
            if(Integer.compare(a.start,b.start)!=0){
                return Integer.compare(a.start,b.start);
            }else{
                return Integer.compare(a.end,b.end);
            }
        });

        int lastEnd=-1;

        for(Interval x: intervals){

            if(x.start<lastEnd){
                return false;
            }
            lastEnd=x.end;
        }
        return true;
    }
}
