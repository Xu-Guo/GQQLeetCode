class Solution(object):

    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums) - 1
        mi, ma = 1, n
        while mi <= ma:
            mid = mi + (ma - mi) / 2
            less, equal, high = 0, 0, 0
            for num in nums:
                if num == mid:
                    equal += 1
                elif num >= mi and num < mid:
                    less += 1
                elif num <= ma and num > mid:
                    high += 1
            if equal > 1:
                return mid
            elif less > mid - mi:
                ma = mid - 1
            else:
                mi = mid + 1
        return -1

if __name__ == '__main__':
    s = Solution()
    print s.findDuplicate([3, 1, 4, 2, 4])
