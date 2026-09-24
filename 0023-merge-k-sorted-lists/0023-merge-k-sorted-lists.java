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
    public ListNode mergeKLists(ListNode[] list) {
       int count =0;
       for(int i=0;i<list.length;i++){
           ListNode temp = list[i];
           while(temp!=null){
            temp = temp.next;
            count++;
           }
       }

       int[] flat = new int[count];
       int k = 0;
       if (flat.length == 0) {
            return null;
        }

       for(int i=0;i<list.length;i++){
          ListNode temp = list[i];

          while(temp!=null){
            flat[k++] = temp.val;
            temp = temp.next;
          }

       }


    Arrays.sort(flat);
    ListNode head = new ListNode(flat[0]);
    ListNode temp = head;
    for(int i=1;i<flat.length;i++){
       temp.next = new ListNode(flat[i]);
       temp = temp.next;

    }
    return head;
        
    }
}