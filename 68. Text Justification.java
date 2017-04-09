public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        System.out.println(words.length);
        if (words == null || words.length == 0) return res;
        ArrayList<String> list = new ArrayList<String>();
        int len = 0;
        int i = 0;
        while (i < words.length) {
            len += list.size() == 0 ? words[i].length() : words[i].length() + 1;
            // System.out.println(len);
            if (len == maxWidth) {
                list.add(words[i]);
                res.add(String.join(" ", list));
                i++;
                len = 0;
                list.clear();
            } else if (len > maxWidth) {
                justfy(res, list, maxWidth);
                len = 0;
                list.clear();
            } else {
                list.add(words[i]);
                if (i == words.length - 1) {
                    StringBuilder sb = new StringBuilder();
                    int gap = maxWidth - len;
                    for (int j = 0; j < gap; j++) {
                        sb.append(" ");
                    }
                    res.add(String.join(" ", list) + sb.toString());
                }
                i++;
            }
        }
        return res;
    }

    public void justfy(List<String> res, List<String> list, int maxWidth) {
        // This    is   ban
        if (list.size() == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(0));
            int gap = maxWidth - sb.length();
            for (int i = 0; i < gap; i++) {
                sb.append(" ");
            }
            res.add(sb.toString());
            return;
        } 

        int len = 0;
        for (String s : list) {
            len += s.length();
        }
        int remainlen = maxWidth - len;
        int m = list.size() - 1;
        int cnt = remainlen / m;
        int remains = remainlen % m;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(list.get(i));
            for (int j = 0; j < cnt; j++) {
                sb.append(" ");
            }
            if (remains-- > 0) {
                sb.append(" ");
            }
        }
        sb.append(list.get(m));
        res.add(sb.toString());
    }
}