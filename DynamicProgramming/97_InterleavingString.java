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

        for (int i=0; i<len1; i++) {
            if (r[i]==1 && s1.charAt(i) == s3.charAt(i)) {
                
            }
        }
    }
}