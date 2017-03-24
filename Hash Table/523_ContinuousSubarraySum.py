class Solution(object):
    def checkSubarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        n = len(nums)
        if (n < 2):
            return False;

        sums = [nums[0]]
        for i in range(1, n):
            sums.append(sums[i - 1] + nums[i])

        for i in range(1, n):
            if k == 0:
                if sums[i] == 0:
                    return True;
            else:
                if sums[i] % k == 0:
                    return True

        for i in range(n - 2):
            for j in range(i + 2, n):
                if k == 0:
                    if sums[j] - sums[i] == 0:
                        return True
                else:
                    if (sums[j] - sums[i]) % k == 0:
                        return True
        return False

