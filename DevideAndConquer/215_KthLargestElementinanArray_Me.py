class Solution(object):

    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # the question can be converted to find the k-1 index after quick sort.
        return self.quickSortFind(nums, 0, len(nums) - 1, k)

    def quickSortFind(self, nums, start, end, k):
        p = self.getPivotIndex(nums, start, end)
        if p == k - 1:
            return nums[p]
        if p > k - 1:
            return self.quickSortFind(nums, start, p - 1, k)
        return self.quickSortFind(nums, p + 1, end, k)

    def getPivotIndex(self, nums, start, end):
        pivot = nums[start]
        while start < end:
            while start < end and nums[end] <= pivot:
                end -= 1
            nums[start] = nums[end]
            while start < end and nums[start] >= pivot:
                start += 1
            nums[end] = nums[start]
        nums[start] = pivot
        return start
