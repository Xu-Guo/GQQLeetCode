class Solution(object):

    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        n = len(nums)
        if n == 1:
            return True if nums[0] == target else False
        low, high = 0, n - 1
        while low <= high:
            mid = low + (high - low) / 2
            if nums[mid] == target:
                return True
            if nums[mid] < nums[low]:
                if nums[mid] < target and target <= nums[high]:
                    low = mid + 1
                else:
                    high -= 1
            elif nums[mid] > nums[low]:
                if target >= nums[low] and target < nums[mid]:
                    high -= 1
                else:
                    low += 1
            else:
                low += 1
        return False
