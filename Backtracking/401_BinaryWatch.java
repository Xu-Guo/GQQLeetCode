public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        if (num < 0 || num >= 10) {
            return res;
        }
        Map<Integer, Set<Integer>> hourMap = getHourMap();
        Map<Integer, Set<Integer>> minituesMap = getMinituesMap();
        int h = 0;
        while (h<=3 && h<=num) {
            int m = num - h;
            Set<Integer> hourlists = hourMap.get(h);
            Set<Integer> minituesList = minituesMap.get(m);
            if(hourlists != null && minituesList != null) {
                for (Integer hour : hourlists) {
                    for (Integer minitue: minituesList) {
                        String prefix = minitue<10 ? "0" : "";
                        res.add(hour + ":" + prefix + minitue);
                    }
                }
            }
            h++;
        }
        return res;
    }

    private Map<Integer, Set<Integer>> getHourMap() {
        Map<Integer, Set<Integer>> hourMap = new HashMap<>();
        for (int h=0; h<12; h++) {
            int key = getLightNumber(h);
            if (hourMap.containsKey(key)) {
                hourMap.get(key).add(h);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(h);
                hourMap.put(key, set);
            }
        }
        return hourMap;
    }

    private Map<Integer, Set<Integer>> getMinituesMap() {
        Map<Integer, Set<Integer>> minutesMap = new HashMap<>();
        for (int h=0; h<60; h++) {
            int key = getLightNumber(h);
            if (minutesMap.containsKey(key)) {
                minutesMap.get(key).add(h);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(h);
                minutesMap.put(key, set);
            }
        }
        return minutesMap;
    }

    private int getLightNumber(int t) {
        int num = 0;
        while (t>0) {
            if (t%2 == 1) {
                num++;
            }
            t /= 2;
        }
        return num;
    }
}