class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prevGroup = null;

        while (temp != null) {

            // Check whether k nodes are available
            ListNode kth = temp;

            for (int i = 1; i < k; i++) {
                if (kth.next == null) {
                    return head;
                }
                kth = kth.next;
            }

            // Store the next group
            ListNode nextGroup = kth.next;

            // Reverse current k nodes
            ListNode prev = nextGroup;
            ListNode curr = temp;

            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect previous group
            if (prevGroup == null) {
                head = prev;
            } else {
                prevGroup.next = prev;
            }

            // Move to next group
            prevGroup = temp;
            temp = nextGroup;
        }

        return head;
    }
}