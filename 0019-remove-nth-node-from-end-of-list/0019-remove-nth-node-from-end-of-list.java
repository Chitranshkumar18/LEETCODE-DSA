
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null) return null;
        ListNode temp = head;
        int len=1;
        while(temp.next != null){
            temp=temp.next;
            len++;
        }
         
        int x = len - n;
        if(x==0){
            return head.next;
        }
      
        temp = head;
        for(int i =1;i<x;i++){
           temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
        
    }

}