class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev1 = head, curr1 = head.next, prev2 = prev1, curr2 = curr1, ans = curr1;

        while(curr1 != null){
            prev2 = prev1.next;
            curr2 = curr1.next;
            if(prev1.next != null && prev1.next.next != null){
                prev2 = prev1.next.next;
            }
            if(curr1.next != null && curr1.next.next != null){
                curr2 = curr1.next.next;
            }
            prev1.next = curr1.next;
            if(curr1.next != null && curr1.next.next != null){
                prev1.next = curr1.next.next;
            }
            curr1.next = prev1;
            prev1 = prev2;
            curr1 = curr2;
            if(curr1 == prev1) break;
        }

        return ans;
    }
}
