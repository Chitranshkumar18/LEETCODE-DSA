
class Solution {
    public ListNode reverseList(ListNode head) {
    if(head==null || head.next==null) return head;
      ListNode p=null;
      ListNode curr=head;
      ListNode temp=head;
      
     while(curr != null){
        temp = temp.next;
        curr.next = p;
        p = curr;
        curr = temp;
     }
     return p;
      
    }

}