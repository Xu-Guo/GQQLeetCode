# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
            return head
        dummy = ListNode(-1)
        dummy.next = head
        p, q = head, head.next
        while q is not None:
            p.next = q.next
            q.next = dummy.next
            dummy.next = q
            q = p.next
        return dummy.next
        