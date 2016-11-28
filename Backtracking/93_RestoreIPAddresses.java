public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> lst = new ArrayList<>();
        restoreIp(lst, new ArrayList<String>(), s, 0);
        return lst;
    }

    public void restoreIp(List<String> lst, List<String> tmp, String s, int start) {
        if (start == s.length() && tmp.size() == 4) {
            lst.add(String.join(",", tmp));
        } else if (start < s.length() && tmp.size() < 4) {
            for (int i=1; i<=4; i++) {
                String ele = s.substring(start, start+i);
                if ((ele.startwith('0') && ele.length()>1) || (ele.length()==3 && Integer.parseInt(ele)>255)) {
                    continue;
                }
                tmp.add(ele);
                restoreIp(lst, tmp, s, start+i);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}