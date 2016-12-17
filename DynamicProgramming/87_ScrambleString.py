class Solution(object):

    def isScramble(self, s1, s2):
        if s1 == s2:
            return True
        len1, len2 = len(s1), len(s2)
        if len1 != len2:
            return False
        arr = [0] * 26
        for i in range(0, len1):
            arr[ord(s1[i]) - ord("a")] += 1
            arr[ord(s2[i]) - ord("a")] -= 1
        for x in arr:
            if x != 0:
                return False
        for i in range(1, len1):
            if self.isScramble(s1[0:i], s2[0:i]) and self.isScramble(s1[i:], s2[i:]):
                return True
            if self.isScramble(s1[0:i], s2[-i:]) and self.isScramble(s1[i:], s2[0:len1 - (i)]):
                return True
        return False
