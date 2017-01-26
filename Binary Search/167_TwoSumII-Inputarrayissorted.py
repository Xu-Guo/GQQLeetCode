class Solution(object):

    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        if len(numbers) < 2:
            return
        left, right = 0, len(numbers) - 1
        while left < right:
            des = numbers[left] + numbers[right]
            if des == target:
                return [left + 1, right + 1]
            elif des < target:
                left += 1
            else:
                right -= 1
        return
