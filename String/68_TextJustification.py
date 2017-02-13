class Solution(object):
    def fullJustify(self, words, maxWidth):
        """
        :type words: List[str]
        :type maxWidth: int
        :rtype: List[str]
        """
        res = []
        nums = []
        n = len(words)
        for word in words:
            nums.append(len(word))
        newStart = 0
        currLen = nums[0]
        for i in range(1, n):
            if currLen + 1 + nums[i] <= maxWidth:
                currLen = currLen + 1 + nums[i]
            else:
                # bigger than maxWidth
                res.append(self.buildString(newStart, i - 1, maxWidth, currLen, words))
                newStart = i
                currLen = nums[i]
        res.append(self.buildStringLastline(newStart, n - 1, maxWidth, currLen, words))
        return res
        
    def buildStringLastline(self, start, end, maxWidth, currLen, words):
        gap = end - start
        spaceNum = maxWidth - currLen
        s = []
        for i in range(start, end):
            s.append(words[i] + " ")
        s.append(words[end] + self.buildSpaces(spaceNum))
        return "".join(s)
    
    def buildString(self, start, end, maxWidth, currLen, words):
        gap = end - start
        if gap == 0:
            return words[start] + self.buildSpaces(maxWidth - currLen)
        spaceNum = maxWidth - currLen + gap
        ave = spaceNum / gap
        remain = spaceNum % gap
        avespaces = self.buildSpaces(ave)
        s = []
        for i in range(start, end):
            s.append(words[i])
            if remain > 0:
                s.append(avespaces + " ")
                remain -= 1
            else:
                s.append(avespaces)
        s.append(words[end])
        return "".join(s)

    def buildSpaces(self, n):
        s = []
        for i in range(n):
            s.append(" ")
        return "".join(s)
