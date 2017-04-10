public class Solution {
    public List<String> generatePalindromes(String s) {
        Set<Character> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            // set
            if (!set.add(c)) set.remove(c);
            // map
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        if (set.size() > 1) return result;
        String mid = "";
        Iterator it = set.iterator();
        if (it.hasNext()) mid = "" + it.next();
        List<Character> list = new ArrayList();
        for (Character key : map.keySet()) {
            int cnt = map.get(key);
            for (int i = 0; i < cnt / 2; i++) {
                list.add(key);
            }
        }

        Collections.sort(list);
        List<String> subres = new ArrayList<>();
        boolean[] used = new boolean[list.size()];
        helper(list, used, "", subres);

        for (String sub : subres) {
            result.add(sub + mid + new StringBuilder(sub).reverse());
        }
        return result;
    }

    public void helper(List<Character> list, boolean[] used, String tmp, List<String> res) {
        if (tmp.length() == list.size()) {
            res.add(tmp);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (used[i]) continue;
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;
            used[i] = true;
            helper(list, used, tmp + list.get(i), res);
            used[i] = false;
        }
    }
}