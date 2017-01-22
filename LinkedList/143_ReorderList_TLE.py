# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):

    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """
        p = head
        cnt = 0
        while p is not None:
            cnt += 1
            p = p.next
        if cnt <= 2:
            return
        q = head
        q_start = cnt / 2
        for i in range(q_start):
            q = q.next
        p_start = q_start - 1 if cnt % 2 == 1 else q_start - 2
        for step in range(p_start, -1, -1):
            p = head
            for i in range(step):
                p = p.next
            tmp = p.next
            p.next = q.next
            q.next = p.next.next
            p.next.next = tmp
