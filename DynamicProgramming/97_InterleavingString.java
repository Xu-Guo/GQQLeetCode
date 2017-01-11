public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 + len2 != s3.length()) {
            return false;
        }
        int[] r = new int[len2+1];
        r[0] = 1;
        for (int j=0; j<len2; j++) {
            if (r[j]==1 && s2.charAt(j)==s3.charAt(j)) {
                r[j+1] = 1;
            }
        }

        for (int i=1; i<len1; i++) {
            for (int j=0; j<len2; j++) {
                int first = 1;
                int second = 1;
                if (!(r[j]==1 && s1.charAt(i-1) == s3.charAt(i+j-1))) {
                    first = 0;
                }
                if (!(j>=1 && r[j-1]==1 && s2.charAt(j-1) == s3.charAt(i+j-1))) {
                    second = 0;
                }
                r[j] = first | second;
            }
        }
        return r[len2]==1 ? true : false;
    }
}