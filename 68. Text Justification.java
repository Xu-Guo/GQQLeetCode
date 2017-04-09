public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        System.out.println(words.length);
        if (words == null || words.length == 0) return res;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < words.length) {
            String str = "";
            str = sb.length() == 0 ? (words[i].length() == 0 ? " " : words[i]) : " " + (words[i].length() == 0 ? " " : words[i]);
            int len = sb.length() + str.length();
            if (len == maxWidth) {
                sb.append(str);
                res.add(sb.toString());
                sb.setLength(0);
                i++;
            } else if (len > maxWidth) {
                justfy(res, sb.toString(), maxWidth);
                sb.setLength(0);
            } else {
                sb.append(str);
                i++;
            }
        }
        if (sb.length() > 0) {
            int gap = maxWidth - sb.length();
            for (int j = 0; j < gap; j++) {
                sb.append(" ");
            }
            res.add(sb.toString());
        }
        return res;
    }

    public void justfy(List<String> res, String str, int maxWidth) {
        // This    is   ban
        String[] strs = str.split(" ");
        if (strs.length == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(strs[0]);
            int gap = maxWidth - sb.length();
            for (int i = 0; i < gap; i++) {
                sb.append(" ");
            }
            res.add(sb.toString());
            return;
        } 

        int len = 0;
        for (String s : strs) {
            len += s.length();
        }
        int remainlen = maxWidth - len;
        int m = strs.length - 1;
        int cnt = remainlen / m;
        int remains = remainlen % m;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(strs[i]);
            for (int j = 0; j < cnt; j++) {
                sb.append(" ");
            }
            if (remains-- > 0) {
                sb.append(" ");
            }
        }
        sb.append(strs[m]);
        res.add(sb.toString());
    }
}