package com.obito.leetcode;

/**
 * @author admin
 */
public class SwapPairs_24
{
    public static class ListNode
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public static ListNode swapPairs(ListNode head)
    {
        // 如果只有一个
        if (head == null || head.next == null)
        {
            return head;
        }
        
        // 记录头指针的next作为返回值
        ListNode ans = head.next;
        
        ListNode pre = null;
        
        ListNode next = head.next;
        
        ListNode cur = head;
        
        while (next != null)
        {
            cur.next = next.next;
            
            next.next = cur;
            
            if (pre != null)
            {
                pre.next = next;
            }
            
            pre = cur;
            
            cur = cur.next;
            
            next = cur == null ? null : cur.next;
        }
        
        return ans;
    }
    
    public static void main(String[] args)
    {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        
        ListNode listNode = swapPairs(listNode1);
        
        System.out.println(listNode.val);
        
        ListNode next = listNode.next;
        
        while (next != null)
        {
            System.out.println(next.val);
            next = next.next;
        }
    }
}
