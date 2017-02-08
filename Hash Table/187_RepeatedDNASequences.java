public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i <= n - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (map.containsKey(sub)) {
                map.put(sub, map.get(sub) + 1);
            } else {
                map.put(sub, 1);
            }
        }

        for (String key : map.keySet()) {
            int value = map.get(key);
            if(value > 1) result.add(key);
        }
        return result;
    }
}