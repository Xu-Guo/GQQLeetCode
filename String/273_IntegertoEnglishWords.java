public class Solution {
    static final Map<Integer, String> map;
    static {
        map = new HashMap<>();
        map.put(1, "One ");
        map.put(2, "Two ");
        map.put(3, "Three ");
        map.put(4, "Four ");
        map.put(5, "Five ");
        map.put(6, "Six ");
        map.put(7, "Seven ");
        map.put(8, "Eight ");
        map.put(9, "Nine ");
        map.put(10, "Ten ");
        map.put(11, "Eleven ");
        map.put(12, "Twelve ");
        map.put(13, "Thirteen ");
        map.put(14, "Fourteen ");
        map.put(15, "Fifteen ");
        map.put(16, "Sixteen ");
        map.put(17, "Seventeen ");
        map.put(18, "Eighteen ");
        map.put(19, "Nineteen ");
        map.put(20, "Twenty ");
        map.put(30, "Thirty ");
        map.put(40, "Forty ");
        map.put(50, "Fifty ");
        map.put(60, "Sixty ");
        map.put(70, "Seventy ");
        map.put(80, "Eighty ");
        map.put(90, "Ninety ");
    }
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int round = 3;
        String res = "";
        String[] arrRes = new String[4];
        Arrays.fill(arrRes, "");
        while (num > 0) {
            arrRes[round--] = hundredsNumberToWords(num % 1000);
            num /= 1000;
        }
        if (!arrRes[0].equals("")) res += arrRes[0] + "Billion ";
        if (!arrRes[1].equals("")) res += arrRes[1] + "Million ";
        if (!arrRes[2].equals("")) res += arrRes[2] + "Thousand ";
        res += arrRes[3];
        return res.trim();
    }

    public String hundredsNumberToWords(int num) {
        StringBuilder sb = new StringBuilder();
        int a = num / 100;
        int b = num % 100;
        if (map.containsKey(a)) {
            sb.append(map.get(a));
            sb.append("Hundred ");
        }
        if (b != 0)
            if (map.containsKey(b)) {
                sb.append(map.get(b));
            } else {
                sb.append(map.get(b - b%10));
                sb.append(map.get(b % 10));
            }
        return sb.toString();
    }
}