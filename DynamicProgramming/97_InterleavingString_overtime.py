class Solution(object):

# Time Limit Exceeded
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        if len(s3) != len(s1) + len(s2):
            return False
        if len(s1) == 0 and len(s2) == 0 and len(s3) == 0:
            return True
        return self.bk(s3, "", s1, s2, 0, 0)

    def bk(self, dest, now_str, s1, s2, s1_index, s2_index):
        if dest == now_str and s1_index == len(s1) and s2_index == len(s2):
            return True
        if s1_index < len(s1) and dest.startswith(now_str + s1[s1_index]):
            r = self.bk(dest, now_str + s1[s1_index], s1, s2, s1_index + 1, s2_index)
            if r:
                return True
        if s2_index < len(s2) and dest.startswith(now_str + s2[s2_index]):
            r = self.bk(dest, now_str + s2[s2_index], s1, s2, s1_index, s2_index + 1)
            if r:
                return True
        return False

if __name__ == '__main__':
    s = Solution()
    print s.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
"babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
"babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab")