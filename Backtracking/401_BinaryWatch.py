class Solution(object):

    def readBinaryWatch(self, num):
        """
        :type num: int
        :rtype: List[str]
        """
        res = []
        for h in range(12):
            for m in range(60):
                # must pay attention to count bit. use count('1') but not count(1)
                if bin(h).count('1') + bin(m).count('1') == num:
                    res.append('%d:%02d' % (h, m))
        return res

if __name__ == '__main__':
    s = Solution()
    l = s.readBinaryWatch(8)
    print l