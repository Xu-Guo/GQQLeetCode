class Solution(object):

    # Time Limit Exceeded
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        len1 = len(s1)
        len2 = len(s2)
        len3 = len(s3)
        if len3 != len1 + len2:
            return False
        # init len2 * len1 rectancle
        r = [[0 for x in range(len1 + 1)] for y in range(len2 + 1)]
        r[0][0] = 1
        # first line
        for j in range(0, len1):
            if r[0][j] == 1 and s1[j] == s3[j]:
                r[0][j + 1] = 1

        # first column
        for i in range(len2):
            if r[i][0] == 1 and s2[i] = s3[i]:
                r[i + 1][0] = 1

        # the contents of matrix
        for i in range(1, len2 + 1):
            for j in range(1, len1 + 1):
                if r[i - 1][j] == 1:
                    if s2[i - 1] == s3[i + j - 1]:
                        r[i][j] = 1
                if r[i][j - 1] == 1:
                    if s1[j - 1] == s3[i + j - 1]:
                        r[i][j] = 1

        return r[len2][len1] == 1
