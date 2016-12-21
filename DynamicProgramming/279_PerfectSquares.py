import math
class Solution(object):

    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        ret = [0, 1, 2, 3]
        if n <= 0:
            return ret[0]
        if n <= 3:
            return ret[n]
        for i in range(2, int(math.sqrt(n))+1):
            end = (i+1)**2
            start = i**2
            for j in range(0, end - start):
                # print i, j
                if j == 0:
                    ret.append(1)
                else:
                    min_v = ret[1] + ret[start + j -1]
                    for k in range(2, (start+j)/2+1):
                        # print k
                        v = ret[k] + ret[start + j - k]
                        min_v = v if v < min_v else min_v
                    ret.append(min_v)
                if start + j == n:
                    break
        print(ret)
        return ret[-1]

if __name__ == '__main__':
    s = Solution()
    print s.numSquares(100)