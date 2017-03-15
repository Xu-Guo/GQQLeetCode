public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            String key = doHash(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    // how to get a key.
    // zbe -24-> 2, 4-1 = 3. "2_3_" is the key.
    public String doHash2(String str) {
        if(str.length() == 1) return "-1";

        String key = "";
        for (int i = 0; i < str.length() - 1; i++) {
            int val = str.charAt(i + 1) - str.charAt(i);
            if (val < 0) val = 26 + val;
            key += val + "_";
        }
        return key;
    }

    // ybc offset 24. 'b'-24+26
    public String doHash(String str) {
        String key = "";
        int offset = str.charAt(0) - 'a';
        for (int i=0; i<str.length(); i++) {
            char res = str.charAt(i) - offset;
            if (res < 'a') res += 26;
            key += res;
        }
        return key;
    }
}