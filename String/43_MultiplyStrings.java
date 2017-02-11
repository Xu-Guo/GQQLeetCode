public class Solution {
    public String multiply(String num1, String num2) {
        String res = "0";
        if(num1.equals("0") || num2.equals("0")) return res;
        for (int i = 0; i < num2.length(); i++) {
            int d = Integer.parseInt(num2.charAt(num2.length() - 1 - i) + "");
            StringBuilder end = new StringBuilder();
            for (int j = 0; j < i; j++) {
                end.append("0");
            }
            // System.out.println(d);
            String curr = multOne(num1, d);
            // System.out.println(curr);
            String strend = end.toString();
            // res 
            res = merge(curr + strend, res);
        }
        return res;
    }

    private String merge(String a, String b) {
        // System.out.println("a is " + a);
        // System.out.println("b is " + b);
        StringBuilder sb = new StringBuilder();
        int remain = 0;
        char[] chra = a.toCharArray();
        char[] chrb = b.toCharArray();
        int aIndex = chra.length - 1;
        int bIndex = chrb.length - 1;
        while (aIndex >= 0 && bIndex >= 0) {
            // System.out.println("aIndex is " + aIndex);
            // System.out.println("bIndex is " + bIndex);
            int val = Integer.parseInt("" + chra[aIndex--]) + Integer.parseInt("" + chrb[bIndex--]) + remain;
            // System.out.println("val is " + val);
            sb.insert(0, (val % 10) + "");
            remain = val / 10;
        }

        while (aIndex >= 0) {
            int val = Integer.parseInt("" + chra[aIndex--]) + remain;
            sb.insert(0, (val % 10) + "");
            remain = val / 10;
        }

        while (bIndex >= 0) {
            int val = Integer.parseInt("" + chrb[bIndex--]) + remain;
            sb.insert(0, (val % 10) + "");
            remain = val / 10;
        }

        return remain > 0 ? remain + sb.toString() : sb.toString();
    }

    private String multOne(String strnum, int dig) {
        // System.out.println("strnum is " + strnum + " dig is " + dig);
        char[] chrnum = strnum.toCharArray();
        int right = 0, left = 0;
        String result = "";
        for (int i = chrnum.length - 1; i >= 0 ; i--) {
            int curr = Integer.parseInt(chrnum[i] + "");
            int val = curr * dig + left;
            left = val / 10;
            right = val % 10;
            result = right + result;
        }

        result = left > 0 ? left + result : result;
        return result;
    }
}