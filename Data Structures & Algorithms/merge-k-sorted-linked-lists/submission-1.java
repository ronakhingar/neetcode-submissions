/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head=new ListNode();
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b)->
        {
            return Integer.compare(a.val,b.val);
        });

        for(int i=0;i<lists.length;i++){

            ListNode lNode = lists[i];

            if(lNode!=null){
                pq.add(lNode);
            }
   
            
        }

        ListNode newNode=head;
        while(!pq.isEmpty()){

            ListNode node= pq.poll();

            if(node.next!=null){
                pq.add(node.next);
            }
         

            newNode.next=node;
            newNode= newNode.next;
        }

    return head.next;
    }
}


