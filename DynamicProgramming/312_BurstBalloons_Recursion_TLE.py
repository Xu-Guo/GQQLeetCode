class Solution(object):

    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return self.maxC(nums, {})

    def maxC(self, nums, cache):
        mval = 0
        n = len(nums)
        if n == 0:
            return 0
        if n == 1:
            return nums[0]
        key = tuple(nums)
        if cache.has_key(key):
            return cache.get(key)

        for i in range(0, n):
            left = 1 if i == 0 else nums[i - 1]
            right = 1 if i == n - 1 else nums[i + 1]
            if i == 0:
                subarr = nums[1:n]
            elif i == n - 1:
                subarr = nums[0:n - 1]
            else:
                subarr = nums[0:i] + nums[i + 1:n]
            mval = max(mval, left * nums[i] * right + self.maxC(subarr, cache))
        cache[key] = mval
        return mval


if __name__ == '__main__':
    s = Solution()
    print s.maxCoins([2, 4, 8, 4, 0, 7, 8, 9, 1, 2, 4, 7, 1, 7, 3, 6])
