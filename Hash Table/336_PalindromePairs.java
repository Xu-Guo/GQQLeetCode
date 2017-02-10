public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Set<List<Integer>> lst = new HashSet<>();
        int n = words.length;
        if (n <= 1) return new ArrayList<List<Integer>>();
        Map<String, Integer> map = new HashMap<>();

        // add words to map
        for (int i = 0; i < n; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < n; i++) {
            String curr = words[i];
            // using j<=curr.length to include ""
            for (int j = 0; j <= curr.length(); j++) {
                String str1 = curr.substring(0, j);
                String str2 = curr.substring(j);
                if (isPalindrome(str1)) {
                    String str2rvs = reverse(str2);
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        lst.add(Arrays.asList(map.get(str2rvs), i));
                    }
                }
                if (isPalindrome(str2)) {
                    String str1rvs = reverse(str1);
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i) {
                        lst.add(Arrays.asList(i, map.get(str1rvs)));
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(lst);
    }

    private String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
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