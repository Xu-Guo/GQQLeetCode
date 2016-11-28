import copy


class Solution(object):

    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        lst = []
        self.backtract(lst, [], s, 0)
        return lst

    def backtract(self, lst, tmplist, s, start):
        # print tmplist
        if start == len(s) and len(tmplist) == 4:
            lst.append(".".join(copy.deepcopy(tmplist)))
        elif start < len(s) and len(tmplist) < 4:
            for i in range(1, 4):
                if start + i > len(s):
                    continue
                tmp = s[start:start + i]
                if self.fit_ip_address(tmp):
                    # print tmp
                    tmplist.append(tmp)
                    self.backtract(lst, tmplist, s, start + i)
                    tmplist.pop()

    def fit_ip_address(self, s):
        if len(s) == 0 or len(s) >= 4:
            return False
        if len(s) > 1 and s.startswith('0'):
            return False
        if int(s) < 0 or int(s) > 255:
            return False
        return True
