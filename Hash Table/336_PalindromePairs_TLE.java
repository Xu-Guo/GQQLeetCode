public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> lst = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word1 = words[i];
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                String word2 = words[j];
                if (isPalindrome(word1 + word2)) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    lst.add(tmp);
                }
            }
        }
        return lst;
    }

    public boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low <= high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
}