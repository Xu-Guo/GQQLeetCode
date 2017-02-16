class Solution(object):

    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # self.findIndex(nums, 0, len(nums - 1))
        return self.findIndex(nums, 0, len(nums) - 1, k)

    def findIndex(self, nums, start, end, k):
        p = self.getPivotIndex(nums, start, end)
        if p - start == k - 1:
            return nums[p]
        if p - start > k - 1:
            return self.findIndex(nums, start, p - 1, k)
        return self.findIndex(nums, p + 1, end, k - p + start - 1)

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


    # this method can not exactly find the correct index of pivot.
    def getPivotIndex(self, nums, start, end):
        mid = start + (end - start) / 2
        pivot = nums[mid]
        while start <= end:
            while nums[start] > pivot:
                start += 1
            while nums[end] < pivot:
                end -= 1
            if start <= end:
                nums[start], nums[end] = nums[end], nums[start]
                start += 1
                end -= 1
        return end
