/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int curr = 0;
    public int read(char[] buf, int n) {
        if (n <= 0) return 0;
        if (curr >= n) return n;
        while (curr < n) {
            int res = read4(buf);
            if (res == 0) break;
            for (int i=0; i<res; i++) 
                ++curr;
        }
        return n;
    }
}