class Solution(object):

    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 1:
            return nums[0]

        low, hi = 0, n - 1
        while low < hi:
            # we should check whether low smaller than hi everytime
            if nums[low] < nums[hi]:
                return nums[low]
            mid = low + (hi - low) / 2
            if nums[mid] > nums[low]:
                low = mid + 1
            elif nums[mid] < nums[low]:
                hi = mid
            else:
                low += 1
        return nums[low]
