class Solution(object):

    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if len(s) == 0:
            return True
        stack = []
        for c in s:
            if c in ["(", "[", "{"]:
                stack.append(c)
            elif c in [")", "}", "]"] and len(stack) > 0:
                top = stack.pop()
                if not ((c == ")" and top == "(") or (c == "]" and top == "[") or (c == "}" and top == "{")):
                    return False
            else:
                return False
        return True if len(stack) == 0 else False
