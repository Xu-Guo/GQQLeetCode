class Solution(object):

    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        ret0, ret1, ret2 = 0, 0, 0
        for i in range(len(costs)):
            new_ret0 = min(costs[i][0] + ret1, costs[i][0] + ret2)
            new_ret1 = min(costs[i][1] + ret0, costs[i][1] + ret2)
            new_ret2 = min(costs[i][2] + ret0, costs[i][2] + ret1)
            ret0, ret1, ret2 = new_ret0, new_ret1, new_ret2
        return min(ret0, ret1, ret2)
