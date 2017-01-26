class Solution(object):

    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        n = len(nums)
        if n < 1:
            return -1
        if 1 == n:
            return -1 if nums[0] != target else 0
        if nums[0] < nums[n - 1]:
            return self.doBinarySearch(nums, 0, n - 1, target)
        else:
            peak_index = self.findPeak(nums)
            if target >= nums[0]:
                return self.doBinarySearch(nums, 0, peak_index, target)
            else:
                return self.doBinarySearch(nums, peak_index + 1, n - 1, target)

    def findPeak(self, nums):
        low, high = 0, len(nums) - 1
        while low < high - 1:
            mid = low + (high - low) / 2
            if nums[mid] > nums[low]:
                if nums[mid] > nums[mid + 1]:
                    return mid
                else:
                    low = low + 1
            else:
                if nums[mid - 1] > nums[mid]:
                    return mid - 1
                else:
                    high -= 1
        return low



    def doBinarySearch(self, nums, low, high, target):
        while low <= high:
            mid = low + (high - low) / 2
            if nums[mid] == target:
                return mid
            elif target > nums[mid]:
                low += 1
            else:
                high -= 1
        return -1
