public class ValidWordAbbr {
    Set<String> set = new HashSet<>();
    Map<String, Integer> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for (String str : dictionary) {
            if (!set.contains(str)) {
                set.add(str);
                String abbr = getAbbr(str);
                map.put(abbr, map.getOrDefault(abbr, 0) + 1);
            }
        }
    }

    public String getAbbr(String str) {
        int n = str.length();
        if (n <= 2) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        sb.append(n - 2);
        sb.append(str.charAt(n - 1));
        return  sb.toString();
    }
    
    public boolean isUnique(String word) {
        if (set.contains(word)) {
            return map.get(getAbbr(word)) == 1 ? true : false;
        } else {
            // System.out.println(getAbbr(word));
            return map.containsKey(getAbbr(word)) ? false : true;
        }
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */