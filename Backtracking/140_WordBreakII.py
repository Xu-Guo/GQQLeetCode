class Solution(object):

    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: List[str]
        """
        return self.bk({}, s, wordDict)

    def bk(self, dic, s, wordDict):
        if s in dic:
            return dic[s]
        res = []
        if len(s) == 0:
            res.append('')
            return res
        for word in wordDict:
            if s.startswith(word):
                curr = s[0:len(word)]
                subres = self.bk(dic, s[len(word):], wordDict)
                for sub in subres:
                    if len(sub)>0:
                        res.append(curr + " " + sub)
                    else:
                        res.append(curr)
        dic[s] = res
        return res


if __name__ == '__main__':
    s = Solution()
    print s.wordBreak("aggegbnngohbggalojckbdfjakgnnjadhganfdkefeddjdnabmflabckflfljafdlmmbhijojiaaifedaihnoinedhhnolcjdam",
                      ["o", "b", "gbdfgiokkfnhl", "glibjohcmd", "bblcnhelanckn", "mflabckflflja", "mgda", "oheafhajjo", "cc", "cffalholojikojm", "haljiamccabh", "gjkdlonmhdacd", "ee", "bc", "mjj", "fdlmmbhij", "nn", "jiaaifedaihn", "nhligg", "hooaglldlei", "hajhebh", "ebijeeh", "me", "eibm", "ekkobhajgkem", "ohaofonhjakc", "n", "kjjogm", "mhn", "odcamjmodie", "edmagbkejiocacl", "kcbfnjialef", "lhifcohoe", "akgnn", "fbgakjhjb", "belggjekmn", "oinedhhnolc", "ddekcnag", "oneoakldakalb", "bodnokemafkhkhf", "dkefeddjdnab", "gflcngff", "fgnfmbcogmojgm", "ad", "jadhganf", "lojckbdfj", "gadkaoe", "jdam", "ljjndlnednnombl", "aggegbnngohbgga"])
# ['aggegbnngohbgga lojckbdfj akgnn jadhganf dkefeddjdnab mflabckflflja fdlmmbhij o jiaaifedaihn oinedhhnolc jdam']