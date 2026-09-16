class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd =new ListNode (-1);
        ListNode even=new ListNode(-1);
        ListNode oddtemp=odd;
        ListNode eventemp=even;
        ListNode temp=head;
        while(temp != null){
            oddtemp.next = temp;
            temp = temp.next;
            oddtemp = oddtemp.next;

            eventemp.next = temp;
           if(temp != null) temp = temp.next;
            eventemp = eventemp.next;
            
        }
        oddtemp.next = even.next;
        return odd.next;

      
    }
}