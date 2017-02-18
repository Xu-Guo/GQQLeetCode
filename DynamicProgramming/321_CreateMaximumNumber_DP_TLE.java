public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        String[][][] res = new String[m+1][n+1][m+n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int t = 0; t <= m+n; t++) {
                    res[i][j][t] = "";
                }
            }
        }
        // init results with nums1
        for (int i = 1; i <= m; i++) {
            for (int t = 1; t <= i; t++) {
                res[i][0][t] = getLargestString(res[i-1][0][t], res[i-1][0][t-1] + nums1[i-1]);
            }
        }
        for (int j = 1; j <= n; j++) {
            for (int t = 1; t <= j; t++) {
                res[0][j][t] = getLargestString(res[0][j-1][t], res[0][j-1][t-1] + nums2[j-1]);
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for(int h = 1; h <= i+j; h++) {
                    res[i][j][h] = getLargestString(res[i-1][j][h],
                        res[i][j-1][h],
                        res[i-1][j][h-1]+nums1[i-1],
                        res[i][j-1][h-1]+nums2[j-1]);
                    if (i == m && j == n && h == k) break;
                }
            }
        }
        return getArrayFromString(res[m][n][k]);
    }

    public int[] getArrayFromString(String s) {
        int n = s.length();
        int[] res = new int[n];
        for (int i=0; i<n; i++) {
            res[i] = s.charAt(i) - '0';
        }
        return res;
    }



    public String getLargestString(String str1, String str2) {
        return str1.compareTo(str2) >= 0 ? str1 : str2;
    }

    public String getLargestString(String str1, String str2, String str3, String str4) {
        String maxString = str1;
        if (str2.compareTo(maxString) > 0) maxString = str2;
        if (str3.compareTo(maxString) > 0) maxString = str3;
        if (str4.compareTo(maxString) > 0) maxString = str4;
        return maxString;
    }
}