class Solution(object):
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        # 1 + 3 + 5
        if num == 0:
            return True

        cnt, ele = 0, 1
        while cnt < num:
            cnt, ele = cnt + ele, ele + 2
            # print cnt, ele
        return cnt == num