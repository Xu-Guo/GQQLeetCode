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
        h = head
        n = 0
        while h is not None:
            n += 1
            h = h.next

        # if n <= 2, return
        if n <= 2:
            return

        # find the mid position of this array.
        mid_val = n / 2
        mid = head
        for i in range(mid_val):
            mid = mid.next

        k = mid.next
        while k.next is not None:
            tmp = mid.next
            mid.next = k.next
            k.next = mid.next.next
            mid.next.next = tmp

        p = head
        while mid.next is not None:
            tmp = p.next
            p.next = mid.next
            mid.next = mid.next.next
            p.next.next = tmp
            p = tmp
