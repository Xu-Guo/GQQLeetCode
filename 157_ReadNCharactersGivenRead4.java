/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if (n == 0) return 0;
        int curr = 0;
        char[] cache = new char[4];
        while (curr < n) {
            int len = read4(cache);
            if (len == 0) break;
            for (int i=0; i<len; i++) {
                buf[curr++] = cache[i];
                if (curr == n) break;
            }
        }
        return curr;
    }
}