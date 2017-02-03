class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        stk = []
        isResult = False
        n = len(s)
        i = 0
        calVal = 0
        while i < n or isResult:
            if not isResult:
                if s[i].isdigit():
                    j = i + 1
                    while j < n and s[j].isdigit():
                        j += 1
                    ele = s[i:j]
                    i = j
                else:
                    ele = s[i]
                    i += 1
            else:
                ele = str(calVal)
                isResult = False

            if ele == " ":
                continue
            elif ele in ["(", "+", "-"]:
                stk.append(ele)
            elif ele == ")":
                calVal = stk.pop()
                stk.pop()
                isResult = True
            else:
                # is digit
                if len(stk) == 0 or stk[-1] not in ["+", "-"]:
                    stk.append(ele)
                else:
                    isResult = True
                    opr = stk.pop()
                    fir = stk.pop()
                    if opr == "+":
                        calVal = int(fir) + int(ele)
                    else:
                        calVal = int(fir) - int(ele)
        return int(stk[-1])

