class Solution(object):

    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        new_nums = [1] + nums + [1]
        new_n = len(new_nums)
        cache = [[0 for i in range(new_n)] for j in range(new_n)]
        # cache = [[0] * new_n] * new_n
        # print cache
        max_val = self.maxC(new_nums, cache, 0, new_n - 1)
        # print cache
        return max_val

    def maxC(self, nums, cache, left, right):
        if left + 1 == right:
            return 0
        if cache[left][right] > 0:
            return cache[left][right]

        max_val = 0
        for i in range(left + 1, right):
            curr = nums[left] * nums[i] * nums[right]
            left_range_value = self.maxC(nums, cache, left, i)
            right_range_value = self.maxC(nums, cache, i, right)
            max_val = max(max_val, curr + left_range_value + right_range_value)
        # print left, right, max_val
        cache[left][right] = max_val
        # print left,right
        # print cache
        return max_val


if __name__ == '__main__':
    s = Solution()
    print s.maxCoins([3,1,5])
