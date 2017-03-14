class Solution(object):

    def wordPatternMatch(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        dic = {}
        contradic = {}
        return self.helper(pattern, str, dic, contradic)

    def helper(self, pattern, str, dic, contradic):
        # print pattern, str, dic
        if str == "" and pattern == "":
            return True
        if str != "" and pattern != "":
            key = pattern[0]
            if key in dic:
                val = dic[key]
                if not str.startswith(val):
                    return False
                return self.helper(pattern[1:], str[len(val):], dic, contradic)
            else:
                for i in range(1, len(str) + 1):
                    newval = str[0: i]
                    if newval in contradic:
                        continue
                    dic[key] = newval
                    contradic[newval] = key
                    res = self.helper(pattern[1:], str[len(newval):], dic, contradic)
                    del dic[key]
                    del contradic[newval]
                    if res:
                        return True
        return False
