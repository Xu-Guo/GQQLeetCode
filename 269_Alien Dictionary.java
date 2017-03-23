public class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        if (words.length == 1) return words[0];
        Map<Character, Set<Character>> biggerMap = new HashMap<>();
        Map<Character, Integer> smallCntMap = new HashMap<>();
        int[] allChars = new int[26];
        // mark existing char as 1
        for (String wd : words) {
            for (char c: wd.toCharArray()) {
                allChars[c - 'a'] = 1;
            }
        }

        // initial biggerMap and smallCntMap
        for (int i = 1; i < words.length; i++) {
            initialMap(words[i - 1], words[i], biggerMap, smallCntMap);
        }

        Queue<Character> queue = new LinkedList<>();
        // start from the smallest character.
        for (Character c : smallCntMap.keySet()) {
            if (smallCntMap.get(c) == 0) {
                queue.add(c);
                // break;
            }
        }

        String result = "";
        while (!queue.isEmpty()) {
            char c = queue.poll();
            result += c;
            allChars[c - 'a'] = 0;
            Set<Character> biggers = biggerMap.get(c);
            // System.out.println(c);
            for (Character big : biggers) {
                int smallCnt = smallCntMap.get(big);
                if (--smallCnt == 0) queue.offer(big);
                smallCntMap.put(big, smallCnt);
            }
        }

        if (result.length() < biggerMap.size()) return "";
        for (int i = 0; i < 26; i++) {
            if (allChars[i] == 1) {
                result += (char)('a' + i);
            }
        }
        return result;
    }

    public void initialMap(String smaller, String bigger, Map<Character, Set<Character>> biggerMap, Map<Character, Integer> smallCntMap) {
        int i = 0;
        for (; i < smaller.length() && i < bigger.length() && smaller.charAt(i) == bigger.charAt(i); i++);

        if (i < smaller.length() && i < bigger.length()) {
            char schar = smaller.charAt(i);
            char bchar = bigger.charAt(i);
            if (!smallCntMap.containsKey(bchar)) {
                smallCntMap.put(bchar, 0);
            }
            if (!smallCntMap.containsKey(schar)) {
                smallCntMap.put(schar, 0);
            }
            if (!biggerMap.containsKey(schar)) {
                biggerMap.put(schar, new HashSet<Character>());
            }

            if (!biggerMap.containsKey(bchar)) {
                biggerMap.put(bchar, new HashSet<Character>());
            }

            if (biggerMap.get(schar).add(bchar)) {
                smallCntMap.put(bchar, smallCntMap.get(bchar) + 1);
            }
        }
    }
}