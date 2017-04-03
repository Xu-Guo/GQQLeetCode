public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 0) return true;
        Map<Character, Character> first = new HashMap<>();
        Map<Character, Character> second = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chrs = s.charAt(i);
            char chrt = t.charAt(i);
            if (first.containsKey(chrs)) {
                if (first.get(chrs) != chrt) return false;
                if (!second.containsKey(chrt) || second.get(chrt) != chrs) return false;
            } else {
                if (second.containsKey(chrt)) return false;
                first.put(chrs, chrt);
                second.put(chrt, chrs);
            }
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 0) return true;
        int[] first = new int[256];
        int[] second = new int[256];
        for (int i = 0; i < s.length(); i++) {
            int chrs = (int)s.charAt(i);
            int chrt = (int)t.charAt(i);
            if (first[chrs] == 0) {
                if (second[chrt] != 0) return false;
                first[chrs] = chrt;
                second[chrt] = chrs;
            } else {
                if (first[chrs] != chrt) return false;
                if (second[chrt] != chrs) return false;
            }
        }
        return true;
    }
}