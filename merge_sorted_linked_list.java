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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 ==  null) return list2;
        else if(list2 ==  null) return list1;
        ListNode prev= null, curr = null, head = null;

        while(list1 != null && list2!=null) {
            ListNode temp = new ListNode();
            if(list1.val <= list2.val) {
                temp.val = list1.val;
                list1 = list1.next;
            } else {
                temp.val = list2.val;
                list2 = list2.next;
            }
            if(curr != null){
                curr.next = temp;            
            } else head = temp;
            prev = curr;
            curr = temp;
        }

        while(list1 != null) {
            ListNode temp = new ListNode();
            temp.val = list1.val;
            list1 = list1.next;
            if(curr != null){
                curr.next = temp;                
            } else head = temp;
            prev = curr;
            curr = temp;
        }

        while(list2 != null) {
            ListNode temp = new ListNode();
            temp.val = list2.val;
            list2 = list2.next;
            if(curr != null){
                curr.next = temp;                
            } else head = temp;
            prev = curr;
            curr = temp;
        }

        return head;
    }
}