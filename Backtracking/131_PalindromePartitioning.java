public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> lst = new ArrayList<>();
        backtract(lst, new ArrayList<String>(), s, 0);
        return lst;
    }

    public void backtract(List<List<String>> lst, List<String> tmplist, String s, int start) {
        if (start == s.length()) {
            lst.add(new ArrayList<String>(tmplist));
        } else {
            for (int i=start; i<s.length(); i++) {
                if (isPartitioning(s, start, i)) {
                    tmplist.add(s.substring(start, i+1));
                    backtract(lst, tmplist, s, i+1);
                    tmplist.remove(tmplist.size() - 1);
                }
            }
        }
    }

    private boolean isPartitioning(String s, int start, int end) {
        while(start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}