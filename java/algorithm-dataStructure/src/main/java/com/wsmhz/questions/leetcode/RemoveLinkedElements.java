package com.wsmhz.questions.leetcode;

/**
 * create by tangbj on 2018/10/30
 *
 * 第203题, 移除链表元素
 *
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveLinkedElements {

     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
         }
     }

    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if(head == null){
            return null;
        }

        ListNode pre = head;//不为空且值一定不是val
        while(pre.next != null){
            if(pre.next.val == val){
                ListNode delNode = pre.next;
                pre.next = delNode.next;
                delNode.next = null;
            }else{
                pre = pre.next;
            }
        }
        return head;
    }

}
